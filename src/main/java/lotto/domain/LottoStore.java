package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.view.InputView;

public class LottoStore {

	private final Money money;
	private final List<LottoNumbers> userPurchaseLottoTickets;
	private int autoBuyingCount;
	private int manualBuyingCount;

	public LottoStore(int money) {
		this.money = new Money(money);
		this.autoBuyingCount = this.money.numberOfPurchase();
		this.userPurchaseLottoTickets = new ArrayList<>();
	}

	public LottoStore(int money, int manualBuyingCount) {
		this(money);
		this.autoBuyingCount -= manualBuyingCount;
		this.manualBuyingCount = manualBuyingCount;
	}

	public List<LottoNumbers> buyingAutoLotto() {
		issueAutoLotto();
		return userPurchaseLottoTickets;
	}

	public List<LottoNumbers> buyingAutoAndManualLotto(List<List<Integer>> userInputLottoNumbers) {
		issueManualLotto(userInputLottoNumbers);
		issueAutoLotto();
		return userPurchaseLottoTickets;
	}

	public void issueManualLotto(List<List<Integer>> userInputLottoNumbers) {
		for (List<Integer> lottoNumbers : userInputLottoNumbers) {
			userPurchaseLottoTickets.add(LottoNumbers.createManualLottoNumber(lottoNumbers));
		}
	}

	private void issueAutoLotto() {
		for (int i = 0; i < autoBuyingCount; i++) {
			userPurchaseLottoTickets.add(LottoNumbers.createAutoLottoNumber());
		}
	}

	public boolean containManualLotto() {
		return manualBuyingCount > 0;
	}

	public int getManualBuyingCount() {
		return manualBuyingCount;
	}

	public int getAutoBuyingCount() {
		return autoBuyingCount;
	}
}
