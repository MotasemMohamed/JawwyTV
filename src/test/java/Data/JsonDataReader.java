package Data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonDataReader {
    public String countrycode,countryname,NewEssentialpackprice,OldEssentialpackprice,lightpackprice,Essentialpackprice,Premiumpackprice,
            TvJaw,FightSport,orange_company,Other_Company,PhoneName;
    public void JsonReader() throws IOException, ParseException {
        String filePath= System.getProperty("user.dir")+"/src/test/java/Data/UserData.json";
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
            OldEssentialpackprice= (String) person.get("OldEssentialpackprice");
            lightpackprice= (String) person.get("lightpackprice");
            Essentialpackprice= (String) person.get("Essentialpackprice");
            Premiumpackprice= (String) person.get("Premiumpackprice");
            FightSport= (String) person.get("FightSport");
            TvJaw= (String) person.get("TvJaw");
            orange_company= (String) person.get("orange_company");
            Other_Company= (String) person.get("Other_Company");
            PhoneName= (String) person.get("PhoneName");

        }
    }
}
