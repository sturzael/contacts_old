import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;

public class gui{
    private Contacts theContacts; 
    public gui(){
        UI.initialise(); 
        theContacts = new Contacts();
        UI.println("Press A to add Contact, P to print all contacts, S to Get details or C to clear the screen");
        UI.setKeyListener((a)-> addContact());// if key is pressed add a contact
        UI.setKeyListener((s)-> showContact());//if button is pressed then show contact
        UI.setKeyListener((c)-> UI.clearPanes());//if key is pressed then clear
        UI.setKeyListener((p)-> printAll());//If key is pressed then print all
        UI.setMouseListener((action, x, y) -> doMouse(action, x, y));//if the mouse is clicked on graphics pane then clear
        UI.addButton("Add a Contact", ()-> doButton("+contact")); //Adds a contact and asks user for details
        UI.addButton("Get Details", ()-> doButton("+number")); //This adds a buttom and then gets details
        UI.addButton("Print All", ()-> doButton ("+print")); //This adds a button and then prints all
        UI.addButton("Clear", ()-> doButton ("clear")); //This adds a button to clear
        UI.addButton("Quit", UI::quit); //This adds a button to quit

    }

    /**
     * Method doMouse
     *if the graphics pane is clicked then clear the pane
     * @param action A parameter
     * @param x A parameter
     * @param y A parameter
     */
    private void doMouse(String action, double x, double y){
        UI.clearPanes();
    }

    /**
     * Method doButton
     *this tells the program what to do when certain buttons are pressed
     * @param button A parameter
     */
    public void doButton(String button){
        if (button.equals("+contact")){
            addContact();
        }
        else if (button.equals("+number")){
            showContact();
        }
        else if (button.equals("+print")){
            printAll();
        }
        else if (button.equals("clear")){
            UI.clearPanes();
        }
    }

    /**
     * Method addContact
     *Asks the user the contact details, then let the user know that the user has been added
     */
    public void addContact(){
        String name = UI.askString("Name?"); 
        String number = UI.askString("Phone Number?"); 
        String picture = UI.askString("Picture Name?");

        theContacts.addContact(name, number, picture); 
        UI.println(name + " is now one of your contacts");
    }
     public static void main(String[] args){
        new gui(); //creates a new GUI
    }

    /**
     * Method showContact
     *Show the contact number and name and then draw the image into the graphics pane
     */
    public void showContact(){
        String name = UI.askString("Name?");
        String number = theContacts.getNumber(name);
        String picture = theContacts.getPicture(name);
        UI.println(name + " : " + number);
        UI.drawImage(picture, 0, 0,400, 400);
    }

    /**
     * Method printAll
     * print all names and number.
     * Dont print images
     */
    private void printAll(){
        for (String key :  theContacts.theContacts.keySet()){
            UI.println(key);
            UI.println(theContacts.getNumber(key));
        }
    }

}

