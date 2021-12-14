package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

	private static final String INPUT_AMOUNT_ZERO_UP = "금액은 0원 이상 입력해주세요.";
	private final int purchaseAmount;
	private int numberOfPurchase;
	private List<LottoNumbers> userPurchaseLotto;


	public LottoStore(int purchaseAmount) {
		if (purchaseAmount <= 0) {
			throw new IllegalArgumentException(INPUT_AMOUNT_ZERO_UP);
		}
		this.purchaseAmount = purchaseAmount;
		this.userPurchaseLotto = new ArrayList<>();
		this.numberOfPurchase = 0;
	}

	public List<LottoNumbers> buyLotto() {
		calculateNumberOfLotto();
		issueLotto();
		return userPurchaseLotto;
	}

	private void calculateNumberOfLotto() {
		numberOfPurchase = purchaseAmount / 1000;
		issueLotto();
	}

	private void issueLotto() {
		List<LottoNumbers> lotto = new ArrayList<>();
		for (int i = 0; i < numberOfPurchase; i++) {
			lotto.add(LottoNumbers.createAutoLottoNumber());
		}
		userPurchaseLotto = lotto;
	}

}
