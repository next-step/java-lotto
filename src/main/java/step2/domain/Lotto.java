package step2.domain;

import java.util.List;

public class Lotto {
	List<LottoNumber> lottoNumbers;

	public Lotto(List<LottoNumber> lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < lottoNumbers.size(); i++) {
			LottoNumber number = lottoNumbers.get(i);
			sb.append(number.getNumber());
			if (i < lottoNumbers.size() - 1) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
}
