# hotelStay
Calculo de estadia

OBS: Poderia ter usado a dependência feign, para realmente consumir o serviço em tempo de execução, e manter uma performance um pouco melhor, porem por falta de tempo não implementei então usei o próprio RestTemplate.

SpringBoot: 2.0.4.RELEASE

Estrutura MVC

###########
# PACKAGE #
###########

# com.br.stay.hotels.
Controller : responsavel pela regra de negocio                                                                                               
Service: responsavel por expor o serviço/ consumir o serviço                                                                                 
model: responsável por manipular os objetos de payload
Utils:  utilizado em todas as camadas como apoio


#########
# Teste #
#########

Classe de test 
StayControllerTest: responsavel pelos teste unitarios
