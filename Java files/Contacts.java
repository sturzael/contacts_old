import java.util.HashMap; 

public class Contacts{
    public HashMap<String, Details> theContacts; 

    public Contacts(){
        theContacts = new HashMap<String, Details>();
    }

    /**
     * Method getNumber
     *Gets the number by asking for the name
     * @param name A parameter
     * @return The return value
     */
    public String getNumber(String name){
        return theContacts.get(name).getNumber();
    }

    /**
     * Method addContact
     *Adds a contact by asking the user for the details and then putting them into the map
     * @param name A parameter
     * @param number A parameter
     * @param picture A parameter
     */
    public void addContact(String name, String number, String picture){
        theContacts.put(name, new Details());
        theContacts.get(name).addDetails(number, picture);
    }

    /**
     * Method getPicture
     *Gets the picture by using the contacts name
     * @param name A parameter
     * @return The return value
     */
    public String getPicture(String name){
        return theContacts.get(name).getPicture();
    }
    /**
     * Method getAll
     * 
     *runs the get all numbers method to get all numbers
     * @param contact A parameter
     * @return The return value
     */
    public Print[] getAll(String contact){
        return theContacts.get(contact).getAllNumbers();
    }

   }
