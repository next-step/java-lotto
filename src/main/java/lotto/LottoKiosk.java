package lotto;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import lotto.factory.LottoNumbersFactory;
import lotto.input.InputValidator;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LottoKiosk {

	public static final int LOTTO_PRICE = 1000;

	public static Lottos issue(String paidAmountsString) {
		InputValidator.validatePurchasePrice(paidAmountsString);

		int paidAmounts = Integer.parseInt(paidAmountsString);
		int countOfLotto = paidAmounts / LOTTO_PRICE;

		return Lottos.of(IntStream.range(0, countOfLotto)
								  .mapToObj(i -> new Lotto(LottoNumbersFactory.create()))
								  .collect(Collectors.toList()));
	}
}
