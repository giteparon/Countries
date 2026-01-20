//amir, 20.1.26, this controls the country class of  the geogame in order to study about countries, where are they and what languages do they speak and their capitals


public class Country
{
  // add private instance variables for the name, capital, language, and image file.
  private final String name;
  private final String capital;
  private final String lang;
  private final String image;
  // add constructors
  public Country(String name, String capital, String lang, String image){
    this.name = name;
    this.capital = capital;
    this.lang = lang;
    this.image = image;

  }
  // Write accessor/get methods for each instance variable that returns it.
  public String getName(){
    return name;
  }
  public String getCapital(){
    return capital;
  }
  public String getLang(){
    return lang;
  }
  public String getImage(){
    return image;
  }
  // Write a toString() method that returns a concatenated String of 3 of the instance variables in a sentence like "..'s capital is .. and its primary language is ..."
  public String toString(){
    return name + "'s capital is " + capital + " and its primary language is " + lang;
  }


  
}