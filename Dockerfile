FROM maven:3.6.3-jdk-11-slim AS stage1
WORKDIR /root/
COPY .  /root/proyect/
RUN mvn -f /root/proyect/pom.xml clean package
