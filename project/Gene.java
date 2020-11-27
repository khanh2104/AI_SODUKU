package project;

import java.awt.List;
import java.util.ArrayList;
import java.util.Random;

public class Gene {
	int[] squares;
	
	public Gene() {
		super();
		squares = new int[9];
	}
	public void setInitial() {
//		ArrayList[] mutation = this.square;
		Random rand = new Random();
		ArrayList<Integer> container = new ArrayList<Integer>();
		
		for (int i = 0; i < squares.length; i++) {
			int value = rand.nextInt(squares.length)+1;
			while(container.contains(value) ) {
				
				value = rand.nextInt(squares.length)+1;
				
			}
			squares[i] = value;
			container.add(value);
			
		}
		
		
	}  
	public int[] getSquares() {
		return squares;
	}
	public void setSquares(int[] squares) {
		this.squares = squares;
	}
	public String toString () {
		String result = "";
		for (int i : squares) {
			result += i + "\t";
		}
		return result;
	}

	public static void main(String[] args) {
		Gene gene = new Gene();
		gene.setInitial();
		for (int s : gene.squares) {
			System.out.print(s+"\t");
		}
	}
	 }
