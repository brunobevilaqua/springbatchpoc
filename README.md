# Spring Batch POC
- Java11
- MySQL 
- Docker

***

### 1. Steps para Rodar Localmente:
1. `mvn install`
2. `docker-compose up -d`
3. run `SpringbatchpocApplication`

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