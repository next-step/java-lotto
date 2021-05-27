package lotto.domain;

public class PurchaseRequest {

	public static final String MESSAGE_INVALID_MANUAL_AVAILABLE_PURCHASES = "총 금액 %s 원으로 수동로또 %d 개를 구입할 수 없습니다. (금액부족)";
	private final PurchaseAmount purchaseAmount;
	private final Lottos manualLottos;

	public PurchaseRequest(int purchaseAmount) {
		this(new PurchaseAmount(purchaseAmount));
	}

	public PurchaseRequest(PurchaseAmount purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
		this.manualLottos = new Lottos();
	}

	public PurchaseRequest(int purchaseAmount, Lottos manaulLottos) {
		this(new PurchaseAmount(purchaseAmount), manaulLottos);
	}

	public PurchaseRequest(PurchaseAmount purchaseAmount, Lottos manaulLottos) {
		validationManualPurchase(purchaseAmount, manaulLottos);
		this.purchaseAmount = purchaseAmount;
		this.manualLottos = manaulLottos;
	}

	private void validationManualPurchase(PurchaseAmount amount, Lottos lottos) {
		int needPurchseAmount = calculateManualPurchaseAmount(lottos);
		if (!amount.isGreaterThen(needPurchseAmount)) {
			throw new IllegalArgumentException(String.format(MESSAGE_INVALID_MANUAL_AVAILABLE_PURCHASES, amount, needPurchseAmount));
		}
	}

	protected static int calculateManualPurchaseAmount(Lottos lottos) {
		return PurchaseAmount.AMOUNT_PER_UNIT * lottos.size();
	}

	public int findNumberOfAutomaticPurchases() {
		int numberOfAvailablePurchases = purchaseAmount.findNumberOfAvailablePurchases();
		if (!manualLottos.isEmpty()) {
			numberOfAvailablePurchases -= manualLottos.size();
		}
		return numberOfAvailablePurchases;
	}

	public Lottos getManualLottos() {
		return manualLottos;
	}
}
