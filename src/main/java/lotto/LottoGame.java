package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
	public static final String REGEX = ", ";
	public static final String NOT_ENOUGH_MONEY = "최소 구매 금액보다 적은 금액입니다.";

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

	public List<LottoTicket> buyLotto(int price) {
		ArrayList<LottoTicket> lottos = new ArrayList<>();
		int lottoPrice = LottoRule.LOTTO_PRICE;
		int minimumNumber = LottoRule.LOTTO_MINIMUM_NUMBER;
		int maximumNumber = LottoRule.LOTTO_MAXIMUM_NUMBER;
		int lottoNumberCount = LottoRule.LOTTO_NUMBER_COUNT;

		while (price >= lottoPrice) {
			List<Integer> numbers = makeLottoNumbers(minimumNumber, maximumNumber, lottoNumberCount);
			lottos.add(new Lotto(numbers, lottoPrice));
			price = price - lottoPrice;
		}

		if (lottos.size() == 0) {
			throw new IllegalArgumentException(NOT_ENOUGH_MONEY);
		}
		return lottos;
	}

	public LottoReport lottoResult(List<LottoTicket> lottos, String winningNumbers, int bonusNumber) {
		WinningNumber winningNumber = new WinningNumber(Arrays
			.stream(winningNumbers.split(REGEX))
			.map(Integer::parseInt)
			.collect(Collectors.toList()), bonusNumber);

		LottoGroup lottoGroup = new LottoGroup(lottos
			.stream()
			.map(lottoTicket -> (Lotto)lottoTicket)
			.collect(Collectors.toList()));

		return lottoGroup.lottoResultReport(winningNumber);
	}
}
