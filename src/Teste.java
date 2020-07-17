import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;
public class Teste {
	public static void main(String[] args) throws Exception {
		String nome = "src/notebook/trades.txt";
		Scanner in = new Scanner(new File(nome));
		
		List<String> lines  = new ArrayList<>();
		while(in.hasNextLine()) {
			
			lines.add(in.nextLine());
		
		}
		
		System.out.println(lines);
		
		Iterator<String> it = lines.iterator();
		while(it.hasNext()) {
			
			System.out.println(it.next());
		}
		
		in.close();

	}
}


 