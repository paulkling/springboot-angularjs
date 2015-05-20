package com.company.springbootangularjs.core.modules


import groovy.util.logging.Slf4j
import org.springframework.stereotype.Component

import javax.print.PrintService
import javax.print.PrintServiceLookup
import java.util.concurrent.CopyOnWriteArrayList

@Component
@Slf4j
class PrintServiceFinderModule  {

    CopyOnWriteArrayList<PrintService> printServices = []

    PrintService[] findAll() {
        PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null)
        log.info("${services.size()} print services found..")
        printServices.addAllAbsent(services.toList())
        return services
    }

    PrintService find(String name) {
        PrintService printService = _find(name)
        if (!printService) {
            log.warn("Printer not found ${name}. Reinitializing print services..")
            findAll()
        }
        printService = _find(name)
        if (!printService) {
            log.warn("Printer not found ${name}, event after re-intializing..Contact support")

        }
        return printService
    }

    private PrintService _find(String name) {
        printServices.find() { it.name.contains(name) }
    }

}