package lotto;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoDrawer {
	private final List<Integer> lottoNumbers;

	public LottoDrawer() {
		this.lottoNumbers = IntStream.rangeClosed(Constants.LOTTO_MIN_NUMBER, Constants.LOTTO_MAX_NUMBER)
				.boxed()
				.collect(Collectors.toList());
	}

	public Lottos draw(BigDecimal receivedMoney) {
		return new Lottos(IntStream.rangeClosed(1, numberOfLottosToBuy(receivedMoney))
				.mapToObj((it) -> draw())
				.collect(Collectors.toList()));
	}

	private int numberOfLottosToBuy(BigDecimal receivedMoney) {
		return receivedMoney.divide(Constants.LOTTO_PRICE, MathContext.DECIMAL32)
				.intValue();
	}

	protected Lotto draw() {
		Collections.shuffle(lottoNumbers);
		return new Lotto(lottoNumbers.subList(0, Constants.LOTTO_NUMBERS_LENGTH)
				.stream()
				.sorted()
				.collect(Collectors.toList()));
	}
}
