public class RulesOfGameOfLife {
	public int[][] adjacentNeighbour;
	int endSize;

	public RulesOfGameOfLife(int endSize) {
		this.endSize = endSize;
		this.adjacentNeighbour = new int[endSize + 2][endSize + 2];
	}

	public void calculateAdjacentLifeCount(Grid grid) {
		for (int h = 1; h <= this.endSize; h++) {
			for (int i = 1; i <= this.endSize; i++) {
				this.adjacentNeighbour[h][i] = grid
						.totalAdjacentLifePresentAroundCell(h, i);
			}
		}
	}

	public void nextgen(Grid gridLife) {
		calculateAdjacentLifeCount(gridLife);
		for (int i = 1; i < this.endSize + 1; i++) {
			for (int j = 1; j < this.endSize + 1; j++) {
				if (gridLife.lifePresent(i, j) == 0) {
					if (this.adjacentNeighbour[i][j] == 3) {
						gridLife.born(i, j);
					}
				} else if (this.adjacentNeighbour[i][j] < 2
						|| this.adjacentNeighbour[i][j] > 3) {
					gridLife.die(i, j);
				}
			}
		}
	}
}
