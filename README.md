# Aula 004

## Prática

### Projeto Banco de base

1. Criar um novo projeto chamado **Banco** (SEM classe principal)
2. Criar um novo pacote chamado **com.aula.banco**
3. Criar uma nova _Classe Principal Java_ chamada **Principal** (está classe irá conter o método main)
4. Criar uma nova _Classe Java_ chamada **ContaCorrente**
* Na classe **ContaCorrente** criar os atributos: numero, nome, saldo (publicos)
```java
    public int numero;
    public String nome;
    public int saldo;
```
* Criar os métodos sacar e depositar  (publicos)
```java
    public void depositar(int valor) {
        saldo = saldo + valor;
    }    
    public void sacar(int valor) {
        saldo = saldo - valor;
    }
```
5. Agora nos iremos usar a classe **ContaCorrente** de dentro de programa java, ou seja, o método main  
da classe **Principal** com o trecho de código abaixo:
```java
        ContaCorrente c1 = new ContaCorrente(); // cria um novo objeto da classe conta corrente
        c1.numero = 1;
        c1.nome = "Obama";
        c1.saldo = 100;
		c1.depositar(10);

        System.out.println("Conta c1: " + c1.numero + ", " + c1.nome + ", " + c1.saldo );
        
        ContaCorrente c2 = new ContaCorrente(); // cria um novo objeto da classe conta corrente
        c2.numero = 5000;
        c2.nome = "Diana";
        c2.saldo = 543;
		c2.sacar(3);
        
        System.out.println("Conta c2: " + c2.numero + ", " + c2.nome + ", " + c2.saldo );
```
6. Executar e testar

Nesta implementação eu poderia criar um problema para o fazendo o seguinte:
```java
        c2.saldo = 543;   // faço o depósito inicial
		c2.sacar(3);      // realizo o 1º saque de 3
		c2.sacar(40);     // realizo o 1º saque de 40
		c2.saldo = 543;   // o saldo deveria ficar em 500 porém eu "forço" o saldo original
```
O problema desta implementação da classe **ContaCorrente**, é que ela expoê seus atributos importantes, atributos  
estes que mantêm o estado do objeto, expondo-os sem protegê-los por isso é necessário emcapsulá-los, ou seja,  
transforma os atributos em private (própria classe pode ter acesso). Por isso devemos emcapsular (esconder)  
os atributos e utilizar métodos que controlem o acesso a estes atributos, tanto para leitura quanto para escrita.

### Encapsulando da classe **ContaCorrente**

#### Encapsulando os atributos da classe **ContaCorrente**

1. Na classe **ContaCorrente** encapsule os atributos (de public para private)
```java
// altere os atributos existentes
    private int numero;
    private String nome;
    private int saldo;
```
2. Observe que na classe principal aparecerão erros, reclamando que os atributos tem acesso "private" (privado)
3. Crie "propriedades", ou seja, métodos **get** e **set** para acesso aos atributos (quando necessário)
```java
// inclua os métodos get / set das propriedades
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }	
```

#### Altere a maneira que as outras classes usam classe **ContaCorrente** (agora elas devem usar métodos controlados)

1. Na classe **Principal**, no conteúdo do método main, altere onde os objetos estavam acessando diretamente os   
```java
        c1.setNumero(1);
        c1.setNome("Obama");
        c1.setSaldo(100);
        c1.depositar(10);

        System.out.println("Conta c1: " + c1.getNumero() + ", " + c1.getNome() + ", " + c1.getSaldo());
...
        c2.setNumero(5000);
        c2.setNome("Diana");
        c2.setSaldo(543);
        c2.sacar(3);
        c2.sacar(40);
        c2.setSaldo(543);
		
        System.out.println("Conta c2: " + c2.getNumero() + ", " + c2.getNome() + ", " + c2.getSaldo());
```
2. Executar e testar

Porém não faz sentido o método **setSaldo()**, pois eu cairia no memos problema anterior, o ideal é eu inicializar o saldo  
na criação do objeto e depois permitir sua alteração somente pelos métodos **sacar** e **depositar**.

