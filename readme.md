# Paso 1: Generar Imagen del Mysql 

 Le estamos asignando nombre al contenedor, credenciales , base de datos y basado a que imagen se va levantar nuestro contenedor

docker run --name mysql-standalone -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=test -e MYSQL_USER=sa -e MYSQL_PASSWORD=password -d mysql:5.6


# Paso 2: Generar imagen del jar

 Con estos comandos estoy considerando que el jar del proyecto realizara un comando de maven clean package dentro del container

FROM maven:3.6.3-jdk-11-slim AS stage1
WORKDIR /root/
COPY .  /root/proyect/
RUN mvn -f /root/proyect/pom.xml clean package

 Ahora, si queremos levantar el jar en el container con estos comandos nos apoyamos.

FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 7070
COPY --from=stage1 /root/proyect/target/demo-docker-0.0.1-SNAPSHOT.jar demo-docker-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["sh","-c","java -jar /demo-docker-0.0.1-SNAPSHOT.jar"]

 Nota: Se debe realizar antes de generar la imagen el maven clean e install del proyecto



# Paso 3: Generamos nuestro nuestra imagen del jar con el comando.

docker image build -t conexionMysql . 


# paso 4: levantamos el contenedor (Importante: Para que se comuniquen los contenedores utilizamos el flag --link)

docker run -p 8082:8080 --name conexion-jar --link mysql-standalone:mysql -d conexionMysql

