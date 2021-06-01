package lotto;

import lotto.exceptions.LackOfMoneyToBuyLottoException;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
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
		if (lessThan(receivedMoney, Constants.LOTTO_PRICE) || lessThan(receivedMoney, usedMoneyForManualLottos)) {
			throw new LackOfMoneyToBuyLottoException();
		}

		List<Lotto> lottos = manualLottoNumbers.stream()
				.map(Lotto::new)
				.collect(Collectors.toList());

		lottos.addAll(IntStream.rangeClosed(1, numberOfLottosToBuy(receivedMoney, usedMoneyForManualLottos))
				.mapToObj((it) -> draw())
				.collect(Collectors.toList()));

		return new Lottos(lottos);
	}

	private static boolean lessThan(BigDecimal object, BigDecimal target) {
		return object.compareTo(target) < 0;
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
		return new Lotto(new ArrayList<>(lottoNumbers.subList(0, Constants.LOTTO_NUMBERS_LENGTH)));
	}
}
