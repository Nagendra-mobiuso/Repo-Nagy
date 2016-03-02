
public class Search {

	String places ;
	int endSize;
	String [][] game = new String[20][20];
	int [][] adjacentNeighbour = new int [20][20];
	int [] x ;//= new int[5];
	int [] y ;//= new int[5];

	public Search(String places, int size) {

		this.places = places;
		endSize = size;
		x = new int [places.length()/2];
		y = new int [places.length()/2];
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {


				game[i][j] =".";
			}

		}

	}
	public void setLocation() {
		int index = 0;

		for ( int i = 0; i < (places.length()); i = i + 2) {


			x[index] = Character.getNumericValue(places.charAt(i));
			y[index] = Character.getNumericValue(places.charAt(i+1));

			game[x[index]][y[index]] = "0";

			index++;
		}

	}

	public int test() {

		int livinghumanNearby=0;
		for(int h = 1; h < 18; h++) {			
			for (int i = 1; i < 18; i++) {

				livinghumanNearby = 0;
				for (int j = 0; j < 3; j++) {

					//horizontal
					if( game[h-1+j][i] == "0") {
						if(( h-1+j ) != h) {
							livinghumanNearby++;
						}
					}
					//vertical
					if( game[h][i-1+j] == "0") {
						if(( i-1+j ) != i) {
							livinghumanNearby++;
						}
					}
					//left diagonal
					if( game[h-1+j][i-1+j] == "0") {
						if(( i-1+j ) != i) {
							livinghumanNearby++;
						}
					}
					//right diagonal
					if( game[h-j+1][i-1+j] == "0") {
						if(( i-1+j ) != i) {
							livinghumanNearby++;
						}
					}

				}
				adjacentNeighbour[h][i] = livinghumanNearby;



			}



		}
		nextgen();
		clean();
		return 1;
	}

	private void nextgen() {
		for (int i = 0; i < 18; i++) {
			for (int j = 0; j < 18; j++) {

				if(game[i][j] != "0") {
					if(adjacentNeighbour[i][j] == 3) {
						game[i][j] = "0";
					}
				} else if(adjacentNeighbour[i][j] < 2 || adjacentNeighbour[i][j] > 3 ) {
					game[i][j] = ".";
				}
			}

		}


	}

	public int livingorg() {

		int totallivingorg = 0;
		for (int xindex = 0; xindex < 20; xindex++) {
			for (int yindex = 0; yindex < 20; yindex++) {
				if ( game[xindex][yindex] == "0" ) {
					totallivingorg++;
				}

			}
		}		
		return totallivingorg;
	}
	public void clean() {
		
		for (int xindex = 0; xindex < 5; xindex++) {
			for (int yindex = 0; yindex < 5; yindex++) {
				if(xindex < 1 || xindex >endSize) {
					game[xindex][yindex] = ".";
				}
				
				if(yindex < 1 || yindex >endSize) {
					game[xindex][yindex] = ".";
				}
				
			}
		}
	}

	public void printResult() {
		places = "";
		for (int xindex = 0; xindex < 20; xindex++) {
			for (int yindex = 0; yindex < 20; yindex++) {


				//System.out.print(game[xindex][yindex]);

				if(game[xindex][yindex] == "0") {
					places += xindex+""+yindex;
				}
			}
			//System.out.println();
		}


	}

}
