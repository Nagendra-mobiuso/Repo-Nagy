public class Grid {

	public static final int LIFE = 1;
	public static final int NO_LIFE = 0;
	private int size;
	private int[][] board;

	public Grid(String places, int size) {
		this.size = size;
		this.board = new int[this.size][this.size];

		for (int i = 0; i < this.size ; i++) {
			for (int j = 0; j < this.size ; j++) {

				this.board[i][j] = NO_LIFE;
			}
		}
		setLocation(places);
	}

	private void setLocation(String places) {
		for (int i = 0; i < (places.length()); i = i + 2) {

			int posX = Character.getNumericValue(places.charAt(i));
			int posY = Character.getNumericValue(places.charAt(i + 1));
			this.board[posX][posY] = LIFE;
		}
	}

	public int lifePresentAt(int i, int j) {
		try {
			return this.board[i][j];
		} catch (Exception e) {
			return NO_LIFE;
		}
	}

	public int countOrganismsAroundCellAt(int x, int y) {
		int livingOrganismNearby = 0;

		livingOrganismNearby += lifePresentAt(x - 1, y);
		livingOrganismNearby += lifePresentAt(x + 1, y);
		livingOrganismNearby += lifePresentAt(x, y - 1);
		livingOrganismNearby += lifePresentAt(x, y + 1);
		livingOrganismNearby += lifePresentAt(x - 1, y - 1);
		livingOrganismNearby += lifePresentAt(x + 1, y + 1);
		livingOrganismNearby += lifePresentAt(x - 1, y + 1);
		livingOrganismNearby += lifePresentAt(x + 1, y - 1);

		return livingOrganismNearby;
	}

	public void bornAt(int x, int y) {
		try {
			this.board[x][y] = LIFE;
		} catch (Exception e) {
			
		}
	}

	public void dieAt(int x, int y) {
		try {
			this.board[x][y] = NO_LIFE;
		} catch (Exception e) {
			
		}
	}

	public int countLivingOrganisms() {
		int count = 0;
		for (int xindex = 0; xindex < this.size; xindex++) {
			for (int yindex = 0; yindex < this.size; yindex++) {
				if (this.board[xindex][yindex] == LIFE) {
					count++;
				}
			}
		}
		
		return count;
	}

}