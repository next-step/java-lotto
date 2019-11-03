package lotto.domain.person;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoPrize;
import lotto.dto.LottoDto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class BuyingLotteries {

	private final List<Lotto> lotteries;

	BuyingLotteries(List<Lotto> lotteries) {
		this.lotteries = lotteries;
	}

	void add(Lotto lotto) {
		lotteries.add(lotto);
	}

	List<LottoDto> toLottoDtos() {
		return lotteries.stream()
				.map(LottoDto::of)
				.collect(Collectors.toList());
	}

	List<LottoPrize> checkAllLotteries(List<Integer> answerNumbers, int bonusNumber) {
		return lotteries.stream()
				.map(lotto -> lotto.examine(answerNumbers, bonusNumber))
				.collect(Collectors.toList());
	}

	boolean isEmpty() {
		return lotteries.isEmpty();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BuyingLotteries that = (BuyingLotteries) o;
		return Objects.equals(lotteries, that.lotteries);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lotteries);
	}

}
