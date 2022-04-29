import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class main extends Application {
    public Formula1ChampionshipManager managerClass = new Formula1ChampionshipManager();
    public static Scanner scanner = new Scanner(System.in);
    public void main() throws IOException, ClassNotFoundException {
        managerClass.load();
        MainMenu();
    }

    public void MainMenu(){
        while(true){
            System.out.println(" ");
            System.out.println(" - - - - -  Main Menu  - - - - -");
            System.out.println(" ");
            System.out.println("Press 'A' to add a new driver");
            System.out.println("Press 'B' to add a team");
            System.out.println("Press 'C' to Delete a driver");
            System.out.println("Press 'D' to Change driver in a team");
            System.out.println("Press 'E' to Display the statistics");
            System.out.println("Press 'F' to Display Driver Table");
            System.out.println("Press 'G' to Add a race");
            System.out.println("Press 'H' to Save");
            System.out.println("Press 'I' to Open the Graphical Interface");
            System.out.println("Press 'Q' to Quit the program");
            String Ans = scanner.next().toLowerCase();
            switch (Ans){
                case"a":
                    AddDriver();
                    break;
                case"b":
                    AddTeam();
                    break;
                case"c":
                    DeleteDriver();
                    break;
                case"d":
                    ChangeDriver();
                    break;
                case"e":
                    ViewStatistics();
                    break;
                case"f":
                    FormulaDriverTable();
                    break;
                case"g":
                    AddRace();
                    break;
                case"h":
                    SaveDrivers();
                    break;
                case"i":
                    GraphicalInterface();
                    break;
                case"j":
                    preLoadData();
                    break;
                case"q":
                    Quit();
                default:
                    System.out.println("Try Again !!");
            }
        }
    }

    public void Quit() {
        System.exit(1);
    }

    public void GraphicalInterface() {
        managerClass.gui();
    }

    public void SaveDrivers() {
        managerClass.saveDrivers();
    }

    public void FormulaDriverTable() {
        managerClass.formulaDriverTable();
    }

    public void AddRace() {
        managerClass.addRace();
    }

    public void ViewStatistics() {
        managerClass.viewStatistics();
    }

    public void ChangeDriver() {
        managerClass.changeDriver();
    }

    public void AddTeam() {
        managerClass.addTeam();
    }

    public void DeleteDriver() {
        managerClass.deleteDriver();
    }

    public void AddDriver() {
        managerClass.addDriver();
    }

    public void start(Stage primaryStage) throws Exception {
        main();
    }
    public void preLoadData() {
        Team team1 = new Team();
        Formula1Driver driver1= new Formula1Driver("Mahen","sri lanka",team1,21,2,3,332,19);
        Formula1Driver driver2= new Formula1Driver("Dunusinghe","sri lanka",team1,11,2,13,232,19);
        team1.setTeamName("Mercedes");
        team1.setDriverOne(driver1);
        team1.setDriverTwo(driver2);
        managerClass.formula1DriverArrayList.add(driver1);
        managerClass.formula1DriverArrayList.add(driver2);
        managerClass.formulaDriverTeams.add(team1);


        Team team2 = new Team();
        Formula1Driver driver3= new Formula1Driver("Sachithya","india",team2,1,11,3,111,19);
        Formula1Driver driver4= new Formula1Driver("Rivisara","india",team2,4,2,11,210,19);
        team2.setTeamName("Redbull");
        team2.setDriverOne(driver3);
        team2.setDriverTwo(driver4);
        managerClass.formula1DriverArrayList.add(driver3);
        managerClass.formula1DriverArrayList.add(driver4);
        managerClass.formulaDriverTeams.add(team2);


        Team team3 = new Team();
        Formula1Driver driver5= new Formula1Driver("Arshad","tex",team3,15,2,0,311,19);
        Formula1Driver driver6= new Formula1Driver("Azzad","tex",team3,1,8,19,199,19);
        team3.setTeamName("Ferrari");
        team3.setDriverOne(driver5);
        team3.setDriverTwo(driver6);
        managerClass.formula1DriverArrayList.add(driver5);
        managerClass.formula1DriverArrayList.add(driver6);
        managerClass.formulaDriverTeams.add(team3);

        Team team4 = new Team();
        Formula1Driver driver7= new Formula1Driver("Meraj","noth",team4,4,2,13,332,19);
        Formula1Driver driver8= new Formula1Driver("Vindira","north",team4,0,0,15,232,19);
        team4.setTeamName("Mazda");
        team4.setDriverOne(driver7);
        team4.setDriverTwo(driver8);
        managerClass.formula1DriverArrayList.add(driver7);
        managerClass.formula1DriverArrayList.add(driver8);
        managerClass.formulaDriverTeams.add(team4);

        Team team5 = new Team();
        Formula1Driver driver9= new Formula1Driver("Hakeem","waloy",team5,0,3,3,51,19);
        Formula1Driver driver10= new Formula1Driver("Fazli","waloy",team5,0,4,5,64,19);
        team5.setTeamName("Toyota");
        team5.setDriverOne(driver9);
        team5.setDriverTwo(driver10);
        managerClass.formula1DriverArrayList.add(driver9);
        managerClass.formula1DriverArrayList.add(driver10);
        managerClass.formulaDriverTeams.add(team5);

        Team team6 = new Team();
        Formula1Driver driver11= new Formula1Driver("Arushan","denmark",team6,21,4,5,333,19);
        Formula1Driver driver12= new Formula1Driver("Monoharan","denmark",team6,1,2,12,222,19);
        team6.setTeamName("Jaguar");
        team6.setDriverOne(driver11);
        team6.setDriverTwo(driver12);
        managerClass.formula1DriverArrayList.add(driver11);
        managerClass.formula1DriverArrayList.add(driver12);
        managerClass.formulaDriverTeams.add(team6);

        Team team7 = new Team();
        Formula1Driver driver13= new Formula1Driver("Bottas","Gys",team7,20,0,0,304,19);
        Formula1Driver driver14= new Formula1Driver("Hamilton","Gys",team7,11,2,13,233,19);
        team7.setTeamName("BMW");
        team7.setDriverOne(driver13);
        team7.setDriverTwo(driver14);
        managerClass.formula1DriverArrayList.add(driver13);
        managerClass.formula1DriverArrayList.add(driver14);
        managerClass.formulaDriverTeams.add(team7);


        Team team8 = new Team();
        Formula1Driver driver15= new Formula1Driver("Aqib","Usa",team8,17,4,7,289,19);
        Formula1Driver driver16= new Formula1Driver("Famiz","Usa",team8,2,4,13,113,19);
        team8.setTeamName("Lamboghini");
        team8.setDriverOne(driver15);
        team8.setDriverTwo(driver16);
        managerClass.formula1DriverArrayList.add(driver15);
        managerClass.formula1DriverArrayList.add(driver16);
        managerClass.formulaDriverTeams.add(team8);

        Team team9 = new Team();
        Formula1Driver driver17= new Formula1Driver("Chathura","Kon",team9,3,2,0,91,19);
        Formula1Driver driver18= new Formula1Driver("Nelligala","Kon",team9,0,21,10,68,19);
        team9.setTeamName("AlfaRomeo");
        team9.setDriverOne(driver17);
        team9.setDriverTwo(driver18);
        managerClass.formula1DriverArrayList.add(driver17);
        managerClass.formula1DriverArrayList.add(driver18);
        managerClass.formulaDriverTeams.add(team9);

        Team team10 = new Team();
        Formula1Driver driver19= new Formula1Driver("Wexter","lax",team10,0,4,0,46,19);
        Formula1Driver driver20= new Formula1Driver("Jugman","lax",team10,6,5,6,155,19);
        team10.setTeamName("Alpine");
        team10.setDriverOne(driver19);
        team10.setDriverTwo(driver20);
        managerClass.formula1DriverArrayList.add(driver19);
        managerClass.formula1DriverArrayList.add(driver20);
        managerClass.formulaDriverTeams.add(team10);
    }
}
