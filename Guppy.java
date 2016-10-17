import java.lang.reflect.Field;
/**
 * @title Assignment1_A01013054
 * 
 * @author Krzysztof Szczurowski 
 * @version 1.0
 * @date 09/21/2016 -> no such tag in javaDoc available
 * @since 09/21/2016
 * @see https://learn.bcit.ca/d2l/le/content/331960/viewContent/2063408/View
 */
public class Guppy
{
    public static final int YOUNG_FISH = 10;
    public static final int MATURE_FISH = 30;
    public static final int MAXIMUM_AGE_IN_WEEKS = 50;
    public static final double MINIMUM_WATER_VOLUME_ML = 250.0;
    public static final String DEFAULT_GENUS = "Poecilia"; 
    public static final String DEFAULT_SPECIES = "reticulata";
    public static final double DEFAULT_HEALTH_COEFFICIENT = 0.5;
    public static final double MINIMUM_HEALTH_COEFFICIENT = 0.0;
    public static final double MAXIMUM_HEALTH_COEFFICIENT = 1.5;
    
    private static int numberOfGuppiesBorn = 0;
    
    private String genus;
    private String species;
    private int ageInWeeks;
    private boolean isFemale;
    private int generationNumber;
    private boolean isAlive;
    private double healthCoefficient;
    private int identificationNumber;
    
    //Constructors
    /**
     * Parameter-less constructor setting up instance variables to its default values
     * When this constructor is used identification number is set to a total nmber of Guppies born
     */
    public Guppy()
    {
        this.ageInWeeks = 0;
        this.generationNumber = 0;
        this.genus = DEFAULT_GENUS;
        this.species = DEFAULT_SPECIES;
        this.isFemale = true;
        this.isAlive = true;
        this.healthCoefficient = DEFAULT_HEALTH_COEFFICIENT;
        
        this.identificationNumber = ++numberOfGuppiesBorn;
    }
    
    /**
     * Parameterized constructor which sets avaialable instance variables
     * 
     * @param genus as String;
     * @param species as String;
     * @param ageInWeeks as int;
     * @param isFemale as boolean;
     * @param generationNumber as int;
     * @param isAlive as boolean;
     * @param healthCoafficient as double;
     * @param identificationNumber as int;
     * 
     * identificationNuber is set by incremented value of nuberOfGruppiesBorn, static variable of class Gruppy
     */
    public Guppy(String newGenus, String newSpecies, int newAgeInWeeks, boolean newIsFemale, int newGenerationNumber, double newHealthCoefficient)
    {
        if(newGenus.equals("") || newGenus == null)
        {
            this.genus = DEFAULT_GENUS;
        } 
        else
        {
            this.genus = newGenus.substring(0, 1).toUpperCase() + newGenus.substring(1);
        }
        
        if(newSpecies == null || newSpecies.equals(""))
        {
            this.species = DEFAULT_SPECIES;
        }
        else
        {
            this.species = newSpecies.toLowerCase();
        }
        
        if(newAgeInWeeks < 0 || newAgeInWeeks >= MAXIMUM_AGE_IN_WEEKS)
        {
            this.ageInWeeks = 0;
        }
        else
        {
            this.ageInWeeks = newAgeInWeeks;
        }
        
        if(newHealthCoefficient < MINIMUM_HEALTH_COEFFICIENT || newHealthCoefficient > MAXIMUM_HEALTH_COEFFICIENT)
        {
            this.healthCoefficient = DEFAULT_HEALTH_COEFFICIENT;
        }
        else
        {
            this.healthCoefficient = newHealthCoefficient;
        }
        
        this.generationNumber = (newGenerationNumber < 0 ? 0 : newGenerationNumber);
        
        this.isFemale = newIsFemale;
        this.isAlive = true;
        
        this.identificationNumber = ++numberOfGuppiesBorn;
    }
    
    //Accessors and Mutators
    /**
     * Gets the value of genus
     * @retuns genus as String
     */
    public String getGenus()
    {
        return this.genus;
    }
    
    /**
     * 
     */
    public void setGenus(String value)
    {
        if(value.equals("") || value == null)
        {
            this.genus = DEFAULT_GENUS;
        }
        else
        {
            this.genus = value.substring(0,1).toUpperCase() + value.substring(1);
        }
    }
    
    /**
     * 
     */
    public String getSpecies()
    {
        return this.species;
    }
    
    /**
     * 
     */
    public void setSpecies(String value)
    {
        if(value.equals("") || value == null)
        {
            this.species = DEFAULT_SPECIES;
        }
        else
        {
            this.species = value.toLowerCase();
        }
    }
    
    /**
     * 
     * 
     */
    public int getAgeInWeeks()
    {
        return this.ageInWeeks;
    }
    
    /**
     * 
     */
    public void setAgeInWeeks(int value)
    {
        if(value < 0 || value > MAXIMUM_AGE_IN_WEEKS)
        {
            this.ageInWeeks = MAXIMUM_AGE_IN_WEEKS;
        }
        else
        {
            this.ageInWeeks = value;
        }
        
    }
    
    /**
     * 
     * 
     */
    public boolean getIsFemale()
    {
        return this.isFemale;
    }
    
