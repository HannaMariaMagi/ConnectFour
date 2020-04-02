# ConnectFour
OOP rühmatöö.
Autorid: Hanna Maria Mägi, Nora Anete Müller

Projekti kirjeldus: Projekti tegime mängust Connect Four. Antud mäng on populaarne kahe mängijaga lauamäng. Meie eesmärgiks oli teha lauamängust programm. Meie programmis on kasutaja vastaseks arvuti. Kasutaja saab mängu alustades valida endale sümboli ehk nupu ning mängulaua suurused ja võidu tingimuse. Oma käigu ajal valib kasutaja, millisest veerust tahab ta oma nupu sisestada. Nupp langeb viimasele võimalikule kohale. Seejärel teeb seda ka arvuti. Mängu eesmärk on saada esimesena neli (või kasutaja poolt valitud arv) oma nuppu horisontaalselt, vertikaalselt või diagonaalselt järjest. 

Mangija klass: Mangija klassi eesmärk on luua unikaalne mängija kasutaja poolt sisestatud nime ja nupuga. Mangija klassis on isendiväljad nimi ja nupp ning konstruktor, get - meetod ja set - meetod. 

Maatriksi klass: Maatriksi klass hoiab endas mängulauaga seonduvaid meetodeid. Otsustasime oma programmis mängulauda kujutada maatriksina. Seega maatriksi klassis on isendiväljad ridade arvu, veergude arvu, võidu tingimuse ja mängulaua jaoks ning konstruktor ja set - meetod, mis aitavad luua igale mängijale omapärase mängulaua kasutaja poolt sisestatud veergude ja ridade arvu põhjal. Lisaks on Maatriksi klassis isendiväli tühja nupu jaoks. 

Meetod looTuhiMangulaud() loob etteantud ridade arvu järgi for - tsükliga ridu ning seal sees teise for - tsükliga etteantud veergude arvu järgi lisab tühje nuppe, et tekiks nii öelda tühi mängulaud. Meetodi lõpus väljastatakse loodud maatriks ning set - meetodi abil määratakse see maatriks mängulauaks.  

Meetod lisaNupp(int veerg, String nupp) lisab mängija poolt valitud veergu mängija nupu. Esmalt kontrollib meetod, kas valitud veerg on tühi, kui ei ole, siis väljastatakse vastav teave. Kui veerg on tühi, alustatakse for tsükli abil veeru läbimist kõige viimasest reast kuni jõutakse tühja nupuni, mis seejärel asendatakse mängija enda nupuga. 

Meetod valjastaMangulaud() käib for - tsükliga mängulaua maatriksi läbi ning väljastab selle terminali. 

Meetod kontrolliVoit(String nupp) kontrollib, kas argumendina etteantud nupp esineb kuskil horisontaalset, vertikaalselt või diagonaalselt neli korda järjest. 

Esmalt kontrollitakse horisontaalselt, seega käiakse kahekordse for - tsükliga mängulaua read läbi. Kui mängulaual olev nupp võrdub argumendina etteantud nupuga siis lisatakse jarjest_nuppe muutujasse +1. Samas kui järgnev nupp ei ole etteantud nupp, siis väärtus jarjest_nuppe nullitakse. Kontrollitakse, kas järjest nuppude arv võrdub võidu tingimisega, kui võrdub tagastatakse true. Kui mängulaual olev nupp võrdub tühja nupuga lisatakse järjest +1 jarjest_tuhje muutujale. Kontrollitakse, kas järjest tühjade nuppude arv võrdub veergude arvuga, kui võrdub, lõpetatakse for - tsüklid, sest terve rida on tühi ning võidu tingimust ei saa seal olla. 

Seejärel kontrollitakse vertikaalselt. Jällegi läbitakse mängulaud kahekordse for - tsükliga. Seekord on välimine tsükkel veergude järgi ning sisemine ridade. Muu sisu on sarnane. 

Viimaks kontrollitakse diagonaalselt. Kahekordse for-tsükli abil hakatakse mängulauda alumisest reast läbi käima. Kui mängulaual on etteantud nupp, siis kontrollitakse, kas võidu tingimus täidetud ühtepidi ülesse (“/”) ning teistpidi ülesse (“\”) diagonaalis. Samas kontrollides tingimust, et kas nii vasakul ja paremal kui ka üleval on piisavalt ruumi, et diagonaal ära mahuks. Näiteks kui võidutingimus on neli nuppu järjest, siis kõige alumisest reast vasakult kolmandal nupul ei kontrollita, kas ta on “\” pidi võit, sest tal pole piisavalt ruumi selle jaoks vasakul.

