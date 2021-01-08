package main;

import modele.Company;
import modele.Computer;
import service.CompanyServiceImpl;
import service.ComputerServiceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    private static ComputerServiceImpl computerService= new ComputerServiceImpl();
    private static CompanyServiceImpl companyService  = new CompanyServiceImpl();
    private static Scanner sc = new Scanner(System.in);
    private static  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args){
        System.out.println("Salut a toi jeune entrepreneur.");
        boolean fin = false;
        String choix = "";
        while(!fin){
            System.out.println("Tapez 1 pour trouver un pc");
            System.out.println("Tapez 2 pour trouver tous les pc");
            System.out.println("Tapez 3 pour créer un pc");
            System.out.println("Tapez 4 pour update un pc");
            System.out.println("Tapez 5 pour delete un pc");
            System.out.println("Tapez 6 pour trouver une company");
            System.out.println("Tapez 7 pour trouver tous les companies");
            System.out.println("Tapez 8 pour créer une company");
            System.out.println("Tapez 9 pour update une company");
            System.out.println("Tapez 10 pour delete une company");

            choix = sc.nextLine();
            switch (choix){
                case "1" :
                    findComputer();
                    break;
                case "2" :
                    computerService.getComputers();
                    break;
                case "3" :
                    createComputer();
                    break;
                case "4" :
                    updateComputer();
                    break;
                case "5" :
                    deleteComputer();
                    break;
                case "6" :
                    findCompany();
                    break;
                case "7" :
                    companyService.getCompanies();
                    break;
                case "8" :
                    createCompany();
                    break;
                case "9" :
                    updateCompany();
                    break;
                case "10" :
                    deleteCompany();
                    break;
                default:
                    System.out.println("Pas compris frr");
                    break;
            }
        }
    }

    private static void deleteCompany() {
        System.out.println("Entrez l'id de la company à delete");
        String idString = sc.nextLine();
        companyService.deleteCompany(Integer.valueOf(idString));
    }

    private static void updateCompany() {
        System.out.println("Entrez l'id de la company à update");
        String id = sc.nextLine();
        System.out.println("Entrez le nom de la company à update");
        String name = sc.nextLine();
        companyService.updateCompany(new Company(Integer.parseInt(id), name));

    }

    private static void createCompany() {
        System.out.println("Entrez l'id de la company à créer");
        String id = sc.nextLine();
        System.out.println("Entrez le nom de la company à créer");
        String name = sc.nextLine();
        companyService.addCompany(new Company(Integer.parseInt(id), name));
    }

    private static void findCompany() {
        System.out.println("Entrez l'id de la company à chercher");
        String id = sc.nextLine();
        companyService.getCompany(Integer.parseInt(id));
    }

    private static void deleteComputer() {
        System.out.println("Entrez l'id de l'ordinateur à delete");
        String idString = sc.nextLine();
        computerService.deleteComputers(Integer.valueOf(idString));
    }

    private static void updateComputer() {
        System.out.println("Entrez l'id de l'ordinateur à update");
        String id = sc.nextLine();
        System.out.println("Entrez le nom de l'ordinateur à update'");
        String name = sc.nextLine();
        System.out.println("Entrez la date d'introduction de l'ordinateur a update au format dd//MM/yyyy");
        String introductionDate = sc.nextLine();
        System.out.println("Entrez la date de retrait de l'ordinateur a update au format dd//MM/yyyy");
        String discontinued = sc.nextLine();
        System.out.println("Entrez l'id de la company associée");
        String companyId = sc.nextLine();
        computerService.updateComputers(new Computer(Integer.valueOf(id), name, LocalDate.parse(introductionDate, formatter), LocalDate.parse(discontinued, formatter), Integer.valueOf(companyId)));
    }

    private static void createComputer() {
        System.out.println("Entrez l'id de l'ordinateur à créer");
        String id = sc.nextLine();
        System.out.println("Entrez le nom de l'ordinateur à créer'");
        String name = sc.nextLine();
        System.out.println("Entrez la date d'introduction de l'ordinateur à créer au format dd//MM/yyyy");
        String introductionDate = sc.nextLine();
        System.out.println("Entrez la date de retrait de l'ordinateur à créer au format dd//MM/yyyy");
        String discontinued = sc.nextLine();
        System.out.println("Entrez l'id de la company associée");
        String companyId = sc.nextLine();
        computerService.addComputers(new Computer(Integer.valueOf(id), name, LocalDate.parse(introductionDate, formatter), LocalDate.parse(discontinued, formatter), Integer.valueOf(companyId)));

    }

    private static void findComputer() {
        System.out.println("Entrez l'id de l'ordinateur à chercher");
        String id = sc.nextLine();
        computerService.getComputer(Integer.parseInt(id));
    }
}
