package lotto;

public class LottoPurchaseArgument {
	private final LottoPayAmounts lottoPayAmounts;
	private final LottoNumbers lottoNumbers;

	private LottoPurchaseArgument(LottoPayAmounts lottoPayAmounts, LottoNumbers lottoNumbers) {
		this.lottoPayAmounts = lottoPayAmounts;
		this.lottoNumbers = lottoNumbers;
	}

	public static LottoPurchaseArgument of(LottoPayAmounts payAmounts, LottoNumbers manualLottoNumbers) {
		return new LottoPurchaseArgument(payAmounts, manualLottoNumbers);
	}
}
