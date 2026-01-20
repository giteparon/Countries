//amir, 20.1.26, this controls the buttons of the geogame in order to study about countries, where are they and what languages do they speak and their capitals


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Main 
{

  // array of 10 Country objects
  private Country[] countryArray = new Country[10];  
  // index of current shown country
  private int index = 0;
  

  // GUI elements
  private JFrame jFrame = new JFrame("Countries");
  private ImageIcon img;
  private JLabel imageLabel;
  private JLabel outputLabel;
  private JTextArea userInput;
  
  public static void main(String[] args) {
    // Create the GUI
    Main gui = new Main();
    gui.loadCountries();
    gui.showCountry();
  }

  /* loadCountries() reads in the data from the countries-data.csv file and fills in the countryArray with data. You need to add the loop that reads in the country data into the array. */
  public void loadCountries() 
  {
    try{
      // Open the data file. Please note that the file structure we're working with requires the full file path as shown here unlike what you saw in runestone where the file name was sufficient.
      File file = new File("/workspaces/Countries/workspace/countries-data.csv");
      Scanner scan = new Scanner(file);
      boolean loop = true;
      for(int i = 0; i < 10; i++){
        String[] _temp = scan.nextLine().split(",");
        Country _coun = new Country(_temp[0], _temp[1], _temp[2], _temp[3]);
        countryArray[i] = _coun;
      
      }  
    }catch(IOException e){
      System.out.println("file issue");
    }
    
    
    //create a scanner and a loop to read from the file until you've read everything.
    // inside the loop you'll need to read in a line from the file and use "split" to break up the data into destinct parts.
    // create a new Country using your constructor with 4 arguments (each of the arguments is a different part of the line you've read in)
    // inside the loop, set countryArray[i] to the created Country object
    //after running this method your array should contain all 10 countries from inside the countries-data file.
     
    
  }

  /* showCountry() will show the image associated with the current country. It should get the country at index from the countryArray. It should use its get method to get its image file name and use the code below to put the image in the GUI.
  */
  public void showCountry() {
    // Get the country at index from countryArray
    Country _coun = countryArray[index];

    // Use its get method to get the its image file name and save it into imagefile variable below instead of worldmap.jpg.
    String imagefile = _coun.getImage();
    // Use the following code to create an new Image Icon and put it into the GUI
    img = new ImageIcon("/workspaces/Countries/workspace/"+imagefile);
    imageLabel.setIcon(img);
  }
  
  /* nextButton should increment index. If the index is greater than 9, reset it back to 0. Clear the outputLabel to empty string using setText, and call showCountry();*/
  public void nextButtonClick()
  {
    if(index > 9){
      index = 0;
    }
    else{
      index++;
    }
    outputLabel.setText("");
    showCountry();
  }
  
  /* reviewButton should get the country at index from the countryArray, call its toString() method and save the result, print it out with System.out.println and as an argument to outputLabel.setText( text to print out ); */
  public void reviewButtonClick()
  {
    Country _coun = countryArray[index];
    String _out = _coun.toString();
    System.out.println(_out);
    outputLabel.setText(_out);

  }

  /* quizButton should clear the outputLabel (outputLabel.setText to empty string), get the country at index from countryArray, print out a question about it like What country is this? and/or What's this country's capital?. Get the user's answer using scan.nextLine() and check if it is equal to the country's data using its get methods and print out correct or incorrect.
  */
  public void quizButtonClick()
  {
    int qn = (int)(Math.random() * 3);
    outputLabel.setText("");
    Scanner scan = new Scanner(System.in);
    Country _coun = countryArray[index];
    String ans = "";
    switch(qn){
      case 0:
        System.out.println("Whats the name of this country?");
        ans = _coun.getName();
        break;
      case 1:
        System.out.println("Whats the capital of this country?");
        ans = _coun.getCapital();
        break;
      case 2:
        System.out.println("What language do they speak in this country?");
        ans = _coun.getLang();
        break;
    }
    String ansPlayer = scan.nextLine();
    if(ans.equals(ansPlayer)){
      System.out.println("correct");
    }
    else{
      System.out.println("incorrect");
    }
  }




  /* You are not required to change anythign below here. You do so at your own risk! */
  /* The Main() constructor is finished and will construct the GUI */
public Main() {
    jFrame.setLayout(new FlowLayout());
    jFrame.setSize(500, 360);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // buttons at the top
        JButton reviewButton = new JButton("Review");
        JButton quizButton = new JButton("Quiz");
        JButton newButton = new JButton("Next");
        jFrame.add(reviewButton);
        jFrame.add(quizButton);
        jFrame.add(newButton);
        
        // create a new image icon
        img = new ImageIcon("worldmap.jpg");
        // create a label to display image
        imageLabel = new JLabel(img);
        // and one for output
        outputLabel = new JLabel();
        userInput = new JTextArea(1, 40);
        jFrame.add(imageLabel);
        jFrame.add(outputLabel);
        jFrame.add(userInput);
        jFrame.setVisible(true);
        // add event listener for button click
        reviewButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) 
    {
      reviewButtonClick();
    }
        });
    quizButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) 
    {
      quizButtonClick();
    }
    });
   
   newButton.addActionListener(new ActionListener()  {
    public void actionPerformed(ActionEvent e) 
    {
      nextButtonClick();
    }
   });
}
  

}
