package lotto.domain.person;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoCreator;
import lotto.dto.LottoDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Person {

	private final Wallet wallet;
	private final List<Lotto> lotteries;

	private Person(long amount, List<Lotto> lotteries) {
		this.wallet = Wallet.of(amount);
		this.lotteries = lotteries;
	}

	public static Person of(long amount) {
		return of(amount, new ArrayList<>());
	}

	public static Person of(long amount, List<Lotto> lotteries) {
		return new Person(amount, lotteries);
	}

	public void buyLottoWithAllMoney(LottoCreator lottoCreator) {
		while (lottoCreator.canAffordToBuyLotto(wallet)) {
			buyLotto(lottoCreator);
		}
	}

	private void buyLotto(LottoCreator lottoCreator) {
		lotteries.add(lottoCreator.pickLotto(wallet));
	}

	public List<LottoDto> getLottoDtos() {
		return lotteries.stream()
				.map(LottoDto::of)
				.collect(Collectors.toList());
	}

	public void checkAllLotteries(List<Integer> answerNumbers) {
		validateEmptyLotteries();
		for (Lotto lotto : lotteries) {
			lotto.examine(answerNumbers);
		}
	}

	private void validateEmptyLotteries() {
		if (lotteries.isEmpty()) {
			throw new IllegalStateException("비교할 수 있는 로또가 없습니다");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Person person = (Person) o;
		return Objects.equals(wallet, person.wallet) &&
				Objects.equals(lotteries, person.lotteries);
	}

	@Override
	public int hashCode() {
		return Objects.hash(wallet, lotteries);
	}

}
