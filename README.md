# Arquitetura Hexagonal 🔷

A Arquitetura Hexagonal, ou Ports and Adapters, isola o código de domínio do restante da aplicação, proporcionando flexibilidade, testabilidade e manutenibilidade.

## Princípios Fundamentais 🌐

### 1. Domínio:
   - Refere-se à lógica do negócio, incluindo regras e processos.
   - Classes de domínio não devem depender de classes relacionadas com infraestrutura, tecnologias ou sistemas externos.
   - Elas não conhecem as tecnologias – bancos de dados, interfaces com usuário e quaisquer outras bibliotecas – usadas pelo sistema.
   - A comunicação entre as classes de dominio e de infraestrutura é mediada por adaptadores.

### 2. Inversão de Dependência:
   - Este princípio diz que devemos depender de abstrações, e não de implementações.
   - Na prática, isso significa que, no contexto da orientação a objetos, devemos fazer com que nossa classe utilize interfaces para receber suas dependências, e não classes concretas.

## Estrutura Hexagonal 🔄

<img src="https://github.com/thaisbbreder-zup/bancoDigital/assets/133882082/f4919695-e502-44ae-a5c2-7b3eea029bb8"  height="200">
<img src="https://github.com/thaisbbreder-zup/bancoDigital/assets/133882082/ba97e47d-a7c7-407d-ad72-c0ba6c55c1bc"  height="200">

### 1. Centro do Hexágono:
   - Modelos, domínios e regras de negócios.
   - Totalmente isolado de ocorrências externas,  por exemplo, o banco de dados que será utilizado, framework frontend.

### 2. Lado Esquerdo do Hexágono:
   - Ator principal, lado do usuário que conduz a ação, lado do usuário que realiza alguma tarefa.

### 3. Lado Direito do Hexágono:
   - Ator secundário, lado dos dados conduzido, seja para escrever dados, ler dados, modificar dados, e apagar dados.

### 4. Portas e Adaptadores:
   - Portas: são a comunicação gateway entre o centro de seu hexágono com os lados esquerdo e direito do seu hexágono, com os lados externos.
   - Adaptadores: são os usuários das portas. Para cada porta que seu hexágono possui, um adaptador deve ser criado, portanto, você tem a liberdade de modificá-lo e apagá-lo dinamicamente.

## Entendendo melhor 🤓
Em um fluxo real, usando como exemplo o simples registro de dados, teríamos o seguinte:
1. O lado esquerdo (o condutor) entrega as informações, usando um adaptador e através da porta principal, ao centro do hexágono (domínio).
2. O centro do hexágono, então, recebe dados através da porta, depois os processa usando uma porta secundária e chama o lado direito.
3. O lado direito (o conduzido) chama um banco de dados para registrá-los.

No final, teríamos isto como o fluxo do Hexágono:
 __Lado esquerdo -> Centro -> Lado direito__

Mas este cenário impacta os conceitos da Arquitetura Hexagonal, que é que o domínio deve ser isolado e responsável apenas pela regra de negócio, pois no exemplo acima, teria que ser responsável por chamar a entidade responsável pela gravação.
Agora, surge o conceito de __Inversão de Controle (IoC)__.

Inversão de Controle (IoC) é um padrão que defende o uso de instâncias de uma determinada classe, tratando-a externamente e não dentro da classe em questão, ou seja, delegando o controle de uma classe para outra. Ela pode ser uma interface, componente, serviço, etc.

Em nosso caso, ele inverterá precisamente a ordem de fluxo, assegurando que, ainda usando o exemplo, nosso banco de dados vá para nosso centro e não para o outro lado, deixando nosso domínio realmente isolado.
No final, este seria o nosso fluxo correto:
__Left side -> Center <- Ioc- Right side__
 
## Migração de MVC para Hexagonal 🔄
  - MVC: No MVC, o modelo representa os dados e a lógica de negócios do aplicativo, a visão é responsável por exibir os dados para o usuário e o controlador atua como um intermediário entre o modelo e a visão, gerenciando a entrada do usuário e coordenando as atualizações do modelo e ver. Esse padrão promove a separação de preocupações, facilitando a manutenção e a extensão do aplicativo e permitindo várias visualizações dos mesmos dados.
   - Sinais de migração incluem complexidade, dificuldade de testabilidade, limitação de reutilização e falta de portabilidade.
   - Arquitetura Hexagonal oferece modularidade e sustentabilidade.
 - Recomendado para sistemas complexos que demandam manutenção e novas features.
   - Pode ser evitado em sistemas pequenos devido ao alto esforço de desenvolvimento.


## Resumo 📝
A arquitetura hexagonal é uma forma de organizar o código em camadas, cada qual com a sua responsabilidade, tendo como objetivo isolar totalmente a lógica da aplicação do mundo externo. Este isolamento é feito por meio de Portas e Adaptadores (daí o nome Ports and Adapters), onde as Portas são as interfaces que as camadas de baixo nível expõe, e Adaptadores as implementações para as interfaces em questão (inversão de dependência). 
