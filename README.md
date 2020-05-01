# ConnectFour
OOP rühmatöö.
Autorid: Hanna Maria Mägi, Nora Anete Müller

Projekti kirjeldus: 

1. rühmatöö: Projekti tegime mängust Connect Four. Antud mäng on populaarne kahe mängijaga lauamäng. Meie eesmärgiks oli teha lauamängust programm. Meie programmis on kasutaja vastaseks arvuti. Kasutaja saab mängu alustades valida endale sümboli ehk nupu ning mängulaua suurused ja võidu tingimuse. Oma käigu ajal valib kasutaja, millisest veerust tahab ta oma nupu sisestada. Nupp langeb viimasele võimalikule kohale. Seejärel teeb seda ka arvuti. Mängu eesmärk on saada esimesena neli (või kasutaja poolt valitud arv) oma nuppu horisontaalselt, vertikaalselt või diagonaalselt järjest. 

2. rühmatöö: Projekti jätkasime mänguga Connect Four, mida kujutasime seekord graafiliselt. Tegime mängu ümber kahele mängijale, kes saavad korraga programmi kasutada. Programmi alguses on lühike tutvustav tekst, edasi saavad mõlemad mängijad lisada oma nime, kui lisatakse number teavitab mäng veast ja mängija saab uuesti oma nime õigel kujul lisada. Edasi liigutakse mängulauale. Esimese mängija värv on alati punane ja teise mängija värv kollane. Kordamööda hakatakse oma nuppe sisestama vajutades soovitud veeru peale. Kui üks mängija saab oma värvi nuppe neli tükki järjest kas horisontaalselt, vertikaalselt või diagonaalselt, siis kuvab programm (failist) eelnevad võitjad ja selle mängu võitja kelle lisab ka faili. Mängijatel on võimalus uuesti mängu alustada või sulgedes akna programmi töö lõpetada.

Mangija klass: 

1. rühmatöö: Mangija klassi eesmärk on luua unikaalne mängija kasutaja poolt sisestatud nime ja nupuga. Mangija klassis on isendiväljad nimi ja nupp ning konstruktor, get - meetod ja set - meetod. 

2. rühmatöö: Mangija klassi eesmärk on luua kaks mängijat kasutajate poolt sisestatud nimedega. Nupu asemel on seekord esimese mängija värviks punane ja teisel mängijal kollane. Mangija klassis on isendiväljad nimi ja varv ning konstruktor, get - meetod ja set - meetod. 

Maatriksi klass: 

1. rühmatöö: Maatriksi klass hoiab endas mängulauaga seonduvaid meetodeid. Otsustasime oma programmis mängulauda kujutada maatriksina. Seega maatriksi klassis on isendiväljad ridade arvu, veergude arvu, võidu tingimuse ja mängulaua jaoks ning konstruktor ja set - meetod, mis aitavad luua igale mängijale omapärase mängulaua kasutaja poolt sisestatud veergude ja ridade arvu põhjal. Lisaks on Maatriksi klassis isendiväli tühja nupu jaoks. 

Meetod looTuhiMangulaud() loob etteantud ridade arvu järgi for - tsükliga ridu ning seal sees teise for - tsükliga etteantud veergude arvu järgi lisab tühje nuppe, et tekiks nii öelda tühi mängulaud. Meetodi lõpus väljastatakse loodud maatriks ning set - meetodi abil määratakse see maatriks mängulauaks.  

Meetod lisaNupp(int veerg, String nupp) lisab mängija poolt valitud veergu mängija nupu. Esmalt kontrollib meetod, kas valitud veerg on tühi, kui ei ole, siis väljastatakse vastav teave. Kui veerg on tühi, alustatakse for tsükli abil veeru läbimist kõige viimasest reast kuni jõutakse tühja nupuni, mis seejärel asendatakse mängija enda nupuga. 

Meetod valjastaMangulaud() käib for - tsükliga mängulaua maatriksi läbi ning väljastab selle terminali. 
Meetod kontrolliVoit(String nupp) kontrollib, kas argumendina etteantud nupp esineb kuskil horisontaalset, vertikaalselt või diagonaalselt neli korda järjest. 

