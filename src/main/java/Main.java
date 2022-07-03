import com.squareup.okhttp.internal.http.HttpMethod;
import entities.Info;
import services.InfoImplementation;

import java.util.Scanner;

public class Main {
    public static void main( String[] args)
    {
//       InfoImplementation.addLocation();
//        InfoImplementation.deleteLocationById(8);
  //        InfoImplementation.listAllData();
        HttpTest httpTest=new HttpTest();
        httpTest.getWeatherDataFromApi("Tirana");
    }
}
