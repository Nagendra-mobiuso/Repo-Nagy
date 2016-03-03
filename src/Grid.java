public class Grid {

	public static final int LIFE = 1;
	public static final int NO_LIFE = 0;
	public int endSize;
	public int[][] game;

	public Grid(String places, int size) {
		this.endSize = size;
		this.game = new int[this.endSize + 2][this.endSize + 2];

		for (int i = 0; i < this.endSize + 2; i++) {
			for (int j = 0; j < this.endSize + 2; j++) {

				this.game[i][j] = NO_LIFE;
			}
		}
		setLocation(places);
	}

	private void setLocation(String places) {
		for (int i = 0; i < (places.length()); i = i + 2) {

			int x = Character.getNumericValue(places.charAt(i));
			int y = Character.getNumericValue(places.charAt(i + 1));
			this.game[x][y] = LIFE;
		}
	}

	public int lifePresent(int i, int j) {
		return this.game[i][j];
	}

	public int totalAdjacentLifePresentAroundCell(int h, int i) {
		int livinghumanNearby = 0;

		livinghumanNearby += lifePresent(h - 1, i);
		livinghumanNearby += lifePresent(h + 1, i);
		livinghumanNearby += lifePresent(h, i - 1);
		livinghumanNearby += lifePresent(h, i + 1);
		livinghumanNearby += lifePresent(h - 1, i - 1);
		livinghumanNearby += lifePresent(h + 1, i + 1);
		livinghumanNearby += lifePresent(h - 1, i + 1);
		livinghumanNearby += lifePresent(h + 1, i - 1);

		return livinghumanNearby;
	}

	public void born(int i, int j) {
		this.game[i][j] = LIFE;
	}

	public void die(int i, int j) {
		this.game[i][j] = NO_LIFE;
	}

	public int livingorg() {
		int totallivingorg = 0;
		for (int xindex = 1; xindex < this.endSize + 1; xindex++) {
			for (int yindex = 1; yindex < this.endSize + 1; yindex++) {
				if (this.game[xindex][yindex] == LIFE) {
					totallivingorg++;
				}
			}
		}
		
		return totallivingorg;
	}

}