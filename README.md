# hotelStay
Calculo de estadia

OBS: Poderia ter usado a dependencia feign, para realmente consumir o serviço em tempo de execução, e manter uma performace um pouco melhor, porem por falta de tempo nao implementei então usei o proprio RestTemplate.

SpringBoot: 2.0.4.RELEASE

Estrutura MVC

###########
# PACKAGE #
###########

# com.br.stay.hotels.
Controller : responsavel pela regra de negocio
Service: responsavel por expor o serviço/ consumir o serviço
model: responsavel por manipular os objetos de payload
Utils:  utilizado em todas as camadas como apoio


#########
# Teste #
#########

Classe de test 
StayControllerTest: responsavel pelos teste unitarios