Meetod kontrolliViik(String nupp) kontrollib kas kõik veerud on täis ehk mängulaud on täis. Selleks läbib ta for - tsükliga mängulaua kõige ülemise rea. Kui mängulaual olev nupp võrdub tühja nupuga, siis mängulaud ei ole täis ja tagastatakse false, muidu tagastatakse true. 

Peaklass: Peaklass sisaldab peameetodi, kus toimub mängu väljakutsumine. Esmalt väljastatakse lühike mängu kirjeldus. Seejärel suheldakse kasutajaga ja palutakse sisestada nimi, sümbol, soovitud mängulaua ridade ja veergude arv ning soovitud võidu tingimus. Seejärel kasutades klassi Mangija luuakse kaks mängijat: arvuti ja kasutaja poolt sisestatud andmetega mängija. Seejärel luuakse klassi Maatriks abil mängulaud kasutaja poolt sisestatud ridade ja veergude arvuga. See mängulaud väljastatakse. Seejärel algab mäng while(true) - tsükli abil. Esmalt küsitakse kasutajalt, millisesse veergu soovib ta oma nupu sisestada. Nupp sisestatakse Maatriksi klassis oleva meetodi lisaNupp abil. Mängulaud väljastatakse. Kontrollitakse Maatriksi klassi kontrolliVoit ja kontrolliViik meetodite abil, kas mängija on mängu võitnud või on jäädud viiki, kui üks neist kontrollidest on tõene väljastatakse selle kohta käiv info ja tsükkel lõpetatakse. Kui kumbki kontrollidest ei ole tõene on arvuti kord oma käik teha. Sellest teavitatakse mängijat ning kasutatakse 1 sekundiks sleep funktsiooni. Seejärel muutujasse suvalineVeerg salvestatakse randomi abil saadud veerg, kuhu sisestab arvuti oma nupu. Meetodi lisaNupp abil sisestatakse arvuti nupp mängulauale ja mängulaud väljastatakse. Nüüd kontrollitakse uuesti, kas arvuti on mängu võitnud või on jäädud viiki, kui kumbki neist vastab tõele väljastatakse info ja tsükkel lõpetatakse. Vastasel juhul algab tsükli sisu otsast peale. Tsükli sisu lõppedes väljastatakse, et mäng on läbi.

Projekti tegemise protsess: Mitu nädalat enne programmi kirjutamist said rühmaliikmed kokku ning panid paika projekti teema, eesmärgi, ajakava ning arutasid läbi programmi üldise olemuse. Seejärel tegi Hanna GitHubi projekti ning lõi algsed klassid. Seejärel keskendus Hanna Mängija ja Maatriksi klassile lisades sinna vajalikud meetodid ja isendiväljad. Nora ülesanne oli luua kasutajaga suhtlus ja sealjuures keskendus tervele Peaklassile ning lisas Maatriksi klassi meetodi kontrolliViik. Nora kirjutas valmis rühmatöö kirjelduse, mida hiljem täiendas ka Hanna. Aega kulus projekti tegemiseks umbes kolm päeva iga päev ligikaudu neli tundi. 
Hinnang: Tänu heale ettevalmistusele sujus meie koostöö ning programmi kirjutamine väga hästi. Olime koos läbi mõelnud väga täpselt, kuidas me programmi kirjutame ning millised klassid omavahel seome. Keerulisemad kohad olid nt võidu kontrolli läbiviimine ning mängu tsüklisse saamine.

Tänu sellele, et oleme varasemalt GitHubi kasutanud, siis tuli ka see mugavamalt välja kui varem. Pisemad takistused või probleemid esinesid, kuid suutsime need koos kiirelt lahendada. 

Programmi testimine: Esmalt sai testitud mängija loomist ning mängulaua tööd pannes Peaklassi ise vastavad argumendid. Peale kasutajaga suhtluse loomist katsetasime mängu läbi mitmeid kordi ise mängu mängides ning proovides läbi kõik võimalikud variandid: arvuti võit, mängija võit ja viik. 

Hinnang tööle: Me mõlemad jäime lõpptulemusega rahule, sest saavutasime enda eesmärgi ning lõime ise connect four mängu.
