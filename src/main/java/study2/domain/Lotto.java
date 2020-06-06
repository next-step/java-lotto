package study2.domain;

import java.util.List;

public class Lotto {

	static final int Max_Lotto_number = 45;
	static final int Min_Lotto_number = 1;
	private int number;
	
	public Lotto() {
		
	}
	
	public Lotto(int number) {
		isWrongNumberList(number);
		this.number = number;
	}

	public Lotto(List<Integer> number) {
		for(int i : number) {
			isWrongNumberList(i);
		}
	}

	private void isWrongNumberList(int i) {
		if( isWrongNumber(i)) {
			throw new IllegalArgumentException("로또 번호는 1~45까지 입니다.");
		}
	}

	private boolean isWrongNumber(int number) {
		return number < Min_Lotto_number || number > Max_Lotto_number;
	}
	
	public int getNumber() {
		return number;
	}
		
	
}
