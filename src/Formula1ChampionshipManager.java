import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Formula1ChampionshipManager implements ChampionshipManager {
    public Scanner scanner = new Scanner(System.in);
    public List<Formula1Driver> formula1DriverArrayList = new ArrayList<>();
    public List<Team> formulaDriverTeams = new ArrayList<>();
    public List<Race> formulaRaceHistory = new ArrayList<>();
    public Sort sortObject = new Sort();

    public void addTeam() {
        Team team = new Team();
        System.out.print("Enter the name of the team :");
        String name = scanner.next();
        if(formulaDriverTeams.size()<10){
            for(Team teamExist :formulaDriverTeams){
                if(teamExist.getTeamName().equals(name)){
                    System.out.print("The team you have added is already in the system.");
                }
            }
        }else{
            System.out.print("Maximum amount of teams have been added.");
        }
        team.setTeamName(name);
        formulaDriverTeams.add(team);
    }

    public void addDriver() {
        Formula1Driver driver = new Formula1Driver();

        System.out.print("Please Enter Driver Name ?");
        String Name = scanner.next();
        driver.setName(Name);

        System.out.print("Please Enter the Name Of the Team ?");
        String teamName = scanner.next();

        System.out.print("Please Enter Driver Location ?");
        String Location = scanner.next();
        driver.setLocation(Location);

        System.out.print("Please Enter the First Place Count ?");
        int firstPositionCount = scanner.nextInt();
        driver.setFirstPositions(firstPositionCount);

        System.out.print("Please Enter the Second Place Count ?");
        int secondPositionCount = scanner.nextInt();
        driver.setSecondPositions(secondPositionCount);

        System.out.print("Please Enter the Third Place Count ?");
        int thirdPositions = scanner.nextInt();
        driver.setThirdPositions(thirdPositions);

        System.out.print("Please Enter the Points Count ?");
        int points = scanner.nextInt();
        driver.setPoints(points);

        System.out.print("Please Enter the Number Of Races Participated ?");
        int numOfRaces = scanner.nextInt();
        driver.setNumOfRacesParticipated(numOfRaces);

        System.out.print("Please Select Driver Number For team { 1 / 2 } ?");
        int teamNo = scanner.nextInt();

        Team team = new Team();
        team.setTeamName(teamName);

        if (teamNo==1) {
            team.setDriverOne(driver);
            driver.setTeam(team);
        }
        else if (teamNo == 2) {
            team.setDriverTwo(driver);
            driver.setTeam(team);
        }


        formula1DriverArrayList.add(driver);
        System.out.println("added");
        System.out.println(formula1DriverArrayList.get(0).getTeam().getTeamName());
    }

    public void deleteDriver() {

        System.out.print("Please Enter Driver Name ?");
        String Name = scanner.next();

        for(Formula1Driver driver: formula1DriverArrayList){
            if(driver.getName().equals(Name)){
                formula1DriverArrayList.remove(driver);
                System.out.print("Deleted Driver Successfully..");
                break;
            }
        }
    }

    public void changeDriver() {
        System.out.print("Enter the name of the team :");
        String teamName = scanner.next();
        System.out.print("Enter the name of the driver team wants to be added :");
        String newDriverName = scanner.next();
        System.out.print("driver One or Driver Two ( 1 | 2 ) :");
        int driverNum = scanner.nextInt();
        for(Formula1Driver driver:formula1DriverArrayList){
            if(driver.getName().equals(newDriverName)){
                for (Team team: formulaDriverTeams){
                    if(team.getTeamName().equals(teamName)){
                        if(driverNum == 1){
                            team.setDriverOne(driver);
                            driver.setTeam(team);
                        }else if(driverNum == 2){
                            team.setDriverTwo(driver);
                            driver.setTeam(team);
                        }else{
                            System.out.print("wrong input !!");
                        }
                    }
                }
            }
        }
    }

    public void viewStatistics() {
        System.out.print("Enter the name of the driver :");
        String name = scanner.next();

        for(Formula1Driver formula1Driver: formula1DriverArrayList){
            if(formula1Driver.getName().equals(name)){
                System.out.println("| Driver Name : "+ name+ " | Team : "+ formula1Driver.getTeam()+" | Location : "+ formula1Driver.getTeam()+" |=> "+" Player Statistics ");
                System.out.println(" "+formula1Driver.getFirstPositions()+ " first Position wins");
                System.out.println(" "+formula1Driver.getSecondPositions()+ " second Position wins");
                System.out.println(" "+formula1Driver.getThirdPositions()+ " third Position wins");
                System.out.println(" "+formula1Driver.getPoints()+ " points");
                System.out.println(" "+formula1Driver.getNumOfRacesParticipated()+ " Number of Races");
                break;
            }else{
                System.out.print("No driver found under that name !!");
            }
        }

    }
    public void formulaDriverTable() {
        for(Formula1Driver formula1Driver: formula1DriverArrayList){
            System.out.print(formula1Driver.toStr());
        }
    }

    public void addRace() {
        Race race = new Race();
        int[] intArray = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};
        if (formulaDriverTeams.size() < 10 || formula1DriverArrayList.size() < 20 ) {
            System.out.print("there are not enough teams to add a Race");
        }else{
            System.out.print("Enter the Date of the Race..? eg:(dd/mm/year)");
            String DateM = scanner.next();

            String [] DateA = DateM.split("/");
            int days = Integer.parseInt(DateA[0]);
            int months = Integer.parseInt(DateA[1]);
            int years = Integer.parseInt(DateA[2]);

            if(years>2000 && years<2030){
                if(months>0 && months<12){
                    if(days>0 && days<32){
                        Date date = new Date(days,months,years);
                        race.setRaceDate(date);
                    }
                }
            }
            List<Formula1Driver> randomPsArray = new ArrayList<>(formula1DriverArrayList);
            ArrayShuffle(intArray);

            race.setFirstPosition(randomPsArray.get(intArray[0]));
            race.getFirstPosition().setFirstPositions(race.getFirstPosition().getFirstPositions()+1);
            race.getFirstPosition().setPoints(race.getFirstPosition().getPoints()+25);

            race.setSecondPosition(randomPsArray.get(intArray[1]));
            race.getSecondPosition().setSecondPositions(race.getSecondPosition().getSecondPositions()+1);
            race.getSecondPosition().setPoints(race.getSecondPosition().getPoints()+18);

            race.setThirdPosition(randomPsArray.get(intArray[2]));
            race.getThirdPosition().setThirdPositions(race.getThirdPosition().getThirdPositions()+1);
            race.getThirdPosition().setPoints(race.getThirdPosition().getPoints()+15);

            race.setForthPosition(randomPsArray.get(intArray[3]));
            race.getForthPosition().setPoints(race.getForthPosition().getPoints()+12);

            race.setFifthPosition(randomPsArray.get(intArray[4]));
            race.getFifthPosition().setPoints(race.getFifthPosition().getPoints()+10);

            race.setSixthPosition(randomPsArray.get(intArray[5]));
            race.getSixthPosition().setPoints(race.getSixthPosition().getPoints()+8);

            race.setSeventhPosition(randomPsArray.get(intArray[6]));
            race.getSeventhPosition().setPoints(race.getSeventhPosition().getPoints()+6);

            race.setEighthPosition(randomPsArray.get(intArray[7]));
            race.getEighthPosition().setPoints(race.getEighthPosition().getPoints()+4);

            race.setNinthPosition(randomPsArray.get(intArray[8]));
            race.getNinthPosition().setPoints(race.getNinthPosition().getPoints()+2);

            race.setTenthPosition(randomPsArray.get(intArray[9]));
            race.getTenthPosition().setPoints(race.getTenthPosition().getPoints()+1);

            for (Formula1Driver trackDriver: formula1DriverArrayList){
                trackDriver.setNumOfRacesParticipated(trackDriver.getNumOfRacesParticipated()+1);
            }

            formulaRaceHistory.add(race);
            System.out.print("Race added successfully..");
        }

    }

    static void ArrayShuffle(int[] Array)
    {
        Random randomInt = ThreadLocalRandom.current();
        for (int i = Array.length - 1; i > 0; i--)
        {
            int index = randomInt.nextInt(i + 1);
            int a = Array[index];
            Array[index] = Array[i];
            Array[i] = a;
        }
// https://stackoverflow.com/questions/1519736/random-shuffling-of-an-array - source of this method

    }

    public void gui() {
        Stage stage = new Stage();
        GridPane gridPane = new GridPane();
        Font font = new Font("Times New Roman",12);
        gridPane.setAlignment(Pos.TOP_CENTER);

        HBox hboxTitle = new HBox();
        Text title = new Text("FORMULA ONE");
        title.setFont(Font.font("Times New Roman", FontWeight.BLACK, 45));
        title.setTextAlignment(TextAlignment.CENTER);
        hboxTitle.getChildren().add(title);
        hboxTitle.setAlignment(Pos.CENTER);
        gridPane.add(hboxTitle,1,1);

        HBox hbox = new HBox();

        Button driverTableBtn = new Button("Driver Table");
        driverTableBtn.setOnMouseExited(e -> driverTableBtn.setStyle("-fx-background-color: linear-gradient(#70865c 0%, rgba(35,39,35,0.34) 25%, #373837 75%, #70865c 100%); -fx-background-radius: 35; -fx-background-insets: 0; -fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-font-weight: bold;-fx-font-size: 1.3em;"));
        driverTableBtn.setOnMouseEntered(e -> driverTableBtn.setStyle("-fx-background-color: linear-gradient(#70865c 0%, rgba(35,39,35,0.34) 25%, #373837 75%, #70865c 100%); -fx-background-radius: 35; -fx-background-insets: 0; -fx-text-fill: white;-fx-font-size: 1.1em;"));
        driverTableBtn.setStyle("-fx-background-color: linear-gradient(#70865c 0%, rgba(35,39,35,0.34) 25%, #373837 75%, #70865c 100%); -fx-background-radius: 35; -fx-background-insets: 0; -fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-font-weight: bold;-fx-font-size: 1.3em;");
        driverTableBtn.setFont(font);
        driverTableBtn.setPrefSize(120,50);
        driverTableBtn.setOnAction(actionEvent -> {
            formulaDriverTableInterface();
        });

        Button RaceTableBtn = new Button("Race Table");
        RaceTableBtn.setOnMouseExited(e -> RaceTableBtn.setStyle("-fx-background-color: linear-gradient(#70865c 0%, rgba(35,39,35,0.34) 25%, #373837 75%, #70865c 100%); -fx-background-radius: 35; -fx-background-insets: 0; -fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-font-weight: bold;-fx-font-size: 1.2em;"));
        RaceTableBtn.setOnMouseEntered(e -> RaceTableBtn.setStyle("-fx-background-color: linear-gradient(#70865c 0%, rgba(35,39,35,0.34) 25%, #373837 75%, #70865c 100%); -fx-background-radius: 35; -fx-background-insets: 0; -fx-text-fill: white;-fx-font-size: 1.1em;"));
        RaceTableBtn.setStyle("-fx-background-color: linear-gradient(#70865c 0%, rgba(35,39,35,0.34) 25%, #373837 75%, #70865c 100%); -fx-background-radius: 35; -fx-background-insets: 0; -fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-font-weight: bold;-fx-font-size: 1.2em;");
        RaceTableBtn.setFont(font);
        RaceTableBtn.setPrefSize(120,50);
        RaceTableBtn.setOnAction(actionEvent -> {
            formulaRaceTableInterface();
        });

        Button startRaceBtn = new Button("Add Race");
        startRaceBtn.setOnMouseExited(e -> startRaceBtn.setStyle("-fx-background-color: linear-gradient(#70865c 0%, rgba(35,39,35,0.34) 25%, #373837 75%, #70865c 100%); -fx-background-radius: 35; -fx-background-insets: 0; -fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-font-weight: bold;-fx-font-size: 1.1em;"));
        startRaceBtn.setOnMouseEntered(e -> startRaceBtn.setStyle("-fx-background-color: linear-gradient(#70865c 0%, rgba(35,39,35,0.34) 25%, #373837 75%, #70865c 100%); -fx-background-radius: 35; -fx-background-insets: 0; -fx-text-fill: white;-fx-font-size: 1em;"));
        startRaceBtn.setStyle("-fx-background-color: linear-gradient(#70865c 0%, rgba(35,39,35,0.34) 25%, #373837 75%, #70865c 100%); -fx-background-radius: 35; -fx-background-insets: 0; -fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-font-weight: bold;-fx-font-size: 1.1em;");
        startRaceBtn.setFont(font);
        startRaceBtn.setPrefSize(120,50);
        startRaceBtn.setOnAction(actionEvent -> {
            formulaAddRacesInterface();
        });

        Button searchRaceBtn = new Button("Find Race");
        searchRaceBtn.setOnMouseExited(e -> searchRaceBtn.setStyle("-fx-background-color: linear-gradient(#70865c 0%, rgba(35,39,35,0.34) 25%, #373837 75%, #70865c 100%); -fx-background-radius: 35; -fx-background-insets: 0; -fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-font-weight: bold;-fx-font-size: 1.1em;"));
        searchRaceBtn.setOnMouseEntered(e -> searchRaceBtn.setStyle("-fx-background-color: linear-gradient(#70865c 0%, rgba(35,39,35,0.34) 25%, #373837 75%, #70865c 100%); -fx-background-radius: 35; -fx-background-insets: 0; -fx-text-fill: white;-fx-font-size: 1em;"));
        searchRaceBtn.setStyle("-fx-background-color: linear-gradient(#70865c 0%, rgba(35,39,35,0.34) 25%, #373837 75%, #70865c 100%); -fx-background-radius: 35; -fx-background-insets: 0; -fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-font-weight: bold;-fx-font-size: 1.1em;");
        searchRaceBtn.setFont(font);
        searchRaceBtn.setPrefSize(120,50);
        searchRaceBtn.setOnAction(actionEvent -> {
            formulaFindRacesGUI();
        });

        hbox.getChildren().addAll(driverTableBtn,RaceTableBtn,startRaceBtn,searchRaceBtn);
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(5);
        gridPane.add(hbox,1,2);

        Scene Scene = new Scene(gridPane,800,550);
        stage.setScene(Scene);
        stage.showAndWait();
    }

    private void formulaRaceTableInterface() {
        final HBox HBox = new HBox();
        Stage stage = new Stage();

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(15);

        Text scenetitle = new Text("Formula One Race Table");
        scenetitle.setFont(Font.font("Times New Roman", FontWeight.BOLD, 35));
        HBox.getChildren().add(scenetitle);
        HBox.setAlignment(Pos.CENTER);
        gridPane.add(HBox,0,0);

        Text sortOp = new Text("Sort Option : ");
        sortOp.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));

        TableView TableView = new TableView();
        TableColumn<Date, Race> column0 = new TableColumn<>("Date");
        column0.setCellValueFactory(new PropertyValueFactory<>("raceDate"));
        TableView.getColumns().add(column0);

        TableColumn<String, Race> column1 = new TableColumn<>("firstPosition");
        column1.setCellValueFactory(new PropertyValueFactory<>("firstPosition"));
        TableView.getColumns().add(column1);

        TableColumn<Integer, Race> column2 = new TableColumn<>("secondPosition");
        column2.setCellValueFactory(new PropertyValueFactory<>("secondPosition"));
        TableView.getColumns().add(column2);

        TableColumn<Integer, Race> column3 = new TableColumn<>("thirdPosition");
        column3.setCellValueFactory(new PropertyValueFactory<>("thirdPosition"));
        TableView.getColumns().add(column3);

        TableColumn<Integer, Race> column4 = new TableColumn<>("forthPosition");
        column4.setCellValueFactory(new PropertyValueFactory<>("forthPosition"));
        TableView.getColumns().add(column4);

        TableColumn<Integer, Race> column5 = new TableColumn<>("fifthPosition");
        column5.setCellValueFactory(new PropertyValueFactory<>("fifthPosition"));
        TableView.getColumns().add(column5);

        TableColumn<String, Race> column6 = new TableColumn<>("sixthPosition");
        column6.setCellValueFactory(new PropertyValueFactory<>("sixthPosition"));
        TableView.getColumns().add(column6);

        TableColumn<Integer, Race> column7 = new TableColumn<>("seventhPosition");
        column7.setCellValueFactory(new PropertyValueFactory<>("seventhPosition"));
        TableView.getColumns().add(column7);

        TableColumn<Integer, Race> column8 = new TableColumn<>("eighthPosition");
        column8.setCellValueFactory(new PropertyValueFactory<>("eighthPosition"));
        TableView.getColumns().add(column8);

        TableColumn<Integer, Race> column9 = new TableColumn<>("ninthPosition");
        column9.setCellValueFactory(new PropertyValueFactory<>("ninthPosition"));
        TableView.getColumns().add(column9);

        TableColumn<Integer, Race> column10 = new TableColumn<>("tenthPosition");
        column10.setCellValueFactory(new PropertyValueFactory<>("tenthPosition"));
        TableView.getColumns().add(column10);
        TableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        

        for (Race races : formulaRaceHistory) {
            TableView.getItems().add(races);
        }

        Button back = new Button("Back");
        back.setOnMouseExited(e -> back.setStyle("-fx-background-color: linear-gradient(#090909,salmon); -fx-background-radius: 30; -fx-background-insets: 0; -fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-font-weight: bold;-fx-font-size: 1.1em;"));
        back.setOnMouseEntered(e -> back.setStyle("-fx-background-color: linear-gradient(#090909,saddlebrown); -fx-background-radius: 30; -fx-background-insets: 0; -fx-text-fill: white;-fx-font-size: 1.1em;"));
        back.setStyle("-fx-background-color: linear-gradient(#090909,salmon); -fx-background-radius: 30; -fx-background-insets: 0; -fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-font-weight: bold;-fx-font-size: 1.1em;");
        back.setPrefSize(100,25);
        back.setOnAction(actionEvent -> {
            stage.close();
        });

        gridPane.add(back,3,7);

        gridPane.add(TableView,0,3);
        Scene Scene = new Scene(gridPane,800,550);
        stage.setScene(Scene);
        stage.showAndWait();
    }

    private void formulaFindRacesGUI() {
        Stage stage = new Stage();
        GridPane gridPane = new GridPane();
        gridPane.setVgap(15);
        gridPane.setAlignment(Pos.CENTER);

        HBox hboX = new HBox();
        Text scenetitle = new Text("Find Race");
        scenetitle.setFont(Font.font("Times New Roman", FontWeight.BOLD, 35));
        hboX.getChildren().add(scenetitle);
        hboX.setAlignment(Pos.CENTER);
        gridPane.add(hboX, 0, 0);

        Button back = new Button("Back");
        back.setOnMouseExited(e -> back.setStyle("-fx-background-color: linear-gradient(#090909,salmon); -fx-background-radius: 30; -fx-background-insets: 0; -fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-font-weight: bold;-fx-font-size: 1.1em;"));
        back.setOnMouseEntered(e -> back.setStyle("-fx-background-color: linear-gradient(#090909,saddlebrown); -fx-background-radius: 30; -fx-background-insets: 0; -fx-text-fill: white;-fx-font-size: 1.1em;"));
        back.setStyle("-fx-background-color: linear-gradient(#090909,salmon); -fx-background-radius: 30; -fx-background-insets: 0; -fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-font-weight: bold;-fx-font-size: 1.1em;");
        back.setPrefSize(100,25);
        back.setOnAction(actionEvent -> {
            stage.close();
        });

        HBox hbox = new HBox();
        final Label label = new Label("Enter the Date of the Race    ");
        label.setFont(new Font("Times New Roman", 20));
        DatePicker datePicker = new DatePicker();


        Button button = new Button("Find");
        button.setOnMouseExited(e -> button.setStyle("-fx-background-color:linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%), linear-gradient(#020b02, #3a3a3a), linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%), linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%); -fx-background-insets: 0,1,4,5,6;-fx-background-radius: 9,8,5,4,3;-fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);-fx-font-size: 1.1em;"));
        button.setOnMouseEntered(e -> button.setStyle("-fx-background-color:linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%), linear-gradient(#020b02, #3a3a3a), linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%); -fx-background-insets: 0,1,4,5,6;-fx-background-radius: 9,8,5,4,3;-fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);"));
        button.setStyle("-fx-background-color:linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%), linear-gradient(#020b02, #3a3a3a), linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%), linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%); -fx-background-insets: 0,1,4,5,6;-fx-background-radius: 9,8,5,4,3;-fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);-fx-font-size: 1.1em;");

        button.setPrefSize(100, 25);
        button.setOnAction(action -> {

            TableView TableView = new TableView();
            TableColumn<Date, Race> column0 = new TableColumn<>("Date");
            column0.setCellValueFactory(new PropertyValueFactory<>("raceDate"));
            TableView.getColumns().add(column0);

            TableColumn<String, Race> column1 = new TableColumn<>("firstPosition");
            column1.setCellValueFactory(new PropertyValueFactory<>("firstPosition"));
            TableView.getColumns().add(column1);

            TableColumn<Integer, Race> column2 = new TableColumn<>("secondPosition");
            column2.setCellValueFactory(new PropertyValueFactory<>("secondPosition"));
            TableView.getColumns().add(column2);

            TableColumn<Integer, Race> column3 = new TableColumn<>("thirdPosition");
            column3.setCellValueFactory(new PropertyValueFactory<>("thirdPosition"));
            TableView.getColumns().add(column3);

            TableColumn<Integer, Race> column4 = new TableColumn<>("forthPosition");
            column4.setCellValueFactory(new PropertyValueFactory<>("forthPosition"));
            TableView.getColumns().add(column4);

            TableColumn<Integer, Race> column5 = new TableColumn<>("fifthPosition");
            column5.setCellValueFactory(new PropertyValueFactory<>("fifthPosition"));
            TableView.getColumns().add(column5);

            TableColumn<String, Race> column6 = new TableColumn<>("sixthPosition");
            column6.setCellValueFactory(new PropertyValueFactory<>("sixthPosition"));
            TableView.getColumns().add(column6);

            TableColumn<Integer, Race> column7 = new TableColumn<>("seventhPosition");
            column7.setCellValueFactory(new PropertyValueFactory<>("seventhPosition"));
            TableView.getColumns().add(column7);

            TableColumn<Integer, Race> column8 = new TableColumn<>("eighthPosition");
            column8.setCellValueFactory(new PropertyValueFactory<>("eighthPosition"));
            TableView.getColumns().add(column8);

            TableColumn<Integer, Race> column9 = new TableColumn<>("ninthPosition");
            column9.setCellValueFactory(new PropertyValueFactory<>("ninthPosition"));
            TableView.getColumns().add(column9);

            TableColumn<Integer, Race> column10 = new TableColumn<>("tenthPosition");
            column10.setCellValueFactory(new PropertyValueFactory<>("tenthPosition"));
            TableView.getColumns().add(column10);
            TableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

            String DateM = String.valueOf(datePicker.getValue());
            String[] DateA = DateM.split("-");
            int days = Integer.parseInt(DateA[2]);
            int months = Integer.parseInt(DateA[1]);
            int years = Integer.parseInt(DateA[0]);

            Date date = new Date(days,months,years);

            TableView.getItems().clear();

            for (Race races : formulaRaceHistory) {
                System.out.println(races.getRaceDate());
                if (races.getRaceDate().equals(date)){
                    TableView.getItems().add(races);
                }
            }
            HBox hboxx = new HBox();
            TableView.setPrefSize(790,450);
            hboxx.getChildren().add(TableView);
            hboxx.setAlignment(Pos.CENTER);
            gridPane.add(hboxx,0,2);
        });

        gridPane.add(back,3,6);

        hbox.getChildren().addAll(label,datePicker,button);
        hbox.setSpacing(15);
        gridPane.add(hbox,0,1);

        Scene scene = new Scene(gridPane,800,550);
        stage.setScene(scene);
        stage.showAndWait();
    }

    private void formulaAddRacesInterface() {
        try{
            Stage stage = new Stage();
            GridPane gridPane = new GridPane();
            gridPane.setVgap(15);
            gridPane.setAlignment(Pos.CENTER);

            HBox HBox = new HBox();
            Text scenetitle = new Text("Add Race");
            scenetitle.setFont(Font.font("Times New Roman", FontWeight.BOLD, 35));
            HBox.getChildren().add(scenetitle);
            HBox.setAlignment(Pos.CENTER);
            gridPane.add(HBox,0,0);

            HBox hbox = new HBox();
            final Label label = new Label("Add Race date ");
            label.setFont(new Font("Times New Roman", 20));

            DatePicker datePicker = new DatePicker();
            TableView TableView = new TableView();

            TableColumn<Date, Race> column0 = new TableColumn<>("Date");
            column0.setCellValueFactory(new PropertyValueFactory<>("raceDate"));
            TableView.getColumns().add(column0);

            TableColumn<String, Race> column1 = new TableColumn<>("firstPosition");
            column1.setCellValueFactory(new PropertyValueFactory<>("firstPosition"));
            TableView.getColumns().add(column1);

            TableColumn<Integer, Race> column2 = new TableColumn<>("secondPosition");
            column2.setCellValueFactory(new PropertyValueFactory<>("secondPosition"));
            TableView.getColumns().add(column2);

            TableColumn<Integer, Race> column3 = new TableColumn<>("thirdPosition");
            column3.setCellValueFactory(new PropertyValueFactory<>("thirdPosition"));
            TableView.getColumns().add(column3);

            TableColumn<Integer, Race> column4 = new TableColumn<>("forthPosition");
            column4.setCellValueFactory(new PropertyValueFactory<>("forthPosition"));
            TableView.getColumns().add(column4);

            TableColumn<Integer, Race> column5 = new TableColumn<>("fifthPosition");
            column5.setCellValueFactory(new PropertyValueFactory<>("fifthPosition"));
            TableView.getColumns().add(column5);

            TableColumn<String, Race> column6 = new TableColumn<>("sixthPosition");
            column6.setCellValueFactory(new PropertyValueFactory<>("sixthPosition"));
            TableView.getColumns().add(column6);

            TableColumn<Integer, Race> column7 = new TableColumn<>("seventhPosition");
            column7.setCellValueFactory(new PropertyValueFactory<>("seventhPosition"));
            TableView.getColumns().add(column7);

            TableColumn<Integer, Race> column8 = new TableColumn<>("eighthPosition");
            column8.setCellValueFactory(new PropertyValueFactory<>("eighthPosition"));
            TableView.getColumns().add(column8);

            TableColumn<Integer, Race> column9 = new TableColumn<>("ninthPosition");
            column9.setCellValueFactory(new PropertyValueFactory<>("ninthPosition"));
            TableView.getColumns().add(column9);

            TableColumn<Integer, Race> column10 = new TableColumn<>("tenthPosition");
            column10.setCellValueFactory(new PropertyValueFactory<>("tenthPosition"));
            TableView.getColumns().add(column10);
            TableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

            Button AddButton = new Button("Generate");
            AddButton.setOnMouseExited(e -> AddButton.setStyle("-fx-background-color:linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%), linear-gradient(#020b02, #3a3a3a), linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%), linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%); -fx-background-insets: 0,1,4,5,6;-fx-background-radius: 9,8,5,4,3;-fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);-fx-font-size: 1.1em;"));
            AddButton.setOnMouseEntered(e -> AddButton.setStyle("-fx-background-color:linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%), linear-gradient(#020b02, #3a3a3a), linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%); -fx-background-insets: 0,1,4,5,6;-fx-background-radius: 9,8,5,4,3;-fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);"));
            AddButton.setStyle("-fx-background-color:linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%), linear-gradient(#020b02, #3a3a3a), linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%), linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%); -fx-background-insets: 0,1,4,5,6;-fx-background-radius: 9,8,5,4,3;-fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);-fx-font-size: 1.1em;");

            AddButton.setPrefSize(100,25);
            AddButton.setOnAction(action -> {
                int[] intArray = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};

                if (datePicker.getValue()!=null) {
                    HBox Hbox = new HBox();
                    TableView.getItems().clear();

                    String date = String.valueOf(datePicker.getValue());
                    String[] DateA = date.split("-");
                    int days = Integer.parseInt(DateA[2]);
                    int months = Integer.parseInt(DateA[1]);
                    int years = Integer.parseInt(DateA[0]);

                    Race Race = new Race();

                    if (formulaDriverTeams.size() < 10 || formula1DriverArrayList.size() < 20 ) {
                        System.out.print("there are not enough teams to add a Race");
                    }else{
                        Date dates = new Date(days,months,years);
                        Race.setRaceDate(dates);
                    }
                    ArrayShuffle(intArray);

                    Race.setFirstPosition(formula1DriverArrayList.get(intArray[0]));
                    Race.getFirstPosition().setFirstPositions(Race.getFirstPosition().getFirstPositions()+1);
                    Race.getFirstPosition().setPoints(Race.getFirstPosition().getPoints()+25);
                    Race.getFirstPosition().setNumOfRacesParticipated(Race.getFirstPosition().getNumOfRacesParticipated()+1);

                    Race.setSecondPosition(formula1DriverArrayList.get(intArray[1]));
                    Race.getSecondPosition().setSecondPositions(Race.getSecondPosition().getSecondPositions()+1);
                    Race.getSecondPosition().setPoints(Race.getSecondPosition().getPoints()+18);
                    Race.getSecondPosition().setNumOfRacesParticipated(Race.getSecondPosition().getNumOfRacesParticipated()+1);

                    Race.setThirdPosition(formula1DriverArrayList.get(intArray[2]));
                    Race.getThirdPosition().setThirdPositions(Race.getThirdPosition().getThirdPositions()+1);
                    Race.getThirdPosition().setPoints(Race.getThirdPosition().getPoints()+15);
                    Race.getThirdPosition().setNumOfRacesParticipated(Race.getThirdPosition().getNumOfRacesParticipated()+1);

                    Race.setForthPosition(formula1DriverArrayList.get(intArray[3]));
                    Race.getForthPosition().setPoints(Race.getForthPosition().getPoints()+12);
                    Race.getForthPosition().setNumOfRacesParticipated(Race.getForthPosition().getNumOfRacesParticipated()+1);

                    Race.setFifthPosition(formula1DriverArrayList.get(intArray[4]));
                    Race.getFifthPosition().setPoints(Race.getFifthPosition().getPoints()+10);
                    Race.getFifthPosition().setNumOfRacesParticipated(Race.getFifthPosition().getNumOfRacesParticipated()+1);

                    Race.setSixthPosition(formula1DriverArrayList.get(intArray[5]));
                    Race.getSixthPosition().setPoints(Race.getSixthPosition().getPoints()+8);
                    Race.getSixthPosition().setNumOfRacesParticipated(Race.getSixthPosition().getNumOfRacesParticipated()+1);

                    Race.setSeventhPosition(formula1DriverArrayList.get(intArray[6]));
                    Race.getSeventhPosition().setPoints(Race.getSeventhPosition().getPoints()+6);
                    Race.getSeventhPosition().setNumOfRacesParticipated(Race.getSeventhPosition().getNumOfRacesParticipated()+1);

                    Race.setEighthPosition(formula1DriverArrayList.get(intArray[7]));
                    Race.getEighthPosition().setPoints(Race.getEighthPosition().getPoints()+4);
                    Race.getEighthPosition().setNumOfRacesParticipated(Race.getEighthPosition().getNumOfRacesParticipated()+1);

                    Race.setNinthPosition(formula1DriverArrayList.get(intArray[8]));
                    Race.getNinthPosition().setPoints(Race.getNinthPosition().getPoints()+2);
                    Race.getNinthPosition().setNumOfRacesParticipated(Race.getNinthPosition().getNumOfRacesParticipated()+1);

                    Race.setTenthPosition(formula1DriverArrayList.get(intArray[9]));
                    Race.getTenthPosition().setPoints(Race.getTenthPosition().getPoints()+1);
                    Race.getTenthPosition().setNumOfRacesParticipated(Race.getTenthPosition().getNumOfRacesParticipated()+1);

                    formulaRaceHistory.add(Race);
                    for (Race reces : formulaRaceHistory) {
                        TableView.getItems().add(reces);
                    }

                    System.out.println("Race added...");

                    TableView.setPrefSize(790,450);
                    Hbox.getChildren().add(TableView);
                    Hbox.setAlignment(Pos.CENTER);
                    gridPane.add(Hbox, 0, 2);
                }else{
                    Alert alert = new Alert(Alert.AlertType.NONE);
                    alert.setContentText("Date Invalid");
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setHeaderText("!!!!!");
                    alert.show();
                }
            });

            Button backBtn = new Button("Back");
            backBtn.setOnMouseExited(e -> backBtn.setStyle("-fx-background-color: linear-gradient(#090909,salmon); -fx-background-radius: 30; -fx-background-insets: 0; -fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-font-weight: bold;-fx-font-size: 1.1em;"));
            backBtn.setOnMouseEntered(e -> backBtn.setStyle("-fx-background-color: linear-gradient(#090909,saddlebrown); -fx-background-radius: 30; -fx-background-insets: 0; -fx-text-fill: white;-fx-font-size: 1.1em;"));
            backBtn.setStyle("-fx-background-color: linear-gradient(#090909,salmon); -fx-background-radius: 30; -fx-background-insets: 0; -fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-font-weight: bold;-fx-font-size: 1.1em;");
            backBtn.setPrefSize(100,25);
            backBtn.setOnAction(actionEvent -> {
                stage.close();
            });

            gridPane.add(backBtn,3,7);
            hbox.getChildren().addAll(label,datePicker,AddButton);
            hbox.setSpacing(15);
            gridPane.add(hbox,0,1);

            Scene scene = new Scene(gridPane,800,550);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveDrivers() {
        String file="textFile.txt";
        try{
            ObjectOutputStream ObjSaving =new ObjectOutputStream(new FileOutputStream(file));
            for(Formula1Driver driver:formula1DriverArrayList){
                ObjSaving.writeObject(driver);
            }
            ObjSaving.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("Saving Completed..");
    }


    public void load() throws IOException,ClassNotFoundException {
        File file = new File("textFile.txt");
        try {
            if(file.length()!=0) {
                FileInputStream fileInputStr = new FileInputStream("textFile.txt");
                ObjectInputStream ObjSavingStr = new ObjectInputStream(fileInputStr);
                for (; ; ) {
                    try {
                        formula1DriverArrayList.add((Formula1Driver) ObjSavingStr.readObject());
                    } catch (EOFException e) {
                        break;
                    }
                }
                System.out.print("Loading...");
                System.out.print("Successfully Loaded");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void formulaDriverTableInterface(){

        final HBox HBox = new HBox();
        Stage stages = new Stage();

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(15);

        Text scenetitle = new Text("Driver Table");
        scenetitle.setFont(Font.font("Times New Roman", FontWeight.BOLD, 29));
        HBox.getChildren().add(scenetitle);
        HBox.setAlignment(Pos.CENTER);
        gridPane.add(HBox,0,0);

        ComboBox ComboBox = new ComboBox();
        ComboBox.getItems().add("sort by points - desc");
        ComboBox.getItems().add("sort by points - asc");
        ComboBox.getItems().add("sort by first positions ");
        ComboBox.getSelectionModel().selectFirst();

        Text sortOp = new Text("Sort By ");
        sortOp.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));

        HBox hbox = new HBox();
        hbox.getChildren().addAll(sortOp, ComboBox);
        hbox.setAlignment(Pos.CENTER_RIGHT);
        hbox.setSpacing(10);

        gridPane.add(hbox,0,2);

        TableView TableView = new TableView();

        TableColumn<String, Formula1Driver> column0 = new TableColumn<>("Name");
        column0.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableView.getColumns().add(column0);

        TableColumn<String, Formula1Driver> column1 = new TableColumn<>("Location");
        column1.setCellValueFactory(new PropertyValueFactory<>("location"));
        TableView.getColumns().add(column1);

        TableColumn<Integer, Formula1Driver> column2 = new TableColumn<>("Team");
        column2.setCellValueFactory(new PropertyValueFactory<>("team"));
        TableView.getColumns().add(column2);

        TableColumn<Integer, Formula1Driver> column3 = new TableColumn<>("First Positions");
        column3.setCellValueFactory(new PropertyValueFactory<>("firstPositions"));
        TableView.getColumns().add(column3);

        TableColumn<Integer, Formula1Driver> column4 = new TableColumn<>("Second Positions");
        column4.setCellValueFactory(new PropertyValueFactory<>("secondPositions"));
        TableView.getColumns().add(column4);

        TableColumn<Integer, Formula1Driver> column5 = new TableColumn<>("Third Positions");
        column5.setCellValueFactory(new PropertyValueFactory<>("thirdPositions"));
        TableView.getColumns().add(column5);

        TableColumn<Integer, Formula1Driver> column6 = new TableColumn<>("Races Participated");
        column6.setCellValueFactory(new PropertyValueFactory<>("numOfRacesParticipated"));
        TableView.getColumns().add(column6);

        TableColumn<Integer, Formula1Driver> column7 = new TableColumn<>("Points");
        column7.setCellValueFactory(new PropertyValueFactory<>("points"));
        TableView.getColumns().add(column7);
        TableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        formula1DriverArrayList.sort(sortObject.pointsSortDesc);
        for (Formula1Driver driver : formula1DriverArrayList) {
            TableView.getItems().add(driver);
        }

        EventHandler<ActionEvent> Event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                String val = (String) ComboBox.getValue();
                TableView.getItems().clear();
                if (val.equals("sort by points - desc")) {
                    TableView.getItems().clear();
                    formula1DriverArrayList.sort(sortObject.pointsSortDesc);
                    for (Formula1Driver driver : formula1DriverArrayList) {
                        TableView.getItems().add(driver);
                    }
                } else if (val.equals("sort by points - asc")) {
                    TableView.getItems().clear();
                    formula1DriverArrayList.sort(sortObject.pointsSortAsc);
                    for (Formula1Driver driver : formula1DriverArrayList) {
                        TableView.getItems().add(driver);
                    }
                } else if (val.equals("sort by first positions ")) {
                    TableView.getItems().clear();
                    formula1DriverArrayList.sort(sortObject.firstPositionSort);
                    for (Formula1Driver driver : formula1DriverArrayList) {
                        TableView.getItems().add(driver);
                    }
                }
            }
        };
        ComboBox.setOnAction(Event);

        Button backBtn = new Button("Back");
        backBtn.setOnMouseExited(e -> backBtn.setStyle("-fx-background-color: linear-gradient(#090909,salmon); -fx-background-radius: 30; -fx-background-insets: 0; -fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-font-weight: bold;-fx-font-size: 1.1em;"));
        backBtn.setOnMouseEntered(e -> backBtn.setStyle("-fx-background-color: linear-gradient(#090909,saddlebrown); -fx-background-radius: 30; -fx-background-insets: 0; -fx-text-fill: white;-fx-font-size: 1.1em;"));
        backBtn.setStyle("-fx-background-color: linear-gradient(#090909,salmon); -fx-background-radius: 30; -fx-background-insets: 0; -fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-font-weight: bold;-fx-font-size: 1.1em;");
        backBtn.setPrefSize(100,25);
        backBtn.setOnAction(actionEvent -> {
            stages.close();
        });

        gridPane.add(backBtn,3,7);

        gridPane.add(TableView,0,3);
        Scene Scene = new Scene(gridPane,800,550);
        stages.setScene(Scene);
        stages.showAndWait();
    }

}
