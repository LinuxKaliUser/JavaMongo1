import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import server.MongoInterface;
import server.MongoServer;

public class CalculationHomeCost {

	private static int Flaeche, Zimmer;
	private static String Kanton;
	
	private static boolean aktiv=false;
	
	private static Scanner sc = new Scanner(System.in) ;
	
	public static void main(String[] args) {
		
		MongoInterface db = new MongoServer();
		
		List<String> basel = db.findDocuments("basel");
		List<String> baselland = db.findDocuments("baselland");
		List<String> zuerich = db.findDocuments("zuerich");
		
		System.out.println("Willkommen zum Hauskostenrechner");
		System.out.println("Bei Hauskostenrechner koennen Sie die Kosten der Haeuser transparent ansehen");
	
		
		//Waehlen
		Kanton();
		//Geheime Funtion
		if (Kanton.contains("+")) {
		
			aktiv=true;
		
		//Basel 
		
		}if(basel.contains(Kanton)) {
			
			if (aktiv){
		 
				
				System.out.println("Die Zimmer des Hauses wuerde "+Zimmer(280000)+" Fr. kosten.");

		 
			}else {
				
				Flaeche();
				Kosten(10000);	
		
			}	
	
	
			//Baselland 
		
		}else if(baselland.contains(Kanton)) {
	     
		
			if (aktiv){
  		 
				System.out.println("Die Zimmer des Hauses wuerde "+Zimmer(230000)+" Fr. kosten.");

			}else {
		
		 
				Flaeche();
				Kosten(7000);
		
		
			}
		
		//Zuerich 	
		
		}else if(zuerich.contains(Kanton)) {
		     
		
			if (aktiv){
	  	 
			
				System.out.println("Die Zimmer des Hauses wuerde "+Zimmer(280000)+" Fr. kosten.");

			}else {
			
		 
				Flaeche();

				Kosten(10000);
	
	
			}
		
		//Schweiz	
		}else if(!zuerich.contains(Kanton)){
		
			if (aktiv){
	  	 
				
				System.out.println("Die Zimmer des Hauses wuerde "+Zimmer(280000)+" Fr. kosten.");

			}else {
		 
				Flaeche();
     	 
				Kosten(6000);
     	 
			}
		}	System.out.println("Schade Das Programm ist vorbei ^^)");
	
		
		
	

	}private static void Kanton() {
	
		System.out.println("Im System gibt es nur 3 Kantone Basel, Zuerich oder Baselland, wenn Sie keines vom dem nehmen, dann wird es automatisch die Schwiz gewaehlt");
		
		Kanton =  sc.next();
		
		System.out.println("Sie haben "+Kanton+" gewaehlt");
	
	}private static void Flaeche() {
        
		System.out.println("Wie Gross sollte die Flaeche ihres Haus sein in Quadratmetern");
		
		Flaeche =  sc.nextInt();
		
		System.out.println("Sie wollen "+Flaeche+" Quadratmeter Flaeche");
	
	}private static void Kosten(int Kosten) {
	   
		System.out.println("Die Flaeche des Hauses wuerde "+Kosten*Flaeche+" Fr. kosten.");
		
		
	}private static int Zimmer(int Zimmerkosten) {
		if (aktiv) {
			System.out.println("Wie Gross sollte die Zimmern ihres Haus sein");
			
			Zimmer =  sc.nextInt();
			
			System.out.println("Sie wollen "+Zimmer+" Zimmern in ihrem Haus");
			
			
		}return Zimmerkosten*Zimmer;
	
	}


}
