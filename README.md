# Sistemas Distribuídos - Resolução Recursiva de nomes

**Execução**

javac *.java

rmic ServidorNomesRaizImpl

rmic ServidorNomeBRImpl

rmic ServidorNomeUEMImpl

rmic ServidorNomeDINImpl

rmic ServidorConteudosRaizImpl

rmic ServidorConteudosDINImpl

start rmiregistry

Abrir 7 prompt de comando e para cada:

java ServidorNomesRaiz

java ServidorNomeBR

java ServidorNomeUEM

java ServidorNomeDIN

java ServidorConteudosRaiz

java ServidorConteudosDIN

java Cliente
