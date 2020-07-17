package convertion;


public class RomanNumber {
		
	public static void main(String[] args) {
		
		System.out.println(romanToArabics("IX"));
	}
		
		
		public static Integer romanToArabics(String romano) {
		String roman[] = new String[]{"CM", "CD", "XC", "XL", "IX", "IV", "M", "D", "C", "L", "X", "V", "I"};
		int arabics[] = new int[]{900, 400, 90, 40, 9, 4, 1000, 500, 100, 50, 10, 5, 1};
		String valor = romano;
		for (int i = 0; i < roman.length; i++) {
			if (valor.contains(roman[i])) {
				valor = valor.replace(roman[i], arabics[i] + "#");
				
			}
		}
		
		String decimais[] = valor.split("#");
		Integer total = 0;
		for (String d : decimais) {
			if (d.toString() != null) {
				total += new Integer(d.toString());
			}
		}
		return total;
		}


		}

		//Para usar :gerar(valor decimal) retorna a String com valor em Romano;
		//romatoToDecimal(String romano) retorna o inteiro com o valor em romano convertido.


