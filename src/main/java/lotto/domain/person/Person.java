package lotto.domain.person;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoCreator;
import lotto.domain.lotto.LottoPrize;
import lotto.dto.LottoDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {

	private final Wallet wallet;
	private final BuyingLotteries lotteries;

	private Person(long amount, List<Lotto> lotteries) {
		this.wallet = Wallet.of(amount);
		this.lotteries = new BuyingLotteries(lotteries);
	}

	public static Person of(long amount) {
		return of(amount, new ArrayList<>());
	}

	public static Person of(long amount, List<Lotto> lotteries) {
		return new Person(amount, lotteries);
	}

	public void buyLottoWithAllMoney(LottoCreator lottoCreator) {
		for (int i = 0, end = wallet.getPossibleNumberToBuy(LottoCreator.LOTTO_PRICE); i < end; i++) {
			buyLotto(lottoCreator);
		}
	}

	private void buyLotto(LottoCreator lottoCreator) {
		lotteries.add(lottoCreator.pickLotto(wallet));
	}

	public List<LottoDto> getLottoDtos() {
		return lotteries.toLottoDtos();
	}

	public List<LottoPrize> checkAllLotteries(List<Integer> answerNumbers, int bonusNumber) {
		validateEmptyLotteries();
		return lotteries.checkAllLotteries(answerNumbers, bonusNumber);
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