#### Encapsulando os atributos da classe **ContaCorrente** - continuando

1. Na classe **ContaCorrente** apague todo o método **setSaldo**
2. Crie um método contrutor para a classe **ContaCorrente** (método construtor são métodos sem tipo  
de retorno, _nem mesmo **void**_, e que tem o mesmo nome da classe. Estes métodos podem ter parâmetro)
```java
    public ContaCorrente(int numero, String nome, int saldo) { // método contrutor da classe ContaCorrente que recebe 3 param.
        this.numero = numero;
        this.nome = nome;
        this.saldo = saldo;
    }
```

#### Usando o construtor da classe **ContaCorrente** para criar seus objetos

1. Na classe **Principal**, no conteúdo do método main, altere a maneira que os objetos são construidos (criados/instanciados)
```java
        ContaCorrente c1 = new ContaCorrente(1, "Obama", 100); // cria um novo objeto da classe conta corrente
//        c1.setNumero(1);
//        c1.setNome("Obama");
//        c1.setSaldo(100);
        c1.depositar(10);

        System.out.println("Conta c1: " + c1.getNumero() + ", " + c1.getNome() + ", " + c1.getSaldo());

        ContaCorrente c2 = new ContaCorrente(5000, "Diana", 543); // cria um novo objeto da classe conta corrente
//        c2.setNumero(5000);
//        c2.setNome("Diana");
//        c2.setSaldo(543);
        c2.sacar(3);
        c2.sacar(40);
//        c2.setSaldo(543);

        System.out.println("Conta c2: " + c2.getNumero() + ", " + c2.getNome() + ", " + c2.getSaldo());

```
2. Executar e testar

Agora o saldo é consistêntes com o depósito inicial e com os saques subsequentes.

### Ajustes

1. Utiliza o método toUpperCase() da classe String para que método getNome() retorne o nome sempre em maiúsculo.
2. Passe a trabalhar com saldo do tipo ponto flutuante (para aceitar centavos / casas decimais)
3. Inclua regras de negócio no método **sacar**, ele deverá aceitar saques de no máximo 1000 reais.






## Teorias e exemplos práticos do livro sobre temas abordados nesta aula

### Criação de Métodos em Java

1. Métodos em java (funções)
* (pag.92) Figura 6.2 – Classe B chamando métodos da Classe A.

### Criando classes e objetos

1. Objetos
* (pag.105) Figura 7.1 – O objeto contaBancaria (baseado no tutorial da Oracle).
2. Criando classes / Relação de classes e a UML
* (pag.107) Figura 7.2 – Classe Televisor.
* (pag.107) Exemplo 7.1 – Listagem da classe Televisor
2. Usando classes
* (pag.109) Exemplo 7.2 – A classe UsaTelevisor


### Escopo de classe e escopo de instância

* (pag.110) Exemplo 7.3 – A classe Celular
* (pag.110) Tabela 7.1 - Escopo de Classe x Escopo de Instância
* (pag.110) Exemplo 7.4 – A classe UsaCelular

### Encapsulamento (7.6 - começa na pág.111)

1. Encapsulamento
* (pag.113) Exemplo 7.5 – Listagem da classe TelevisorEncapsulada
2. Regras de negócio em atributos
* (pag.115) Tabela 7.2 Atributo x Regra de negócio exemplificada em Java


### Construtores  (7.8 - começa na pág.116)

1. Incialização de objetos (inicialização de atributos do objeto, mesmo aqueles ocultos/private)
* (pag.117) Exemplo 7.7 – Listagem da classe Televisor


### String

1. 4.2 Operações com Strings
* (pág.72) Exemplo 4.7 – Listagem da classe TamanhoDaFrase
2. Métodos importantes da classe String
* (pág.6 do arquivo **SCJP Capítulo 06 String ES format e parsing.pdf** no diretório 4P\MATERIAL\EXTRA\Certificação\pt-SCJP 1.5)  


