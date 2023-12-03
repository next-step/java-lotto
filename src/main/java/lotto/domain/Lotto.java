package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
	public static final Integer PRICE = 1000;
	private final List<LottoNo> lotto;

	public Lotto(List<Integer> lottoNos) {
		validate(lottoNos);
		this.lotto = lottoNos.stream()
				.map(number -> new LottoNo(number))
				.collect(Collectors.toList());
	}

	private void validate(List<Integer> lottoNos) {
		if (lottoNos.size() != 6) {
			throw new IllegalArgumentException("로또는 6개의 숫자로 이루어져야 합니다.");
		}
	}

	public Ranking ranking(WinningLotto winningLotto) {
		int matchingCount = (int) lotto.stream().filter(lottoNo -> winningLotto.lotto().contains(lottoNo)).count();
		boolean hasBonusNumber = contains(winningLotto.bonusNumber());

		return Ranking.of(matchingCount, hasBonusNumber);
	}

	private boolean contains(LottoNo lottoNo) {
		return lotto.contains(lottoNo);
	}

	@Override
	public String toString() {
		return lotto + "";
	}
}
