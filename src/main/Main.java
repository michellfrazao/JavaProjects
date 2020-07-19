package main;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import controller.MainFunctions;


public class Main 
{
	
	public final static String SINAL_ATRIBUICAO = " é ";
		
	public static void main(String[] args) throws Exception 
	{
		MainFunctions convertNumber = new MainFunctions();		
		Scanner input = new Scanner(new File("src/notebook/trades.txt"));

		ArrayList<String> lines  = new ArrayList<>();
		while(input.hasNextLine()) 
		{
			lines.add(input.nextLine());			
		}
		
		for(int i = 0; i < lines.size(); i++)
		{			
				if(lines.get(i).contains(SINAL_ATRIBUICAO)) 
				{
					String[] splitLineMap = lines.get(i).split(SINAL_ATRIBUICAO);
					convertNumber.setAlienMap(splitLineMap[0], splitLineMap[1]);
					
				}
				else if(lines.get(i).contains(" valem ") ) 
				{
					convertNumber.populateMetalCreditsMap(lines.get(i));
					
				}else if (lines.get(i).contains("quantos") || lines.get(i).contains("quanto")) 
				{
					
					System.out.println(convertNumber.creditsQuestionsResponse(lines.get(i)));
				}
		}
		
		input.close();

	}
}
