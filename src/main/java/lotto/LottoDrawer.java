package lotto;

import lotto.exceptions.LackOfMoneyToBuyLottoException;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoDrawer {
	private static final List<Integer> lottoNumbers =
			IntStream.rangeClosed(Constants.LOTTO_MIN_NUMBER, Constants.LOTTO_MAX_NUMBER)
					.boxed()
					.collect(Collectors.toList());

	private LottoDrawer() {
	}

	public static Lottos draw(BigDecimal receivedMoney, List<List<Integer>> manualLottoNumbers) {
		BigDecimal usedMoneyForManualLottos = getUsedMoney(manualLottoNumbers.size());
		if (receivedMoney.compareTo(Constants.LOTTO_PRICE) < 0 || receivedMoney.compareTo(usedMoneyForManualLottos) < 0) {
			throw new LackOfMoneyToBuyLottoException();
		}

		List<Lotto> lottos = manualLottoNumbers.stream()
				.map(it -> it.stream()
						.sorted()
						.collect(Collectors.toList()))
				.map(Lotto::new)
				.collect(Collectors.toList());

		lottos.addAll(IntStream.rangeClosed(1, numberOfLottosToBuy(receivedMoney, usedMoneyForManualLottos))
				.mapToObj((it) -> draw())
				.collect(Collectors.toList()));

		return new Lottos(lottos);
	}

	private static BigDecimal getUsedMoney(int numberOfManualLottoNumbers) {
		return BigDecimal.valueOf(numberOfManualLottoNumbers)
				.multiply(Constants.LOTTO_PRICE);
	}

	private static int numberOfLottosToBuy(BigDecimal receivedMoney, BigDecimal usedMoneyForManualLottos) {
		return receivedMoney.subtract(usedMoneyForManualLottos)
				.divide(Constants.LOTTO_PRICE, MathContext.DECIMAL32)
				.intValue();
	}

	protected static Lotto draw() {
		Collections.shuffle(lottoNumbers);
		return new Lotto(lottoNumbers.subList(0, Constants.LOTTO_NUMBERS_LENGTH)
				.stream()
				.sorted()
				.collect(Collectors.toList()));
	}
}
