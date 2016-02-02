# JavaConcurrentProgram


HOMEWORK HWJ
Per sviluppo e testing si è usato eclipse mars e le librerie JUNIT incluse come plugin di eclipse stesso.
Il seguente progetto ha come obiettivo principale quello di comprendere i diversi framework esistenti in Java per l'esecuzione di programmi concorrenti e, in particolar modo, il loro utilizzo per il calcolo della somma dei valori di  nodi di un albero di profondità via via crescente.
E' previsto anche per ogni esercizio implementato un testing dei risultati ottenuti mediante la libreria JUNIT versione 4.12.
Per facilitare il testing è presente la classe AlberoBinario che offre dei metodi che creano un albero binario bilanciato e due alberi binari sbilanciati destro e sinistro.
Per ogni esercizio del suddetto Homework sono previsti:
	1) Test su albero binario con nodi con valore pari a 1 e con profondità 9,11,13,14,15;
	2) Test su albero binario sbilanciato destro con nodi con valore pari a 1 e con profondità 9,11,13,14,15;
	3) Test su albero binario sbilanciato sinistro con nodi con valore pari a 1 e con profondità 9,11,13,14,15.
Per ogni profondità 
	1) si calcola la somma con esecuzione seriale e parallela e si confrontano i risultati;
	2) si calcola lo speedup ad ogni profondità e poi si valuta lo speedup finale che tiene conto di tutte le suddette profondità.

ESERCIZIO 1
Da un punto di vista implementativo si usa una LinkedBlockingDeque per rappresentare un buffer di dimensioni illimitata e una CyclicBarrierRunnable che implementa l'interface Runnable
Il metodo run,implementato in CyclicBarrierRunnable, verifica se il buffer è vuoto oppure no. Sul buffer si generano task che aggiungono un nodo in coda se il nodo ha figli sinistro o destro diverso da null.
Da un punto di vista sperimentale abbiamo che:
	1) Per l'Albero Bilanciato lo speedup effettivo raggiunge valori tra 3.6/3.8 e mostra un andamento crescente dalla profondita 9 alla profondita 15;
	2) Per l'Albero Sbilanciato Destro lo speedup effettivo raggiunge valori tra 3.6/3.8 e monstra un andamento oscillatorio tra questi due valori;
	3) Per l'Albero Sbilanciato Sinistro lo speedup effettivo raggiunge valori tra 3.6/3.8 e andamento crescente da profondita 9 a 11 e poi costante

ESERCIZIO 3
Nell'esercizio tre si è utilizatto per ottenere la soluzione il framework fork/join di java 7, in cui si usa una soglia di threshold pari a 10000 e una LinkedBlockingDeque. Il metodo compute, presente nel ForkJoinCalculator, calcola direttamente il risultato se il numeroNodi<soglia e suddivide in task sinistro destro in caso contrario.
Da un punto di vista sperimentale abbiamo che:
	1) Per l'albero bilanciato lo speedup cresce all'aumentare della profondità e si assesta ad un valore pari a 1.5/1.7;
	2) Per l'albero sbilanciato destro si ha uno speedup costante fino alla profondita 14(quasi maggiore di 1) e aumenta di un fattore 2 alla profondità 15; 
	3) Per l'albero sbilanciato sinistro si ha uno speedup costante fino alla profondita 14(quasi maggiore di 1) e aumenta di un fattore 2 alla profondità 15.

ESERCIZIO 4
Per tale esercizio si sono usati i CompleatableFuture. Il metodo computeOnerousSum crea una lista di CompleatableFuture applicando in sequenza un metodo splitToStream, il quale, partendo dal nodo radice, ricorsivamente crea uno Stream<Node>, una map e una collect che restituisce tutti i risultati. Su questi elementi si crea uno stream e si calcola mediante reduce la somma finale.
Da un punto di vista sperimentale abbiamo per i tre alberi un andamento sempre constante e valori di speedup tra 2.8 e 2.9
