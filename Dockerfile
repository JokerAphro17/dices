
FROM  ubuntu:22.04
LABEL authors="JokerAphro"



# Install dependencies
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk && \
    apt-get install -y git && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/
# Installe MySQL Server
RUN apt-get update && \
    apt-get install -y mysql-server && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/

# Compile the project
COPY pom.xml /app/
WORKDIR /app
RUN mvn clean install


ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
RUN pwd && ls -l

# Ajoutez les instructions suivantes pour configurer MySQL et créer une base de données
RUN service mysql start && \
    mysql -u root -e "CREATE DATABASE dices" && \
    mysql -u root -e "CREATE USER 'gamer'@'%' IDENTIFIED WITH mysql_native_password BY 'password'" && \
    mysql -u root -e "GRANT ALL ON dices.* TO 'gamer'@'%'" && \
    mysql -u root -e "FLUSH PRIVILEGES" && \
    service mysql stop \



COPY application.properties /app/config/

ENTRYPOINT ["java","-jar","/app.jar"]
