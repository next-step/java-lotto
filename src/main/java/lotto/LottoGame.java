package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
	public static final String REGEX = ", ";
	public static final String NOT_ENOUGH_MONEY = "필요한 로또를 구매하기에 돈이 부족합니다.";

	private List<Integer> makeLottoNumbers(int minimum, int maximum, int count) {
		ArrayList<Integer> numberScope = new ArrayList<>();

		for (int i = minimum; i < maximum + 1; i++) {
			numberScope.add(i);
		}

		Collections.shuffle(numberScope);
		List<Integer> lottoNumbers = numberScope.subList(0, count);
		Collections.sort(lottoNumbers);
		return lottoNumbers;
	}

	private List<Integer> numberStringToList(String numbers) {
		return Arrays
			.stream(numbers.split(REGEX))
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}

	private LottoTicket buyLotto(List<Integer> numbers, Money money) {
		Money lottoPrice = new Money(LottoRule.LOTTO_PRICE);

		if (money.biggerThan(lottoPrice)) {
			money.spend(lottoPrice);
			return new Lotto(numbers, lottoPrice);
		}

		throw new IllegalArgumentException(NOT_ENOUGH_MONEY);
	}

	public List<LottoTicket> buyLotto(Money money) {
		Money lottoPrice = new Money(LottoRule.LOTTO_PRICE);
		int minimumNumber = LottoRule.LOTTO_MINIMUM_NUMBER;
		int maximumNumber = LottoRule.LOTTO_MAXIMUM_NUMBER;
		int lottoNumberCount = LottoRule.LOTTO_NUMBER_COUNT;
		ArrayList<LottoTicket> lottos = new ArrayList<>();

		while (money.biggerThan(lottoPrice)) {
			List<Integer> numbers = makeLottoNumbers(minimumNumber, maximumNumber, lottoNumberCount);
			lottos.add(buyLotto(numbers, money));
		}

		if (lottos.isEmpty()) {
			throw new IllegalArgumentException(NOT_ENOUGH_MONEY);
		}

		return lottos;
	}

	public List<LottoTicket> buyManualLotto(List<String> manualNumbers, Money money) {
		return manualNumbers
			.stream()
			.map(manualNumber -> buyLotto(numberStringToList(manualNumber), money))
			.collect(Collectors.toList());
	}

	public LottoReport lottoResult(List<LottoTicket> lottos, String winningNumbers, int bonusNumber) {
		WinningNumber winningNumber = new WinningNumber(numberStringToList(winningNumbers), bonusNumber);

		LottoGroup lottoGroup = new LottoGroup(lottos
			.stream()
			.map(lottoTicket -> (Lotto)lottoTicket)
			.collect(Collectors.toList()));

		return lottoGroup.lottoResultReport(winningNumber);
	}
}
