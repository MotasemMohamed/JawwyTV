package Data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonDataReader2 {
    public String countrycode,countryname,NewEssentialpackprice,OldEssentialpackprice,lightpackprice,Essentialpackprice,
            Premiumpackprice,FightSport,PaymentMethod,Tvjaw,Total_Payment,PhoneName;

    public void JsonReader() throws IOException, ParseException {
        String filePath= System.getProperty("user.dir")+"/src/test/java/Data/UserDataForOtherCountry.json";
        File srcFile= new File(filePath);
        JSONParser parser= new JSONParser();
        JSONArray jarray= (JSONArray)parser.parse(new FileReader(srcFile));
        for (Object jsonObj : jarray)
        {
            JSONObject person= (JSONObject)jsonObj ;
            countrycode= (String) person.get("countrycode");
            System.out.println(countrycode);
            countryname= (String) person.get("countryname");
            NewEssentialpackprice= (String) person.get("NewEssentialpackprice");
            lightpackprice= (String) person.get("lightpackprice");
            Essentialpackprice= (String) person.get("Essentialpackprice");
            Premiumpackprice= (String) person.get("Premiumpackprice");
            FightSport= (String) person.get("FightSport");
            PaymentMethod= (String) person.get("PaymentMethod");
            Tvjaw= (String) person.get("Tvjaw");
            Total_Payment= (String) person.get("Total_Payment");
            PhoneName= (String) person.get("PhoneName");
        }
    }
}
