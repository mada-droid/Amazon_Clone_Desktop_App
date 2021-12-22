# Shipping_Project

Linguaggio utilizzato:
- Java 100%

Tecnologie utilizzate:
- IDE: Eclipse
- Per eseguire il programma l'IDE dovrà essere fornito con tutti i branch di Java AWT, Swing.
- Versione SDK.15 o Superiore. 

Credenziali amministrative d'accesso:

Username: admin
Password: admin

Obiettivo del Progetto:
- Progettare un'applicazione per la gestione delle spedizioni di un'azienda 
- Il programma è dotato di interfaccia grafica tramite cui interagire con il programma stesso. 
- Viene sfruttato i meccanismi di incapsulamento, ereditarietà e polimorfismo. 
- Per l’ereditarietà vengono utilizzati classi astratte e interfacce.
- Sfruttare le classi di sistema Java per la gestione dell'input/output.
- Utilizzare le strutture dati di libreria e i generics.
- Il programma è eseguibile da linea di comando. 

Descrizione del Progetto:

        funzionalità:
                • Login e registrazione dei clienti che inseriscono i dati delle loro spedizioni
                • Login specifico per l’amministratore (admin) della filiale di spedizione
                • Possibilità di aggiornare lo stato di ogni singola spedizione
                • Visualizzazioni personalizzate (per clienti e amministratori) dello storico delle spedizioni e delle spedizioni in corso.

        Gestione login e registrazioni:
                Una volta lanciato il programma, esso chiederà se si vuole entrare come amministratore o cliente.
                Ciò deve avvenire tramite un’interfaccia grafica appositamente progettata.
                L’amministratore a questo punto può entrare con un suo username e password, definito in maniera statica
                all’interno del codice. Non deve essere possibile aggiungere ulteriori amministratori.
                Il cliente invece può scegliere se registrarsi, fornendo username, password e un suo indirizzo, od eseguire il
                login qualora abbia già completato l’operazione di registrazione.
                        ● Il sistema deve proibire la registrazione di più utenti con lo stesso username.
                        ● Il sistema deve salvare in maniera persistente le informazioni riguardanti gli utenti registrati
                        ● Il login avviene tramite username e password.
                Deve esistere la possibilità di poter fare logout del cliente o admin ed entrare con un login diverso senza
                dover necessariamente chiudere il programma.

        Caratteristiche delle spedizion:
                Il cliente autenticato dovrà essere in grado di creare una o più richieste di spedizione con riferimento al suo
                account. La richiesta di una spedizione viene completata dal cliente fornendo un valore sensato a tutti i campi
                di seguito descritti;
                Una spedizione può essere normale o assicurata. Una spedizione normale è caratterizzata da:
                        ● Un codice, generato per esempio concatenando lo username dell’utente con un numero progressivo
                                e/o una stringa derivata dalle altre caratteristiche della spedizione (di seguito elencate).
                        ● Una destinazione
                        ● Il peso in Kg.
                        ● Una data di immissione nel sistema
                        ● Uno stato, dettagliato in seguito
                        ● La data in cui venne fatta ogni Spedizione
                        
                Una spedizione assicurata, oltre ai campi della spedizione normale, aggiunge la caratteristica di valore
                assicurato, che rappresenta l’ammontare in denaro che un cliente può richiedere alla compagnia di spedizioni
                in caso di fallimento della spedizione.
                Una volta inserita una spedizione normale nel sistema, essa sarà caratterizzata dai seguenti stati:
                        ● IN PREPARAZIONE,
                        ● IN TRANSITO,
                        ● RICEVUTA o FALLITA
                Se la spedizione è assicurata, si aggiungono altri due possibili stati:
                        ● RIMBORSO RICHIESTO,
                        ● RIMBORSO EROGATO
                Al momento del primo inserimento dei dati di spedizione da parte dell’utente, alla spedizione verrà assegnato
                lo stato “IN PREPARAZIONE”. Sarà poi onere dell’admin transizionare lo stato della spedizione in uno degli
                altri stati, seguendo le logiche dettagliate nella sezione successiva.
                
                Aggiornamento dello stato delle spedizioni:
                        L’admin, una volta autenticato può visualizzare le spedizioni di tutti i clienti, in formato tabellare.
                       
                        L’amministratore deve essere in grado di poter cambiare lo stato di ogni spedizione.
                        L’admin può cancellare dal sistema le spedizioni che si trovano in uno stato finale. La rimozione di una entry
                        da parte dell’admin rende tale spedizione non più visibile dal cliente.
                        Il cliente una volta autenticato, potrà visualizzare in formato tabellare solo le spedizioni inserite con
                        riferimento al suo account. Il cliente non può modificare lo stato delle spedizioni, con una sola eccezione: se
                        la spedizione era assicurata e si trova ora in stato FALLITA, allora può far cambiare stato a tale spedizione. Da
                        FALLITA, può passare a RIMBORSO RICHIESTO.
                       
                 

 
