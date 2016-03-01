
public class Search {

	String places ;
	String [][] game = new String[20][20];

	public Search(String places) {

		this.places = places;
		
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {


				game[i][j] =".";
			}
	
		}

		
for ( int i = 0; i < (places.length()); i = i + 2) {

			
			int x = Character.getNumericValue(places.charAt(i));
			int y = Character.getNumericValue(places.charAt(i+1));
			
			game[x][y] = "0";

		}
	


	}

	public void printResult() {
		
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {


				System.out.print(game[i][j]);
			}
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		Search s = new Search("1223313233");
		s.printResult();
	}
	
	

}
