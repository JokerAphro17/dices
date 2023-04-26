FROM  openjdk:17-jdk-alpine
LABEL authors="JokerAphro"


# Install dependencies
# Installe MySQL Server
RUN apt-get update && \
    apt-get install -y mysql-server && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/

# Compile the project

Run mvn clean install

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Ajoutez les instructions suivantes pour configurer MySQL et créer une base de données
RUN service mysql start && \
    mysql -u root -e "CREATE DATABASE dices" && \
    mysql -u root -e "CREATE USER 'gamer'@'%' IDENTIFIED WITH mysql_native_password BY 'password'" && \
    mysql -u root -e "GRANT ALL ON dices.* TO 'gamer'@'%'" && \
    mysql -u root -e "FLUSH PRIVILEGES" && \
    service mysql stop \


COPY application.properties /app/config/

ENTRYPOINT ["java","-jar","/app.jar"]