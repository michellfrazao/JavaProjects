package controller;
import java.util.Arrays;
import java.util.HashMap;

import utils.RomanToArabicNumber;

public class  MainFunctions 
{
	
	static HashMap<String,String> alienToRomanDictionary = new HashMap<>();
	private RomanToArabicNumber romanNumber = new RomanToArabicNumber();
	private HashMap<String, Integer> metalUnitMap = new HashMap<>();
	
	public void setAlienMap(String key, String value) 
	{
		alienToRomanDictionary.put(key, value.toUpperCase());
	}
		
    public void populateMetalCreditsMap(String line) throws Exception
    {
    	Integer resultRomanNumber = 0;
    	Integer resultCredits = 0;
    	Integer credits = 0;
    	String auxCredits = "";
    	String metalUnit = "";

    	if(line.contains(" valem ")) 
    	{	
    		String replaceString = line.replace("créditos", "");
	    	String[] convertAlienRoman = replaceString.split(" valem ");
	    	String[] arrayStringAlien = convertAlienRoman[0].split(" ");
	    	
	    	resultRomanNumber = convertAlienToArabics(arrayStringAlien);
	    	for(String metal: arrayStringAlien) 
	    	{
	    		if(!alienToRomanDictionary.containsKey(metal)) 
	    		{
	    			metalUnit = metal.trim();
	    		}
	    	}
	    	auxCredits = convertAlienRoman[1].trim();
	    	credits = Integer.parseInt(auxCredits);
	    	
	    	resultCredits = credits/resultRomanNumber;
	    	metalUnitMap.put(metalUnit,resultCredits);
    	}
    }     
    
    public String creditsQuestionsResponse(String line) throws Exception 
    {
    	Integer resultInteger = 0;
    	Integer creditsValue = 0;
    	String responseComplement = "";
    	String alienMetalWords = "";
    	String replaceQuestion = line.replace("?", "");
    	String response = "";
    	
    	if(line.contains("são")) 
    	{	
			String[] arrayQuestionsCredits = replaceQuestion.split("são "); 
			String[] alienNumberQuestions = arrayQuestionsCredits[1].split(" ");
			alienMetalWords = Arrays.toString(alienNumberQuestions).replace("[", "").replace("]", "").replace(",", "");
			alienMetalWords =  alienMetalWords.concat(" custa");
			responseComplement = "créditos";
			resultInteger = convertAlienToArabics(alienNumberQuestions);
			creditsValue = calculateMetalCredits(alienNumberQuestions, resultInteger);
			if(resultInteger < 0 || creditsValue < 0) 
			{
				response = String.format("Fomato de número Inválido!");
			}else		  
				response = String.format("%s %d %s",alienMetalWords, creditsValue, responseComplement);
    	}
    	if(line.contains("vale"))
    	{
    		String[] arrayQuestionsCredits = replaceQuestion.split(" vale ");
    		String[] alienNumberQuestions = arrayQuestionsCredits[1].split(" ");
    		alienMetalWords = Arrays.toString(alienNumberQuestions).replace("[", "").replace("]", "").replace(",", "");
    		alienMetalWords =  alienMetalWords.concat(" vale ");
    		resultInteger = convertAlienToArabics(alienNumberQuestions);
    		if(resultInteger < 0) 
    		{
    			response = String.format("Fomato de número Inválido!");
    		}else
    			response = String.format("%s %d",alienMetalWords, resultInteger);
    	}
    	 if(resultInteger == 0) 
    	 { 
    		 response = String.format("Não faço ideia do que é isto!");
    	 }else if(resultInteger < 0) 
    	 {
    		 response = String.format("Fomato de número Inválido!");
    	 }
    	 
		 return response;
    }
    
    
    private Integer convertAlienToArabics(String[] arrayOfWords) throws Exception 
    {
    	String concatRoman = "";
    	Integer integerNumber = 0;
    	 for(int i = 0; i < arrayOfWords.length; i++) 
		 {
			 if(alienToRomanDictionary.containsKey(arrayOfWords[i])) 
			 { 
				 arrayOfWords[i]= alienToRomanDictionary.get(arrayOfWords[i]);
				 concatRoman += arrayOfWords[i];
				 integerNumber = RomanToArabicNumber.romanToArabics(concatRoman);
			 } 
		 }
    	
    	return integerNumber;
    }
    
    private Integer calculateMetalCredits(String[] array, Integer resultInteger) 
    {
    	Integer unit = 0;
    	for(String wordQuestion: array) 
    	{
    		if(metalUnitMap.containsKey(wordQuestion)) 
    		{
    			unit = metalUnitMap.get(wordQuestion);
    		}
  
    	}
		return unit*resultInteger;
    }
    
 }
	
