import com.squareup.okhttp.internal.http.HttpMethod;
import entities.Info;
import services.InfoImplementation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println(
                "Weather Menu \n" +
                        "1- Add Location \n" +
                        "2- Delete Location \n" +
                        "3- Show all Location \n" +
                        "4- Get Weather By Location \n" +
                        "0- Exit from App");
       Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
            switch (n) {
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
                    System.out.println("Jepni qytetin");
                    httpTest.getWeatherDataFromApi(scanner1.nextLine());
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Menu!");
                    break;
//               }
            }
        }

    }
