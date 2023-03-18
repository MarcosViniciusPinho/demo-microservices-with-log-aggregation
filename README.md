# Applying log aggregation pattern in microservices

Quando o assunto é microserviço sabemos que é de extrema importância aplicarmos o pattern log aggregation, não é mesmo?<br />
Para quem não sabe ou não ouviu falar deste pattern, o mesmo tem a motivação de resolver o problema de termos multiplos logs espalhados por todo nosso ecossistema de microserviços, onde o mesmo centraliza todos os logs em um único lugar fazendo isto ajuda demais a equipe na monitoria das apps.

Bom, vamos começar...
Para poder dar continuidade é obrigatório ter o docker e docker-compose instalados na máquina, caso não os tenha por favor faça suas respectivas instalações.

Agora para dar um melhor entendimento geral deste projeto o mesmo esta dividido basicamente em seus microserviços com o log aggregation, conforme a imagem abaixo: 
#![](images/microservices_division.png)

Podemos ver nesta imagem que existem 3 microserviços disponíveis que são os: **demoA-api, demoB-api e o demoC-api.**

<ul>
    <li>demoA-api -> é basicamente um gateway que fica disponível para ser acessado de forma externa e repassa a requisição para o microservice demoB-api.</li>
    <li>demoB-api -> que está inacessivel de forma externa e somente visivel na rede interna e que passa a requisição para o outro microservice demoC-api.</li>
    <li>demoC-api -> que também esta inacessível de forma externa e apenas acessível na rede interna.</li>
    <li>elasticstack -> é nossa agregação de log que monitora os logs de microsserviços e os recupera.</li>
</ul>

Agora vamos entender com um olhar dentro do elasticstack como foi dividido  e como foi construido desde pegar o log, processá-lo e disponibilizá-lo de forma visual, conforme imagem abaixo:
#![](images/elasticstack_division.png)

Podemos ver nesta imagem que existem 4 dockers disponíveis que são os: **Filebeat, Logstash, Elasticsearch e Kibana.**

<ul>
    <li>Filebeat -> recebe os logs dos containers que estão na mesma rede e os envia para o logstash</li>
    <li>Logstash -> recebe os logs de filebeat e os processa, no caso estamos processando apenas as informações contidas em nossos microserviços. Após o processamento, o mesmo os envia para o elasticsearch.</li>
    <li>Elasticsearch -> recebe os logs e os armazena. Conseguimos visualizar os logs de forma visual aqui, onde também é possível criar querys em cima destes logs.</li>
    <li>Kibana -> basicamente é uma interface de forma exclusiva para acessar os logs contidos no Elasticsearch, inclusive é o mais utilizado para visualização. Com ele é possível criar dashborads e etc...</li>
</ul>

**Considerações importantes:**
<ul>
    <li>A ideia deste projeto foi mais focado para demonstrar a aplicação do pattern log aggregation e isto implica na infra do mesmo, os microservices em si não são relevantes, são bem triviais mesmo.</li>
    <li>O projeto foi criado para poder rodar em qualquer sistema operacional desde que esteja com o docker e o docker-compose instalados.</li>
    <li>Existem outros tipos de configurações e formas de fazer, porém o intuito aqui é ser o mais simples possível para ter uma melhor absorção do conhecimento deste pattern tanto na teoria quanto na prática.</li>
</ul>

Bom... Chegou a hora, vamos rodar essa brincadeira toda? ;)

1) Primeiro devemos iniciar todos os nossos microservices, assim como o nosso log aggregation. Vamos digitar o comando no terminal: `docker-compose up -d`
2) Vamos aguardar alguns segundos para a solução subir de forma completa, assim que o ambiente estiver disponível acessar a seguinte URL: [http://localhost:5601/login?next=%2F]()
3) Iremos visualizar esta tela:
#![](images/login_elastic.png)

Obs: O usuário e senha serão preenchidos de forma automática, porém de qualquer forma as credencais de acesso são elastic(user) e changeme(password)

4) Logo após logar, vá na menu na parte lateral, vá em Analytics e selecione a opção de "Discover", segue imagem para ajuda:
#![](images/selected_discover_create_index.png)

5) Após clicar em "Discover" irá aparecer o seguinte modal, que é para a criação de um index. Clique no botão "Create index pattern" e assim que o fizer irá aparecer a seguinte tela, conforme a imagem abaixo:
#![](images/create_index_pattern.png)

Na primeira informação a ser fornecida, devemos adotar o padrão de contains; ou seja; posso informar o `filebeat-*` que ele me traz todos os logs, caso queremos algo especifico só precisamos informar o `filebeat-7.16.3-2023.03.*` 

6) Vamos executar o curl: `curl --location --request GET 'http://localhost:8080'` já para aparecer nos logs.

7) Depois que criarmos este index, devemos retornar ao menu "Discover" novamente que iremos ter como resultado os logs, conforme imagem a seguir:
#![](images/detail_logs.png)