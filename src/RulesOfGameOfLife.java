public class RulesOfGameOfLife implements NextGeneration {
	private int[][] adjacentNeighbour;
	private int size;

	public RulesOfGameOfLife(int size) {
		this.size = size;
		this.adjacentNeighbour = new int[size][size];
	}

	private void calculateAdjacentLifeCount(Grid grid) {
		for (int h = 0; h < this.size; h++) {
			for (int i = 0; i < this.size; i++) {
				this.adjacentNeighbour[h][i] = grid
						.countOrganismsAroundCellAt(h, i);
			}
		}
	}
	
	@Override
	public void nextGeneration(Grid gridLife) {
		calculateAdjacentLifeCount(gridLife);
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				if (gridLife.lifePresentAt(i, j) == 0) {
					if (this.adjacentNeighbour[i][j] == 3) {
						gridLife.bornAt(i, j);
					}
				} else if (this.adjacentNeighbour[i][j] < 2
						|| this.adjacentNeighbour[i][j] > 3) {
					gridLife.dieAt(i, j);
				}
			}
		}
	}
}
