package step4.iksoo.lottoManual;

import java.util.Objects;

public class LottoNo {
	private int number;
	
	LottoNo (int number) {
		if(number < RandomNumberCreator.START_NUMBER || number > RandomNumberCreator.END_NUMBER) {
			throw new IllegalArgumentException(RandomNumberCreator.START_NUMBER + "에서 " + RandomNumberCreator.END_NUMBER + "사이의 값을 입력해주세요");
		}
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LottoNo lottoNo = (LottoNo) o;
		return number == lottoNo.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
