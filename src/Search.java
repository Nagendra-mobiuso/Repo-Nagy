
public class Search {

	String places ;
	String [][] game = new String[20][20];
	int [] x ;//= new int[5];
	int [] y ;//= new int[5];

	public Search(String places) {

		this.places = places;
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
		for(int h = 1; h < 19; h++) {			
			for (int i = 1; i < 19; i++) {
				
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
				System.out.println(livinghumanNearby+"====="+h+" x "+i+" y ");
				

			}



		}
		return 1;
	}

	public int livingorg() {

		int livinghumanNearby=0;

		for (int i = 0; i < x.length; i++) {
			livinghumanNearby = 0;
			for (int j = 0; j < 3; j++) {
				//horizontal
				if( game[x[i]-1+j][y[i]] == "0") {
					if(( x[i]-1+j ) != x[i]) {
						livinghumanNearby++;
					}
				}
				//vertical
				if( game[x[i]][y[i]-1+j] == "0") {
					if(( y[i]-1+j ) != y[i]) {
						livinghumanNearby++;
					}
				}
				//left diagonal
				if( game[x[i]-1+j][y[i]-1+j] == "0") {
					if(( y[i]-1+j ) != y[i]) {
						livinghumanNearby++;
					}
				}
				//right diagonal
				if( game[x[i]-j+1][y[i]-1+j] == "0") {
					if(( y[i]-1+j ) != y[i]) {
						livinghumanNearby++;
					}
				}

			}
			System.out.println(livinghumanNearby+"=====");

		}



		return livinghumanNearby;
	}

	public void printResult() {
		places = "";
		for (int xindex = 0; xindex < 20; xindex++) {
			for (int yindex = 0; yindex < 20; yindex++) {


				System.out.print(game[xindex][yindex]);

				if(game[xindex][yindex] == "0") {
					places += xindex+""+yindex;
				}
			}
			System.out.println();
		}
		System.out.println(places);

	}

	public static void main(String[] args) {
		Search s = new Search("1223313233");
		s.setLocation();
		int ans = s.livingorg();



	}



}
