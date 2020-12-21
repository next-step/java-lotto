package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.swing.text.html.Option;

public class LottoNumber {
	private List<Integer> lottoNumber;

	public LottoNumber() {
	}

	public LottoNumber(List<Integer> lottoNumber) {
		this.lottoNumber = lottoNumber;
	}

	public List<Integer> getLottoNumber() {
		return lottoNumber;
	}

	public void generate(NumberGenerator numberGenerator) {
		this.lottoNumber = numberGenerator.generateNumbers();
	}

	private int countSameNumber(LottoNumber winLottoNumber) {
		return (int) lottoNumber.stream()
			.filter(ln -> winLottoNumber.getLottoNumber().contains(ln))
			.count();
	}

	public Optional<LottoRank> rankLotto(LottoNumber winLottoNumber) {
		int sameNumberCount = countSameNumber(winLottoNumber);
		return Arrays.stream(LottoRank.values())
			.filter(lottoRank -> lottoRank.getCountOfMatch() == sameNumberCount).findFirst();
	}

	@Override
	public String toString() {
		return "["+lottoNumber.stream().map(ln -> Integer.toString(ln)).collect(Collectors.joining(", "))+"]";
	}
}
