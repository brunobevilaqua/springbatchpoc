# Spring Batch POC
- Java11
- MySQL 
- Docker

***

### Logs
A app utiliza o log4j2 (log4j.xml) gravando os logs em: 
> `/logs/app.log`

***

### 1. Steps para Rodar Localmente:
- 1.1: `mvn clean install -U`
- 1.2: `docker-compose up --build -V`
- 1.3: rode a classe `SpringbatchpocApplication` com os seguintes argumentos:
    - `customerFile=file:files/customers.txt customersDelimitedFile=file:files/customers_delimited.txt`
      
***

### 2. Spring Batch Metadados:
_A cada execução de um Job(Batch) ou Step o sprin-batch salva no banco de dados metadados
referentes a cada execução._ 

> - **Como verificar quantas execuções lógicas tiveram para esse Batch:**
>    - `select * from BATCH_JOB_INSTANCE;`

> - **Como saber quantas vezes o job rodou ao total, incluindo execuções incompletas (falhas):**
>    - `select * from BATCH_JOB_EXECUTION;`

> - **Quais dados foram salvos no contexto de execução do JOB:**
>    - `select * from BATCH_JOB_EXECUTION_CONTEXT;`

> - **Como saber quais Steps foram executados:**
>    - `select * from BATCH_STEP_EXECUTION;`

> - **Quais dados foram salvos no contexto de execução do Step:**
>    - `select * from BATCH_STEP_EXECUTION_CONTEXT;`

***