Esmalt kontrollitakse horisontaalselt, seega käiakse kahekordse for - tsükliga mängulaua read läbi. Kui mängulaual olev nupp võrdub argumendina etteantud nupuga siis lisatakse jarjest_nuppe muutujasse +1. Samas kui järgnev nupp ei ole etteantud nupp, siis väärtus jarjest_nuppe nullitakse. Kontrollitakse, kas järjest nuppude arv võrdub võidu tingimisega, kui võrdub tagastatakse true. Kui mängulaual olev nupp võrdub tühja nupuga lisatakse järjest +1 jarjest_tuhje muutujale. Kontrollitakse, kas järjest tühjade nuppude arv võrdub veergude arvuga, kui võrdub, lõpetatakse for - tsüklid, sest terve rida on tühi ning võidu tingimust ei saa seal olla. 
Seejärel kontrollitakse vertikaalselt. Jällegi läbitakse mängulaud kahekordse for - tsükliga. Seekord on välimine tsükkel veergude järgi ning sisemine ridade. Muu sisu on sarnane. 

Viimaks kontrollitakse diagonaalselt. Kahekordse for-tsükli abil hakatakse mängulauda alumisest reast läbi käima. Kui mängulaual on etteantud nupp, siis kontrollitakse, kas võidu tingimus täidetud ühtepidi ülesse (“/”) ning teistpidi ülesse (“\”) diagonaalis. Samas kontrollides tingimus, et kas nii vasakul ja paremal kui ka üleval on piisavalt ruumi, et diagonaal ära mahuks. Näiteks kui võidutingimus on neli nuppu järjest, siis kõige alumisest reast vasakult kolmandal nupul ei kontrollita, kas ta on “\” pidi võit, sest tal pole piisavalt ruumi selle jaoks vasakul.

Meetod kontrolliViik(String nupp) kontrollib kas kõik veerud on täis ehk mängulaud on täis. Selleks läbib ta for - tsükliga mängulaua kõige ülemise rea. Kui mängulaual olev nupp võrdub tühja nupuga, siis mängulaud ei ole täis ja tagastatakse false, muidu tagastatakse true. 

2. rühmatöö: Viisime kõik Maatriksi klassi meetodid üle klassi ConnectFourGUI. 

Peaklass: 

1. rühmatöö: Peaklass sisaldab peameetodi, kus toimub mängu väljakutsumine. Esmalt väljastatakse lühike mängu kirjeldus. Seejärel suheldakse kasutajaga ja palutakse sisestada nimi, sümbol, soovitud mängulaua ridade ja veergude arv ning soovitud võidu tingimus. Seejärel kasutades klassi Mangija luuakse kaks mängijat: arvuti ja kasutaja poolt sisestatud andmetega mängija. Seejärel luuakse klassi Maatriks abil mängulaud kasutaja poolt sisestatud ridade ja veergude arvuga. See mängulaud väljastatakse. Seejärel algab mäng while(true) - tsükli abil. Esmalt küsitakse kasutajalt, millisesse veergu soovib ta oma nupu sisestada. Nupp sisestatakse Maatriksi klassis oleva meetodi lisaNupp abil. Mängulaud väljastatakse. Kontrollitakse Maatriksi klassi kontrolliVoit ja kontrolliViik meetodite abil, kas mängija on mängu võitnud või on jäädud viiki, kui üks neist kontrollidest on tõene väljastatakse selle kohta käiv info ja tsükkel lõpetatakse. Kui kumbki kontrollidest ei ole tõene on arvuti kord oma käik teha. Sellest teavitatakse mängijat ning kasutatakse 1 sekundiks sleep funktsiooni. Seejärel muutujasse suvalineVeerg salvestatakse randomi abil saadud veerg, kuhu sisestab arvuti oma nupu. Meetodi lisaNupp abil sisestatakse arvuti nupp mängulauale ja mängulaud väljastatakse. Nüüd kontrollitakse uuesti, kas arvuti on mängu võitnud või on jäädud viiki, kui kumbki neist vastab tõele väljastatakse info ja tsükkel lõpetatakse. Vastasel juhul algab tsükli sisu otsast peale. Tsükli sisu lõppedes väljastatakse, et mäng on läbi.

