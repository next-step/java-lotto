package step2.domain;

import static step2.domain.var.LottoConstant.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
	private final List<LottoNumber> lottoNumbers;

	public Lotto(List<LottoNumber> lottoNumbers) {
		List<LottoNumber> distinctLottoNumbers = lottoNumbers.stream().distinct().collect(Collectors.toList());
		if (lottoNumbers.size() != LOTTO_COUNT || distinctLottoNumbers.size() != LOTTO_COUNT) {
			throw new IllegalArgumentException("로또 번호는 중복되지 않는 " + LOTTO_COUNT + "개의 번호여야 합니다.");
		}
		this.lottoNumbers = lottoNumbers;
	}

	public boolean contains(LottoNumber winNumber) {
		return lottoNumbers.contains(winNumber);
	}

	public List<LottoNumber> getLottoNumbers() {
		return new ArrayList<>(lottoNumbers);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Lotto : [");
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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Lotto lotto = (Lotto)o;
		return Objects.equals(lottoNumbers, lotto.lottoNumbers);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(lottoNumbers);
	}

}
