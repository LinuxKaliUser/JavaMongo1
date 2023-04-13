package Berurteilungsraster;

import java.util.Scanner;



public class WhileandWhileDo {

	//Int Eingabe
	private static int Input;
	private static char TestcharPasswort,TestcharPasswort2,TestcharPasswort3,TestcharPasswort4,TestcharPasswort5;
	private static String input2, testenpasswort,testenpasswort2,testenpasswort3,testenpasswort4,testenpasswort5,result2,result3,result4,result5;
	private static int charmax=50;
	private static int intmax=2147483647;
	private static boolean stelle=false;

	
	//Scanner für den Pin und Passwort 
	private static Scanner sc= new Scanner (System.in);
	
	public static void main(String[] args) {
	
		
		System.out.println("Gib bis zu einem neunstelligen Pin ein:");
		//Scanner für den Pin eintippen
		Input= sc.nextInt();
		//Auflistung i (index)
		int i=0;
		while (i<=intmax) 
		{
			//falls i gleich der Input vom User ist zeigt es an
			if (Input==i) 
			{
				System.out.println("Dein Pin ist: "+Input );
				break;
			}
			//addiert i mit 1 zusammen
			i++;		
		}
		//Unendliche laufende Schleife
		while (i==Input) 
		{
			System.out.println("Gib dein 4.stelliges  Passwort ein:");
			//Scanner 2 für den Passwort eintippen
			input2= sc.next();
			long start = System.nanoTime();
			passwortstelle1(0);
			long end = System.nanoTime();
			System.out.println("Execution time: " + (end - start)); 
			if(!stelle) 
			{
				System.out.println("Dein Passwort ist zu lang oder hat ungültig Zeichern ");	            
			}
		}		
	} 
	private static void passwortstelle1(int i)
	{
		do{
			i++;
            //Char ausprobieren
			TestcharPasswort=(char)i;
			//Char in String konventieren
			testenpasswort=Character.toString(TestcharPasswort);
			//Testen ob es stimmt 
			if (testenpasswort.equals(input2)) 
			{
				System.out.println("Dein Passwort ist: "+testenpasswort);	
				stelle=true;
				break;	
			}
			//Nächste Paswortstelle
			passwortstelle2(0);		
		}while(i<=charmax);
		i=0;
	}
	private static void passwortstelle2(int i) 
	{		
		do 
		{
			i++;
			TestcharPasswort2=(char)i;		
	
			testenpasswort2=Character.toString(TestcharPasswort2);
			result2=testenpasswort+testenpasswort2;
			
			if(result2.equals(input2)) 
			{
				System.out.println("Dein Passwort ist: "+result2);
				stelle=true;
				break;
			}	
			passwortstelle3(0);
	}while(i<=charmax);
		i=0;	
	}
	private static void passwortstelle3(int i) 
	{
		do 
		{
			i++;
			TestcharPasswort3=(char)i;
							
			testenpasswort3=Character.toString(TestcharPasswort3);
			result3=testenpasswort+testenpasswort2+testenpasswort3;
			
			if(result3.equals(input2)) 
			{
				System.out.println("Dein Passwort ist: "+result3);
				stelle=true;
				break;
			}
			passwortstelle4(0);
		}while(i<=charmax);
		i=0;
	}
	private static void passwortstelle4(int i) 
	{
		do 
		{
			i++;
			TestcharPasswort4=(char)i;
			
			testenpasswort4=Character.toString(TestcharPasswort4);
			result4=testenpasswort+testenpasswort2+testenpasswort3+testenpasswort4;
				
			if(result4.equals(input2)) 
			{
				System.out.println("Dein Passwort ist: "+result4);
				stelle=true;
				break;
			}
			passwortstelle5(0);
		}while(i<=charmax);
			i=0;			
	}
	private static void passwortstelle5(int i) 
	{
		do 
		{
			i++;
			TestcharPasswort5=(char)i;
			
			testenpasswort5=Character.toString(TestcharPasswort5);
			result5=testenpasswort+testenpasswort2+testenpasswort3+testenpasswort4+testenpasswort5;
				
			if(result5.equals(input2)) 
			{
				System.out.println("Dein Passwort ist: "+result5);
				stelle=true;
				break;
			}
		}while(i<=charmax);
			i=0;			
	}
}


