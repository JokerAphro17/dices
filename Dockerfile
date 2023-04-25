FROM  openjdk:17-jdk-alpine
LABEL authors="JokerAphro"

# Install dependencies
# Installe MySQL Server
RUN apt-get update && \
    apt-get install -y mysql-server && \
    rm -rf /var/lib/apt/lists/

# Ajoutez les instructions suivantes pour configurer MySQL et créer une base de données
RUN service mysql start && \
    mysql -u root -e "CREATE DATABASE dices" && \
    mysql -u root -e "CREATE USER 'gamer'@'%' IDENTIFIED WITH mysql_native_password BY 'Ulquiora@04'" && \
    mysql -u root -e "GRANT ALL ON dices.* TO 'gamer'@'%'" && \
    mysql -u root -e "FLUSH PRIVILEGES" && \
    service mysql stop \



ENV MYSQL_ROOT_PASSWORD Ulquiora@04
ENV MYSQL_DATABASE dices
ENV MYSQL_USER gamer
ENV MYSQL_PASSWORD Ulquiora@04

COPY application.properties /app/config/

