# User Account Management

A simple web app to store and manage user accounts.

## Getting Started

### Prerequisites

This application requires Java 1.8, Gradle, npm and Mysql server to be already installed.

### Mysql setup

There must be a mysql server running in order to start using the application. The following commands correspond to the java application db configuration. No need to create a schema since Hibernate will take care of it. 

```
mysql> create database useraccountdb;
mysql> create user 'userAccountDbAdmin'@'localhost' identified by 'ruskaSalata651';
mysql> grant all privileges on useraccountdb.* to 'userAccountDbAdmin'@'localhost';
```

## Running the Java app

```
user@user-thinkpad:~/user-account-management/user-account-management-backend$ ./gradlew clean build
user@user-thinkpad:~/user-account-management/user-account-management-backend$ java -jar build/libs/{GENERATED_JAR_NAME}.jar
```

## Running the React app

```
user@user-thinkpad:~/user-account-management/user-account-management-frontend$ npm install
user@user-thinkpad:~/user-account-management/user-account-management-frontend$ npm start
```

### Adding some test data:

```
mysql> use useraccountdb;
mysql> insert into useraccount (id, first_name, last_name, email_address, date_of_birth)
values
    (1, 'John', 'Doe', 'johndoedoe@gmail.com', '19901010'),
    (2, 'Jane', 'Doe', 'janedoe@gmail.com', '19901010'),
    (3, 'Alice', 'Cooper', 'alicecooper@gmail.com', '19870202'),
    (4, 'Bob', 'Dylan', 'bobdylan@gmail.com', '19641201');
```

