package project;

import java.util.Arrays;

public class Individual {
	Gene[] genes = new Gene[9];
	
	public Individual() {
		super();
		for (int i = 0; i < genes.length; i++) {
			genes[i] = new Gene();
		}
	}
//	public int[][] convertToArray() {
//		int[][] result = new int[9][9];
//		for (int i = 0; i < genes.length; i++) {
//			for (int j = 0; j < genes.length; j++) {
//				result[i][j] = genes[i].getSquares()[j];
//			}
//		}
//		return result;
//	}
//	public void toStringArray(int[][] arr) {
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr.length; j++) {
//				System.out.print(arr[i][j] +"\t");
//			}
//			System.out.println();
//		}
//	}
	public void setInitial() {
		for (Gene gene : genes) {
			gene.setInitial();
		}
	}
	public Gene[] getGenes() {
		return genes;
	}
	public void setGenes(Gene[] genes) {
		this.genes = genes;
	}
	public int checkColumn(int col) {
		int col_index = col;
		int result = 0;
		int[] one_col = new int[9];
		for (int i = 0; i < one_col.length; i++) {	
			for (int j = i+1; j < one_col.length; j++) {
				if (this.genes[i].getSquares()[col_index] == this.genes[j].getSquares()[col_index]) {
					result++;
				}
			}
		}
		return result;
	}
	
	public int checkSquares() {
		int result = 0;
		int[] col = new int[3];
		int[] row = new int[3];
		col[0] = 0;
		col[1] = 1;
		col[2] = 2;
		row[0] = 0;
		row[1] = 1;
		row[2] = 2;
		return count_square(col,row) + checkSquares();
			
	}
	
	private int count_square(int[] col, int[] row) {
		int[] arr = new int[9];
		int index =0;
		int result = 0;
		for (int i = row[0]; i <= row[2]; i++) {
			for (int j = col[0]; j <= col[2]; j++) {
				 arr[index] = genes[i].getSquares()[j];
				 index++;
			}
		}
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					result++;
				}
			}
		}
		return result;
	}
	public int heuristic() {
		int result = 0;
		for (int i = 0; i < genes.length; i++) {
			result += checkColumn(i);
		}
		
		return result;
	}
	public static void main(String[] args) {
		Individual individual = new Individual();
		individual.setInitial();
//		int[][] state = individual.convertToArray();
//		individual.toStringArray(state);
		for (Gene g : individual.getGenes()) {
			for (int i = 0; i < 9; i++) {
				System.out.print(g.getSquares()[i]+"\t");
			}
			System.out.println();
		}
		System.out.println(individual.heuristic());
		System.out.println(individual.checkSquares());
	}
	
}
