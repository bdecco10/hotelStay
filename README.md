# hotelStay
Calculo de estadia

# OBS: Impementação feita de duas maneira
1º Usado a dependência feign, para realmente consumir o serviço em tempo de execução, e manter uma performance um pouco melhor             

2º Usado RESTTemplate.

SpringBoot: 2.0.4.RELEASE

Estrutura MVC

###########
# PACKAGE #
###########

# com.br.stay.hotels.
Controller : responsavel pela regra de negocio                                                                                               
Service: responsavel por expor o serviço                                                                                            
                                                                                                                                      Consume: consumir o serviço                                                                                                                                  
model: responsável por manipular os objetos de payload                                                                                      
Utils:  utilizado em todas as camadas como apoio


#########
# Teste #
#########

Classe de test   

StayControllerTest: responsavel pelos teste unitarios da classe controller     

StayLegacyConsumeTest: responsavel por chamar os serviços 
