# work-03
Work with spring hibernate H2 Metrics - Note to be corrected

Teste prático - Marcos

Requisitos

- Java 1.7.x
- Jboss 6.4 EAP GA
- H2 3.0.1
- Maven 3.x
- Postgres 9.1

1) Execução de script de banco:

Para criação da massa de dados é necessário execução do script sql localizado em:

vectorx/database/script.sql

Obs: O script deve ser executado tanto no banco de dados H2 quanto no postgres.

No banco de dados H2 as credenciais utilizadas foram 

- Url: jdbc:h2:file:~/test
- Usuário: sa
- Senha: (em branco)

No banco de dados Postgres as credenciais utilizadas foram 

- Url: jdbc:postgresql://localhost:5432/postgres
- Usuário: postgres
- Senha: admin

2) Para compilar o projeto gerando o arquivo de instalaão WAR é necessário executar o seguinte comando maven:

 ​mvn -T 4 -U clean package 
 
3) Para alteração de banco de dados Postgres/H2 é necessário alterar o arquivo persistence.xml:

Para banco de dados H2 utilizar:

    <property name="javax.persistence.jdbc.url" value="jdbc:h2:file:~/test" />
    <property name="javax.persistence.jdbc.user" value="sa" />
    <property name="javax.persistence.jdbc.driver" value="org.h2.Driver" />
    <property name="javax.persistence.jdbc.password" value="" />
    <property name="hibernate.dialect" value="org.hibernate.dialect.H2Dialect"/>
            
Para banco de dados Postgres utilizar:

    <property name="javax.persistence.jdbc.url" value="jdbc:postgresql://localhost:5432/postgres" />
    <property name="javax.persistence.jdbc.user" value="postgres" />
    <property name="javax.persistence.jdbc.driver" value="org.postgresql.Driver" />
    <property name="javax.persistence.jdbc.password" value="admin" />
    <property name="hibernate.dialect" value="org.hibernate.dialect.PostgreSQLDialect"/>

