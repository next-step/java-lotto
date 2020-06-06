package study2.domain;

public class Lotto {

	static final int Max_Lotto_number = 45;
	static final int Min_Lotto_number = 1;
	private Long number;
	
	public Lotto(Long number) {
		if (isWrongNumber(number)) {
			throw new IllegalArgumentException("로또 번호는 1~45까지 입니다.");
		}
		this.number = number;
	}

	private boolean isWrongNumber(Long number) {
		return number < Min_Lotto_number || number > Max_Lotto_number;
	}
	
	public Long getNumber() {
		return number;
	}
	
}
