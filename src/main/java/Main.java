import com.squareup.okhttp.internal.http.HttpMethod;
import entities.Info;
import services.InfoImplementation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        mainMenu(); //call i menus kryesore

        disableWarning(); // disable all red warnings in hibernate

        System.out.println("Enter a number:");
        while (true) {
            switch (scanner.nextInt()) {
                case 1:
                    InfoImplementation.addLocation();
                    break;
                case 2:
                    InfoImplementation.deleteLocationById();
                    break;
                case 3:
                    InfoImplementation.listAllData();
                    break;
                case 4:
                    HttpTest httpTest = new HttpTest();
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Enter the City");
                    httpTest.getWeatherDataFromApi(scanner1.nextLine());
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Menu!");
                    break;
//               }
            }
            mainMenu();
            System.out.println("Choose ->");

        }

    }

    //main menu method
    static void mainMenu() {
        System.out.println(
                "\n Weather Menu \n" +
                        "[1] Add Location \n" +
                        "[2] Delete Location \n" +
                        "[3] Show all Location \n" +
                        "[4] Get Weather By Location \n" +
                        "[0] Exit from App \n ");
    }

    // disable all red warnings
    static void disableWarning() {
        System.err.close();
        System.setErr(System.out);
    }
}
