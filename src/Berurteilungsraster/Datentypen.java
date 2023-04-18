package Berurteilungsraster;
import java.util.Scanner;
import java.awt.Desktop;  
import java.io.*;  





public class Datentypen {

	private static byte byte1=127;
	private static short short1=200;
	private static int int1=1000;
	private static long long1=10000;
	private static float float1=12.34567f;
	private static double double1=12.3333333333;
	private static boolean boolean1=true;
	private static char char1= 97;
	
	private static String User;
	
	private static Scanner sc= new Scanner(System.in);
	
	
	private  static File file = new File("D:\\Users\\NAGJ\\Desktop\\New Internet Shortcut.url");

	public static void main(String[] args) {
		System.out.println("Willkommen im in Datentypen");

		do {
		System.out.println("Tippen Sie die Datentypen ein:");	
		
		//Scanner starten
		User=sc.nextLine();
	 	
		switch(User) {
	
		case "byte":
			System.out.println("Byte hat 1byte(2^8), dazu ein Beispiel: "+byte1+" .Es speichert Ganze Zahlen positiv und negativ.");
			 break;
			
		case "short":
			System.out.println("Short hat 2bytes(2^16), dazu ein Beispiel: "+short1+" .Es speichert Ganze Zahlen positiv und negativ.");
			 break;
			 
		case "int":
			System.out.println("Int hat 4bytes(2^32), dazu ein Beispiel: "+int1+" .Es speichert Ganze Zahlen positiv und negativ.");
			 break;
			 
		case "long":
			System.out.println("Long hat 8bytes(2^64), dazu ein Beispiel: "+long1+" .Es speichert Ganze Zahlen positiv und negativ.");
			 break;
			 
		case "float":
			System.out.println("Float hat 4bytes(2^32)und 7. Stellen nach den Komma, dazu ein Beispiel: "+float1+" .Es speichert Fliesskommazahlen positiv und negativ.");
			 break;
			 
		case "double":
			System.out.println("Double hat 8bytes(2^64)und 15. Stellen nach den Komma, dazu ein Beispiel: "+double1+" .Es speichert Fliesskommazahlen positiv und negativ.");
			 break;
			 
		case "boolean":
			System.out.println("Boolean hat 1bit(2^2), dazu ein Beispiel: "+boolean1+" .Es speichert true oder false als Zustand.");
			 break;
			 
		case "char":	
			System.out.println("Char hat 2bytes(2^16)und es baut sich auf das ASCII Tabelle auf, dazu ein Beispiel: "+char1+" .Es speichert nur einzele Buchstaben und Zeichen.");
			 try {
				 Desktop.getDesktop().open(file);
				 //Wenn es nicht funktioniert nicht
			} catch (IOException e) {
				e.printStackTrace();
			}
			 break;
			 
		case "String":	
			System.out.println("String sind Zeichenketten mit Buchstaben, Sonderzeichen etc.");

			 break;
			
		case "all":
			
			System.out.println("Byte hat 1byte(2^8), dazu ein Beispiel: "+byte1+" .Es speichert Ganze Zahlen positiv und negativ.");
			
			System.out.println("Short hat 2bytes(2^16), dazu ein Beispiel: "+short1+" .Es speichert Ganze Zahlen positiv und negativ.");
			
			System.out.println("Int hat 4bytes(2^32), dazu ein Beispiel: "+int1+" .Es speichert Ganze Zahlen positiv und negativ.");
			
			System.out.println("Long hat 8bytes(2^64), dazu ein Beispiel: "+long1+" .Es speichert Ganze Zahlen positiv und negativ.");
			
			System.out.println("Float hat 4bytes(2^32)und 7. Stellen nach den Komma, dazu ein Beispiel: "+float1+" .Es speichert Fliesskommazahlen positiv und negativ.");
			
			System.out.println("Double hat 8bytes(2^64)und 15. Stellen nach den Komma, dazu ein Beispiel: "+double1+" .Es speichert Fliesskommazahlen positiv und negativ.");
		
			System.out.println("Boolean hat 1bit(2^2), dazu ein Beispiel: "+boolean1+" .Es speichert true oder false als Zustand.");
			
			System.out.println("Char hat 2bytes(2^16)und es baut sich auf das ASCII Tabelle auf, dazu ein Beispiel: "+char1+" .Es speichert nur einzele Buchstaben und Zeichen.");
			 try {
				 Desktop.getDesktop().open(file);
				//Wenn es nicht funktioniert nicht
			} catch (IOException e) {
				e.printStackTrace();
			}
			 System.out.println("String sind Zeichenketten mit Buchstaben, Sonderzeichen etc.");
			
		default:
			
			System.out.println("Primitive Datentypen haben 1 klaren Eigenschaft und komplexe Datentypen sind selbstdefinierte Klassen, wie Listen etc.");
			System.out.println("Das ist das Ende vom Programm");
			
			
		} 
		
		}while(User!="all");

	}

}