2. rühmatöö: Viisime kõik Peaklassi meetodid üle klassi ConnectFourGUI.

NimeAsemelNumber:

2. rühmatöö: Erindi klass (extends Exception), mis kutsub välja konstruktori välja prinditava Stringiga.

ConnectFourGUI:

2. rühmatöö: ConnectFourGUI on meie projekti peaklass. Seal on privaatsed isendiväljad int tile_size, int columns, int rows, boolean redMove, Nupp[][] ruudustik ja Pane nuppJuur, Mangja esimeneMangija, Mangija teineMangija.

Meetod start kujutab mängu graafiliselt peaLaval. Meetodis luuakse esmalt Text sissejuhatuseks ja Button START, mille klikkimisel avaneb uus aken. Uues aknas luuakse kaks TextFieldi, kuhu sisestavad mängijad oma nimed. Mõlema juurde on lisatud Button salvesta, mille vajutamisel esmalt kontrollitakse meetodi kasOnNumber abil, kas sisestatud tekst on number. 

Meetodis kasOnNumber proovitakse sisestatud tekst ümber salvestada Integer tüüpi muutujaks, kui see õnnestub on sisestatud tekst number ja tagastatakse tõene. Kui muutujasse salvestamine ei toimi püütakse erind kinni ja boolean onNumber võrdub false. Meetodi lõpus kontrollitakse, et kui onNumber võrdub true, siis visatakse uus NimeAsemelNumber erind. 

Start meetod kontrollib, kui kasOnNumber meetod on tagastanud true, siis visatakse NimeAsemelNumber erind ja kuvatakse teade eraldi aknas mängijale. Akna sulgemise järgselt saab mängija oma nime uuesti muuta. Kui kontrollitakse uuesti, kas sisestatud tekst on number ja seekord ei ole, siis luuakse uus Mangija isend. TextFieldide all on nupp “Loo mängulaud”, mille vajutamisel avaneb uus aken mängulauaga. 

Meetodid teineMangija(String text, String kollane) ja esimeneMangija(String text, String punane) väärtustavad isendiväljade esimeneMangija ja teineMangija nime ja värvi vastavalt meetodile kaasa antud väärtustega.

Meetod looSisu loob mängulaua ja kõik sellega kaasneva. 

Meetod looVeerud loob veerud, mille kohale hiirega minnes muutub veerg helekollaseks. Veerule vajutades hiirega, lisatakse sinna veergu nupp.

Meetod lisaNupp lisab vajutatud veergu nupu. Kõigepealt kontrollitakse, kas veerus on juba nupud olemas. kui leitakse koht, kus nuppu pole, siis lisatakse sinna animatsiooniga nupp. Pärast animatsiooni käiku antakse käik teise mängija kätte.

Meetod mangLopetatud on kontrollmeetod, mis kontrollib, kas viimasena asetatud nupuga saadi 4 samavärvilist nuppu ritta, veergu või diagonaali kokku. Selleks kasutab ta Point2D Listi, et leida, mis värvi nupud on järjest. Meetod tagastab tõese, kui leidub mingi võidutingimus.

Meetod kontrolliVahemik kontrollib, kas antud Point2D Listis leidub 4 samavärvilist nuppu, mis on järjest.

Meetod mangLabi esmalt väärtustab mangija1 esimeseMangija nimega ja mangija2 teiseMangija nimega. Kui viimane käik oli punase nupu käik, siis võitjaks on esimene mängija, teisel juhul on teine mängija võitjaks. Seejärel kutsutakse välja meetod kirjutaFaili. Seejärel luuakse uus aken, kus kuvatakse faili sisu ja seekordse mängu võitja. Luuakse Button uusMang, mille vajutamisel luuakse uus (tühi) mängulaud. 

Meetod getNupp tagastab antud koordinaatidel oleva nupu.

Klass nupp on loodud nuppude loomiseks. Luuakse kas punane või kollane nupp.