    /**
     * 
     * 
     */
    public void setIsFemale(boolean value)
    {
        this.isFemale = value;
    }
    
    /**
     * 
     * 
     */
    public int getGenerationNumber()
    {
        return this.generationNumber;
    }
    
    /**
     * 
     * 
     */
    public void setGenerationNumber(int value)
    {
        if(value < 0)
        {
            this.generationNumber = 0;
        }
        else
        {
            this.generationNumber = value;
        }
    }
    
    /**
     * 
     * 
     */
    public boolean isAlive()
    {
        return this.isAlive;
    }
    
    /**
     * 
     * 
     */
    public void setIsAlive(boolean value)
    {
        this.isAlive = value;
    }
    
    /**
     * 
     * 
     */
    public double getHealthCoefficient()
    {
        return this.healthCoefficient;
    }
    
    public void setHealthCoaficient(double value)
    {
        /*
         * The mutator forhealthCoefficientmust ignore values that would 
         * cause thehealthCoefficientvariable to exceed its bounds
         * 
         */
        if(value < MINIMUM_HEALTH_COEFFICIENT || value > MAXIMUM_HEALTH_COEFFICIENT)
        {
            this.healthCoefficient = MAXIMUM_HEALTH_COEFFICIENT;
        }
        else
        {
            this.healthCoefficient = value;
        }
    }
   
    //Only getter => NO SETTER
    /**
     * 
     * 
     */
    public int getIdentificationNumber()
    {
        return this.identificationNumber;
    }
    
    /**
     * 
     * 
     */
    public static int getNumberOfGuppiesBorn()
    {
        return numberOfGuppiesBorn;
    }
    
    //Public Methods 
    /**
     * 
     */
    public void incrementAge()
    {
        this.ageInWeeks++;
        if(this.ageInWeeks == MAXIMUM_AGE_IN_WEEKS)
        {
            this.isAlive = false;
        }
    }
    
    
    /**
     * public method getValuemNeeded()
     * Takes no input parameters
     * @return required Volume as double
     */
    public double getVolumeNeeded()
    {
        double result = 0.0;
        if(this.ageInWeeks < 10)
        {
            return MINIMUM_WATER_VOLUME_ML;
        } else if (this.ageInWeeks >= 10 && this.ageInWeeks <= 30)
        {
            return (MINIMUM_WATER_VOLUME_ML * ageInWeeks) / YOUNG_FISH;
        } else if(this.ageInWeeks > 30 && this.ageInWeeks <= 50)
        {
            return MINIMUM_WATER_VOLUME_ML* 1.5;
        }
        else if(this.ageInWeeks > 50)
        {
            return result;
        }
        return result;
    }
    
    
    /**
     * public method changeHealthCoefficient;
     * It does one parameter:
     * @param delta as doubl
     * HealthCoefficient changes depending on argument passed
     * if health coefficient falls outsite of lower and upper bound MAX value will be assigned
     */
    public void changeHealthCoefficient(double delta)
    {
        this.healthCoefficient = this.healthCoefficient + delta;
        if(this.healthCoefficient <= MINIMUM_HEALTH_COEFFICIENT)
        {
            this.healthCoefficient = 0.0;
            this.isAlive = false;
        } 
        else if(this.healthCoefficient > MAXIMUM_HEALTH_COEFFICIENT)
        {
            this.healthCoefficient = MAXIMUM_HEALTH_COEFFICIENT;
        }
    }
    
    
    /**
     * Public method overrides default implementation.
     * It does not take any input parametes and returns formated string
     * containing all private vaiables, comma separated, and their current state
     * @return required formated string as String;
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        //get list of instance variables
        for(Field f : getClass().getDeclaredFields())
        {
           try
           {
                sb.append(f.getName()+"=");
                sb.append(f.get(this));
                sb.append(",");
           }
          catch(IllegalAccessException ex)
          {
              System.err.println("IllegalAccessException: " + ex.getMessage());
          }
        }
        
        //remove last coma from the string
        sb.setLength(sb.length()-1);
        sb.append("]");
        System.out.print(sb.toString());
        return sb.toString();
    }
    
    /**
     * 
     * 
     */
    public String toString2()
    {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        sb2.append("genus=" + genus);
        sb2.append(",");
        sb2.append("species=" + species);
        sb2.append(",");
        sb2.append("ageInWeeks=" + ageInWeeks);
        sb2.append(",");
        sb2.append("isFemale=" + isFemale);
        sb2.append(",");
        sb2.append("generationNumber=" + generationNumber);
        sb2.append(",");
        sb2.append("isAlive=" + isAlive);    
        sb2.append(",");
        sb2.append("healthCoefficient=" + healthCoefficient);    
        sb2.append(",");
        sb2.append("identificationNumber=" + identificationNumber);    
        sb2.append("]");
        System.out.print(sb2.toString());
        return sb2.toString();
    }
    
    /**
     * Standard public method available outside of the class
     * It does not take any input parameters and returns vString with the name of the class which created this object
     * @return returns the name of the class created this object as String
     */
    public String whatsMyName()
    {
        return getClass().getName();
    }
}