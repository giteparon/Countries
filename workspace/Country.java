public class Country
{
  // add private instance variables for the name, capital, language, and image file.
  private final String name;
  private final String capital;
  private final String lang;
  private final File image;
  // add constructors
  public Country(String name, String capital, String lang, File image){
    this.name = name;
    this.capital = capital;
    this.langauge = lang;
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
    return language;
  }
  public File getImage(){
    return image;
  }
  // Write a toString() method that returns a concatenated String of 3 of the instance variables in a sentence like "..'s capital is .. and its primary language is ..."
 


  
}