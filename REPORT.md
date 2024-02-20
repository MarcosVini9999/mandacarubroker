## Rotas 👮
Este conjunto de rotas define uma API RESTful para gerenciar informações sobre ações.

Rotas disponíveis:

- GET /stocks: Recupera uma lista de todas as ações.
- GET /stocks/{id}: Recupera informações detalhadas de uma ação específica usando seu identificador único.
- POST /stocks: Cria uma nova ação na base de dados.
- PUT /stocks/{id}: Atualiza as informações de uma ação existente.
- DELETE /stocks/{id}: Exclui uma ação da base de dados.
### Usando o Swagger para documentar as rotas

O Swagger foi utilizado para documentar um conjunto de rotas que gerenciam informações sobre ações. Essa documentação foi gerada automaticamente com o auxílio do Swagger Editor. Assim como mostrado na imagem abaixo.
![image](https://github.com/MarcosVini9999/mandacarubroker/assets/66041553/d913dddf-4efa-49d7-a905-2c8693f00d7c)

#### Benefícios de usar o Swagger:

- Documentação clara e concisa: O Swagger gera documentação HTML que descreve cada rota, seus parâmetros, respostas e exemplos de uso.
- Interatividade: A documentação do Swagger é interativa, permitindo que os desenvolvedores testem as rotas diretamente na interface.
- Maior adoção da API: Uma API bem documentada com o Swagger é mais fácil de ser utilizada e compreendida por outros desenvolvedores, o que pode aumentar a adoção da sua API.


## Testes 🔧🔨

`Testes dinâmicos unitários`, usando o Junit, foram realizados para garantir a robustez e confiabilidade do sistema de estoque. O foco principal se concentrou em três componentes cruciais: o Controller de Stock, o Service de Stock e a classe Stock em si.

### StockServiceTests
Testes abrangentes asseguraram que o Service de Stock gerenciava o estoque. As operações de CRUD (Criação, Leitura, Atualização e Exclusão) foram testadas de formas diferentes, como por exemplo enviando dados válidos, e dados não válidos.
![image](https://github.com/MarcosVini9999/mandacarubroker/assets/66041553/6b22d370-12bf-4f05-893e-5faaf948d185)

### StockControllerTests
Testes meticulosos verificaram se o Controller de Stock processava as requisições HTTP de forma adequada, como mostrado nos "SHOULD"s da imagem abaixo, manipulando os dados de entrada e saída. O uso do mockMVC foi crucial para isso, pois facilitou a chamada das funções. Outrossim, é interessante dizer que antes e depois de cada teste unitário é criado um Stock com uma rota, e no final de cada teste é deletado tal Stock, optei por fazer assim, pois estava ocupando espaço no banco com vários Stock's iguais com ids diferentes.
![image](https://github.com/MarcosVini9999/mandacarubroker/assets/66041553/69bfe459-1d0c-4192-a966-264e065e8966)

- Should Save
![image](https://github.com/MarcosVini9999/mandacarubroker/assets/66041553/93ef9215-0619-4095-9c03-5df91afb8304)

- Should Delete
![image](https://github.com/MarcosVini9999/mandacarubroker/assets/66041553/db34a141-95fc-4dde-bc44-6a0a8c610d4d)

### StockTest
Testes também verificaram o comportamento da classe Stock, validando suas propriedades e métodos, como mostrado na imagem abaixo.
![image](https://github.com/MarcosVini9999/mandacarubroker/assets/66041553/4b6133e0-47fc-4e73-82ab-dac36aee5676)

## Diagramas UML 📈📊
A `documentação UML` (Unified Modeling Language) é uma linguagem gráfica que permite visualizar e documentar o design de sistemas de software. Através de diversos diagramas, como de classes, sequências e estados, a UML facilita a compreensão da arquitetura do sistema, suas funcionalidades e o comportamento dos seus componentes.

Dessa forma, para fins de documentação foram gerados os diagramas de classes das classes testadas, como mostrado nos itens abaixo.
### Stock
![image](https://github.com/MarcosVini9999/mandacarubroker/assets/66041553/428a6f01-88e0-4b93-8a66-49c213275323)

### RequestStockDTO
![image](https://github.com/MarcosVini9999/mandacarubroker/assets/66041553/1000aa3c-0f97-4e33-9267-362f509aac74)

### StockService
![image](https://github.com/MarcosVini9999/mandacarubroker/assets/66041553/9becb614-71dc-45ae-abc6-36e21da7629b)

### StockController
![image](https://github.com/MarcosVini9999/mandacarubroker/assets/66041553/b9d296ce-fd4d-45bf-8230-ae52ad707dd2)


## SonarQube ⚙
O SonarQube é uma ferramenta poderosa para garantir a qualidade do código no projeto de gerenciamento de Stock.

Dessa forma, foram detectados 27 `issues`, 4 com impacto grande, essees se referem à 4 casos de testes não implementados, mas planejados. Um de impacto médio, falando sobre o Regex do DTO, e outros 22 de pequeno impacto relacionadas à código Java.
![image](https://github.com/MarcosVini9999/mandacarubroker/assets/66041553/ff8009c2-6b04-4109-9088-a8e0cc252f06)

### Impacto grande 🔴
![image](https://github.com/MarcosVini9999/mandacarubroker/assets/66041553/f4ee4c9f-ef72-40f7-b014-d8bbc1e0713c)

### Impacto médio 🟡
![image](https://github.com/MarcosVini9999/mandacarubroker/assets/66041553/ed2120c9-c7dd-4309-b30d-f52df785675b)

### Impacto pequeno 🟢
![image](https://github.com/MarcosVini9999/mandacarubroker/assets/66041553/f235a4dc-5de4-46cf-b11e-0b1d28940da3)

## CheckStyle ✏️
O uso do checkStyle foi responsável pelos `testes estáticos` do projeto. Dessa forma, afim de exibir as potenciais melhorias de padronização, foi utilizado o template do google, como mostrado na imagem abaixo, onde é possível ver avisos de que existem espaços em brancos entre atribuições, formas de importações à serem evitadas, formas de abreviações e entre outras.

### Google Checks
![image](https://github.com/MarcosVini9999/mandacarubroker/assets/66041553/80fe82a7-e90d-4981-a4f6-c88bd9932a3d)

## Dependências não usadas e não declaradas que foram mapeadas
![image](https://github.com/MarcosVini9999/mandacarubroker/assets/66041553/5cb5d5c5-8c5b-4305-aa9d-397d3602f54c)
