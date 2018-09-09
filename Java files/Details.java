import java.util.HashMap;

public class Details{
    private HashMap<String, String> ContactDetails;

    public Details(){
        ContactDetails = new HashMap<String, String>();
    }


    /**
     * Method getPicture
     *Gets the picture by using a keyset
     * @return The return value
     */
    public String getPicture(){
        String picture = "";

        for (String key : ContactDetails.keySet()){
            picture = ContactDetails.get(key);
        }

        return picture;
    }

    /**
     * Method addDetails
     *adds the contacts details
     * @param number A parameter
     * @param picture A parameter
     */
    public void addDetails(String number, String picture){
        ContactDetails.put(number, picture);
    }

    /**
     * Method getNumber
     *Gets the number
     * @return The return value
     */
    public String getNumber(){
        String number = "";

        for (String key : ContactDetails.keySet()){
            number = key;
        }

        return number;
    }
    /**
     * Method getAllNumbers
     *gets all numbers
     * @return The return value
     */
    public Print[] getAllNumbers(){
        Print[] prints = new Print[ContactDetails.size()];
        int count = 0;
        for (String key : ContactDetails.keySet()) {
            prints[count] = new Print(key, ContactDetails.get(key));
            count = count + 1;
        }
        return prints;
    }

   }
