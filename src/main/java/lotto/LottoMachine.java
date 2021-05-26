package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoMachine {

	public static final int LOTTO_PRICE = 1000;
	private static final List<LottoNumber> LOTTO_NUMBER_BUCKET = IntStream.range(LottoNumber.MIN_NUMBER,LottoNumber.MAX_NUMBER)
		.mapToObj(LottoNumber::new).collect(Collectors.toList());

	private int money;
	private Lottos purchasedLotto;

	public LottoMachine(int money) {
		this.money = money;
		this.purchasedLotto = purchase();
	}

	public Lottos getPurchasedLotto() {
		return purchasedLotto;
	}

	private Lottos purchase() {
		return new Lottos(Stream.generate(this::generateLotto).limit(maxPurchaseLottoCount()).collect(Collectors.toList()));
	}

	private int maxPurchaseLottoCount() {
		return money / LOTTO_PRICE;
	}

	private List<LottoNumber> getRandomLottoNumber() {
		Collections.shuffle(LOTTO_NUMBER_BUCKET);
		return new ArrayList<>(LOTTO_NUMBER_BUCKET.subList(0, Lotto.MAX_LOTTO_COUNT));
	}

	private Lotto generateLotto() {
		return new Lotto(getRandomLottoNumber());
	}
}
