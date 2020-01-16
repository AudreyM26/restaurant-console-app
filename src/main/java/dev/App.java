package dev;

import dev.dao.PlatDaoFichier;
import dev.dao.PlatDaoMemoire;
import dev.ihm.Menu;
import dev.service.PlatServiceVersion1;
import dev.service.PlatServiceVersion2;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

    	/*
        Scanner scanner = new Scanner(System.in);

        PlatDaoMemoire platDaoMemoire = new PlatDaoMemoire();

        // TODO adapter le chemin du fichier (utiliser un répertoire existant)
       // PlatDaoFichier platDaoFichier = new PlatDaoFichier("/home/rossi/Temp/restaurant.txt");

       // PlatServiceVersion1 platServiceVersion1 = new PlatServiceVersion1(platDaoFichier);
        PlatServiceVersion2 platServiceVersion2 = new PlatServiceVersion2(platDaoMemoire);

        Menu menu = new Menu(scanner, platServiceVersion2);
        
        menu.afficher();
        scanner.close();
        */
       
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-config.xml");
		Scanner scanner = context.getBean(Scanner.class);

		// récupération du bean Menu
		Menu menu = context.getBean(Menu.class);
		menu.afficher();
		// fermeture du Scanner
		context.getBean(Scanner.class).close();
		context.close();
        
    }
}
