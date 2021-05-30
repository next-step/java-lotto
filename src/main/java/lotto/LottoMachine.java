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

	private Lottos purchasedAutoLotto;
	private Lottos purchasedManualLotto;

	public LottoMachine(int money, List<Lotto> manualLottos) {
		if(isOverManualLottoCount(money, manualLottos.size())) {
			throw new IllegalArgumentException("구매할 수 있는 최대 갯수를 넘었습니다.");
		}
		purchase(money, manualLottos);
	}

	public Lottos getPurchasedAutoLotto() {
		return purchasedAutoLotto;
	}

	public Lottos getPurchasedManualLotto() {
		return purchasedManualLotto;
	}

	public Lottos getPurchasedLotto() {
		return new Lottos(Stream.concat(purchasedAutoLotto.getLottos().stream(),
			purchasedManualLotto.getLottos().stream()).collect(Collectors.toList()));
	}

	private boolean isOverManualLottoCount(int money, int manualLottoCount) {
		return manualLottoCount > maxPurchaseLottoCount(money);
	}

	private void purchase(int money, List<Lotto> manualLottos) {
		this.purchasedManualLotto = purchaseManual(manualLottos);
		this.purchasedAutoLotto = purchaseAuto(maxPurchaseLottoCount(money) - manualLottos.size());
	}

	private Lottos purchaseManual(List<Lotto> manualLottos) {
		return new Lottos(manualLottos);
	}

	private Lottos purchaseAuto(int count) {
		return new Lottos(Stream.generate(this::generateLotto).limit(count).collect(Collectors.toList()));
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
