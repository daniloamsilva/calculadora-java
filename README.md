# Calculadora Java
Calculadora desenvolvida totalmente em Java.

![bloggif_5d8abc911dc09](https://user-images.githubusercontent.com/34426848/65807475-05659280-e165-11e9-8f10-6ae072c5c144.gif)

### Recursos
* Operações básicas (adição, subtração, divisão, multiplicação)
* Inversão de sinal
* Ponto para números decimais
* Botão para apagar a operação (AC)

O sistema funciona em torno de uma variável chamada Estado.
Essa variável reflete o estado de outras três variáveis que controlam a calculadora.

### Variáveis de controle
* numVisor:     número atual do visor
* numMemoria :  número guardado na memória
* operação:     operação matemática atual

## Variável Estado
* Estado 0: estado inicial

numMemoria = 0, numVisor = 0, operacao = 0
primeiroNumero = true, numeroNegativo = false

* Estado 1: primeiro número foi digitado antes da operação

numMemoria = 0, numVisor = (número digitado), operacao = 0
primeiroNumero = false, numeroNegativo = true ou false

* Estado 2: operação selecionada

numMemoria = (numero digitado antes), numVisor = (o mesmo), operacao = (operação escolhida)
primeiroNumero = true, numeroNegativo = false

* Estado 3: primeiro número digitado depois da operação

numMemoria = (número digitado antes), numVisor(número digitado agora)
operacao = (operação escolhida), primeiroNumero = false, numeroNegativo = true ou false
