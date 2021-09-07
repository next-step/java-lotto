package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Wallet {
	private final static int PRICE_OF_LOTTO = 1000;
	private final static String SPACE = " ";
	private final static String EMPTY_STRING = "";
	private final static String COMMA = ",";
	private int money;

	public Wallet(int money) {
		this.money = money;
	}

	public int numberOfThingsToBuy() {
		return money / PRICE_OF_LOTTO;
	}

	public Lottos buyLottoByAuto() {
		int count = numberOfThingsToBuy();
		List<Lotto> lottos = new ArrayList<>();
		LottoCard lottoCard = LottoCard.getInstance();
		for (int i = 0; i < count; i++) {
			Lotto lotto = lottoCard.issue();
			lottos.add(lotto);
		}
		deduction(count);
		return new Lottos(lottos);
	}

	public Lottos buyLottoByManual(List<String> lottoNumbers) {
		int count = lottoNumbers.size();

		List<Lotto> lottos = new ArrayList<>();
		LottoCard lottoCard = LottoCard.getInstance();
		for (String strNumbers : lottoNumbers) {
			List<Integer> numbers = convert(strNumbers);
			Lotto lotto = lottoCard.issueByManual(numbers);
			lottos.add(lotto);
		}

		deduction(count);
		return new Lottos(lottos);
	}

	private List<Integer> convert(String strNumbers) {
		String[] splitNumbers = strNumbers.replace(SPACE, EMPTY_STRING)
			.split(COMMA);
		return Arrays.stream(splitNumbers)
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}

	private void deduction(int count) {
		money -= count * PRICE_OF_LOTTO;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Wallet wallet = (Wallet)o;
		return money == wallet.money;
	}

	@Override
	public int hashCode() {
		return Objects.hash(money);
	}
}
