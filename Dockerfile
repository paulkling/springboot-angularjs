FROM paulkling/tomcat:8
MAINTAINER Paul Kling <pkling@gmail.com>

RUN rm -r /tomcat/webapps/ROOT 
ADD build/libs/springboot-angularjs-0.0.1.war /tomcat/webapps/ROOT.war
WORKDIR /

EXPOSE 8080
CMD ["/run.sh"]
