package lotto.domain;

public class PurchaseRequest {

	public static final String MESSAGE_INVALID_MANUAL_AVAILABLE_PURCHASES = "총 금액 %s 원으로 수동로또 %d 개를 구입할 수 없습니다. (금액부족)";
	private final PurchaseAmount purchaseAmount;
	private final Lottos manualLottos;

	public PurchaseRequest(PurchaseAmount purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
		this.manualLottos = new Lottos();
	}

	public PurchaseRequest(PurchaseAmount purchaseAmount, Lottos manaulLottos) {
		validationManualLottos(purchaseAmount, manaulLottos);
		this.purchaseAmount = purchaseAmount;
		this.manualLottos = manaulLottos;
	}

	private void validationManualLottos(PurchaseAmount purchaseAmount, Lottos manualLottos) {
		int manualQuantity = manualLottos.size();
		int autoQuantity = purchaseAmount.availablePurchasesQuantityMinusManualQuantity(manualQuantity);
		if (autoQuantity < 0) {
			throw new IllegalArgumentException(String.format(MESSAGE_INVALID_MANUAL_AVAILABLE_PURCHASES, purchaseAmount, manualQuantity));
		}
	}

	public Lottos getManualLottos() {
		return manualLottos;
	}

	public PurchaseAmount getPurchaseAmount() {
		return purchaseAmount;
	}

	public int getManualLottoQuantity() {
		return manualLottos.size();
	}

	public int getAutomaticLottoQuantity() {
		return purchaseAmount.availablePurchasesQuantityMinusManualQuantity(getManualLottoQuantity());
	}
}