Meetod kirjutaFaili kirjutab BufferedWriteriga mängijate andmed, võitja ja kuupäeva faili. Kui faili pole veel loodud, siis ta loob selle faili. Kui fail on loodud, siis lisab ta sinna uue rea.

Meetod loeFailist loeb failist BufferedReaderig kõik read ning lisab need ühte stringi. iga rida on stringis eraldatud reavahetusega.

Meetod main launchib kogu programmi sisu. 

Projekti tegemise protsess: 

1. rühmatöö: Mitu nädalat enne programmi kirjutamist said rühmaliikmed kokku ning panid paika projekti teema, eesmärgi, ajakava ning arutasid läbi programmi üldise olemuse. Seejärel tegi Hanna GitHubi projekti ning lõi algsed klassid. Seejärel keskendus Hanna Mängija ja Maatriksi klassile lisades sinna vajalikud meetodid ja isendiväljad. Nora ülesanne oli luua kasutajaga suhtlus ja sealjuures keskendus tervele Peaklassile ning lisas Maatriksi klassi meetodi kontrolliViik. Nora kirjutas valmis rühmatöö kirjelduse, mida hiljem täiendas ka Hanna. Aega kulus projekti tegemiseks umbes kolm päeva iga päev ligikaudu neli tundi.

2. rühmatöö: Rühmaliikmed leppisid kokku kohe alguses, et esimene ja teine rühmatöö saavad olema omavahel seotud. GitHubi projekt oli juba olemas ja seega saime hakata kohe programmi muutma kasutades Gradle-it. Täiustasime kordamööda porgrammi ning olime pidevas suhtluses. Nora lõi uue kausta, kus asusid nii eelmise rühmatöö failid, kui ka uus gradle fail. Nora ülesandeks jäi kuvada sissejuhatav tekst, küsida kasutajatelt nende nimed ning selle alusel luua kaks uut Mangija klassi isendit. Samuti erindi klassi loomine ning erindi kuvamine kasutajatele, ühtlasi ka mängu võitja kuvamine ja erinevate akende vahel liikumine. Hanna lõi graafilise mängulaua, selle kasutamise, toimimise ja võidu kontrollimise ning uue mängu alustamise. Ühtlasi oli Hanna ülesandeks faili kirjutamine ja failist lugemine. Nora kirjutas projekti kirjelduse, mida hiljem täiendas Hanna. Aega kulus projekti tegemiseks umbes kaks päeva, iga päev kuus tundi. 

Hinnang: 

1. rühmatöö: Tänu heale ettevalmistusele sujus meie koostöö ning programmi kirjutamine väga hästi. Olime koos läbi mõelnud väga täpselt, kuidas me programmi kirjutame ning millised klassid omavahel seome. Keerulisemad kohad olid nt võidu kontrolli läbiviimine ning mängu tsüklisse saamine.

Tänu sellele, et oleme varasemalt GitHubi kasutanud, siis tuli ka see mugavamalt välja kui varem. Pisemad takistused või probleemid esinesid, kuid suutsime need koos kiirelt lahendada. 

2. rühmatöö: Seekord alustamise rühmatööga veidi hiljem, kuid sellest hoolimata saime kõikide asjadega hästi hakkama. Graafiline kujutamine osutus päris keeruliseks. Raske oli luua ja välja mõelda meetodit, kuidas nuppe kuvada. Eriti valmistas raskusi sisestatud andmete kasutamine ning tagamine, et ekraani suuruse muutmisel kõik toimiks tavapäraselt. GitHubiga seekord probleeme ei esinenud. 


Programmi testimine: 

1. rühmatöö: Esmalt sai testitud mängija loomist ning mängulaua tööd pannes Peaklassi ise vastavad argumendid. Peale kasutajaga suhtluse loomist katsetasime mängu läbi mitmeid kordi ise mängu mängides ning proovides läbi kõik võimalikud variandid: arvuti võit, mängija võit ja viik. 

2. rühmatöö: Programmi testisime pidevalt ise programmi käivitades ja kasutades. Proovisime leida erinevaid võimalusi, kuidas kasutaja võiks mängu mängida. 
