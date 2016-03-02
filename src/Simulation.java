import java.util.Scanner;

public class Simulation {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int row = scanner.nextInt();
		int column = scanner.nextInt();
		Character matrix[][] = new Character[row][column];
		String place = "";

		for (int i = 0; i < row; i++) {
			String str = scanner.next();
			for (int j = 0; j < column; j++) {
				matrix[i][j] = str.charAt(j);
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (matrix[i][j] == '@') {
					int nextRow = i + 1;
					int nextColumn = j + 1;
					place += nextRow;
					place += nextColumn;
				}
			}
		}

		int nextGenReq = scanner.nextInt();

		//System.out.println(place);

		Search position = new Search(place,row);
		position.setLocation();
		position.printResult();
		System.out.println("Location Set Go...");
		for (int i = 0; i < nextGenReq; i++) {
			position.test();
			position.printResult();
			System.out.println("Next..Gen"+(i+1));
		}	
		System.out.println("Final Living Organism are : "+position.livingorg());
		scanner.close();
	}
}