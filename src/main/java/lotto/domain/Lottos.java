package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lottos {

	public static final String MESSAGE_INVALID_MANUAL_AVAILABLE_PURCHASES = "총 금액 %s 원으로 수동로또 %d 개를 구입할 수 없습니다. (금액부족)";

	private final List<Lotto> lottos;

	public Lottos(Lotto... lottos) {
		this.lottos = Arrays.asList(lottos);
	}

	public Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public Lottos(RandomNumbersGenerator randomNumbersGenerator, PurchaseAmount purchaseAmount) {
		this(randomNumbersGenerator, purchaseAmount, new Lottos());
	}

	public Lottos(RandomNumbersGenerator randomNumbersGenerator, PurchaseAmount purchaseAmount, Lottos manualLottos) {
		validationManualLottos(purchaseAmount, manualLottos);
		lottos = new ArrayList<>(manualLottos.getLottos());
		int manualQuantity = manualLottos.size();
		int autoQuantity = purchaseAmount.availablePurchasesQuantity() - manualQuantity;
		generateRandomNumbers(randomNumbersGenerator, autoQuantity);
	}

	private void validationManualLottos(PurchaseAmount purchaseAmount, Lottos manualLottos) {
		int manualQuantity = manualLottos.size();
		int autoQuantity = purchaseAmount.availablePurchasesQuantity() - manualQuantity;
		if (autoQuantity < 0) {
			throw new IllegalArgumentException(String.format(MESSAGE_INVALID_MANUAL_AVAILABLE_PURCHASES, purchaseAmount, manualQuantity));
		}
	}

	private void generateRandomNumbers(RandomNumbersGenerator randomNumbersGenerator, int generateCount) {
		for (int i = 0; i < generateCount; i++) {
			lottos.add(new Lotto(randomNumbersGenerator));
		}
	}

	public LottoResults findResult(WinningLotto winningLotto) {
		List<Rank> ranks = new ArrayList<>();
		for (Lotto lotto : lottos) {
			Rank rank = winningLotto.findRank(lotto);
			ranks.add(rank);
		}
		return new LottoResults(ranks);
	}

	public List<Lotto> getLottos() {
		return lottos;
	}

	public int size() {
		return lottos.size();
	}
}
