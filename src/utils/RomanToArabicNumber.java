package utils;

public class RomanToArabicNumber {
	
	 static String roman[] = new String[]{"CM", "CD", "XC", "XL", "IX", "IV", "M","D", "C", "L", "X", "V", "I"}; 
	 static int arabics[] = new int[]{900, 400, 90,40, 9, 4, 1000, 500, 100, 50, 10, 5, 1};

		public static Integer romanToArabics(String romano) throws Exception{
		String valor = romano;
		for (int i = 0; i < roman.length; i++) 
		{
			if (valor.contains(roman[i])) 
			{
				valor = valor.replace(roman[i], arabics[i] + "#");
			}
		}
		//
		String decimais[] = valor.split("#");
		Integer[] arabicsNumber = new Integer[decimais.length];
		Integer total = 0;
		
		for(int i = 0; i < decimais.length; i++) {
			arabicsNumber[i] = Integer.parseInt(decimais[i]);
		}
		//verifica se é um formato de número valido, se não for, é retornado -1 para o número
		for (int i = 0; i < arabicsNumber.length; i++) {
			if (arabicsNumber[i] != null) 
			{
					if(i+1 < arabicsNumber.length)
					{ 
						if(arabicsNumber[i] < arabicsNumber[i+1])
						{
							total = -1;
						}else
						{
							total += arabicsNumber[i];
						}
					}
					 if(i+1 == arabicsNumber.length && arabicsNumber.length != 1)
					 { 
						 if(arabicsNumber[i] <= arabicsNumber[i-1]) 
						 {
							 total += arabicsNumber[i];
						 }else{
							 total = -1;
						 }
					 }else if (i+1 == arabicsNumber.length && arabicsNumber.length == 1)
						 total += arabicsNumber[i];
					 
				}
		}
		return total;
		}


 }	
