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
					int nextRow = i;
					int nextColumn = j;
					place += nextRow;
					place += nextColumn;
				}
			}
		}
		int nextGenReq = scanner.nextInt();
		scanner.close();
		simulate(row, place, nextGenReq);
		
	}

	private static void simulate(int row, String place, int nextGenReq) {
		Grid grid = new Grid(place, row);
		NextGeneration rules = new RulesOfGameOfLife2(row);
		System.out.println("Location Set Go...");
		performGenerations(nextGenReq, grid, rules);
		System.out.println("Final Living Organism are : "
				+ grid.countLivingOrganisms());
	}

	private static void performGenerations(int nextGenReq, Grid grid,
			NextGeneration rules) {
		for (int i = 0; i < nextGenReq; i++) {
			rules.nextGeneration(grid);
			System.out.println("Next..Gen" + (i + 1));
		}
	}
}