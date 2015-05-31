package com.lifetouch.devicecontroller.core.modules

import groovy.util.logging.Slf4j
import org.springframework.stereotype.Component

import javax.print.PrintService
import javax.print.PrintServiceLookup
import java.util.concurrent.CopyOnWriteArrayList

@Component
@Slf4j
class PrintServiceFinderModule  {

     List<PrintService> printServices = new CopyOnWriteArrayList<PrintService>()

    PrintService[] findAll() {
        PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null)
        log.info("${services.size()} print services found..")
        printServices.addAllAbsent(services.toList())
        return services
    }

    PrintService find(String name) {
        PrintService printService = findPrintService(name)
        if (!printService) {
            log.warn("Printer not found ${name}. Reinitializing print services..")
            findAll()
        }
        printService = findPrintService(name)
        if (!printService) {
            log.warn("Printer not found ${name}, event after re-intializing..Contact support")
        }
        return printService
    }

    private PrintService findPrintService(String name) {
        printServices.find  {
                              it.name.toUpperCase().contains(name.toUpperCase()) ||
                              it.name.toUpperCase().replaceAll(ESCAPE_CHAR, SPACE_CHAR)
                                                   .contains(name.toUpperCase().replaceAll(HYPHEN_CHAR, SPACE_CHAR))
                            }
    }

    private static final String SPACE_CHAR = ' '
    private static final String HYPHEN_CHAR = '_'
    private static final String ESCAPE_CHAR = '\\\\'
}
