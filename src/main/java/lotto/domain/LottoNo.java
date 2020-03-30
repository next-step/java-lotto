package lotto.domain;

import java.util.Objects;

class LottoNo {
	public static final int LOWEST_NUMBER = 1;
	public static final int HIGHEST_NUMBER = 45;

	private final int lottoNo;

	static LottoNo getInstance(int lottoNo){
		return new LottoNo(lottoNo);
	}

	private LottoNo(int lottoNo) {
		this.lottoNo = lottoNo;

		if(isInvalidLottoNumbers()){
			throwIllegalException();
		}
	}

	private void throwIllegalException() {
		throw new IllegalArgumentException(String.format("Instantiate LottoNo failed. " +
						"lottoNo must be in range %d~%d : lottoNo=%d",
				LottoNo.LOWEST_NUMBER,
				LottoNo.HIGHEST_NUMBER,
				lottoNo));
	}

	private boolean isInvalidLottoNumbers() {
		return (lottoNo < LOWEST_NUMBER) || (HIGHEST_NUMBER < lottoNo);
	}

	public int getLottoNo() {
		return lottoNo;
	}

	@Override
	public String toString() {
		return "LottoNo{" +
				"lottoNo=" + lottoNo +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LottoNo lottoNo1 = (LottoNo) o;
		return lottoNo == lottoNo1.lottoNo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNo);
	}
}
