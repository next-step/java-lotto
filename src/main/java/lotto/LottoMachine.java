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

	public LottoMachine(int money) {
		if(money < LOTTO_PRICE) {
			throw new IllegalArgumentException("로또 최소 금액은 1000원입니다.");
		}
		this.money = money;
	}

	public Lottos purchaseManual(List<Lotto> manualLottos) {
		if(isOverManualLottoCount(money, manualLottos.size())) {
			throw new IllegalArgumentException("구매할 수 있는 최대 갯수를 넘었습니다.");
		}
		return new Lottos(manualLottos);
	}

	public Lottos purchaseAuto(int count) {
		return new Lottos(Stream.generate(this::generateLotto).limit(count).collect(Collectors.toList()));
	}

	public int purchaseLottoCount() {
		return this.money / LOTTO_PRICE;
	}

	private boolean isOverManualLottoCount(int money, int manualLottoCount) {
		return manualLottoCount > maxPurchaseLottoCount(money);
	}

	private int maxPurchaseLottoCount(int money) {
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
