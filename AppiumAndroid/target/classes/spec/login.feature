#language: pt
Funcionalidade: Calcular taxa

  Cenario: Calcular taxa com sucesso
    Dado que quero insiro o valor "123"para o cálculo
    Quando realizo o cálculo
    Então vejo o percentual Total Amount de "$141.45"
    E o tip Amount "$18.45"

  Cenario: Calcular taxa com sucesso 2
    Dado que quero insiro o valor "444"para o cálculo
    Quando realizo o cálculo
    Então vejo o percentual Total Amount de "$510.60"
    E o tip Amount "$66.60"