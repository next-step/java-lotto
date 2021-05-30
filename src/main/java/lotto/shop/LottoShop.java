package lotto.shop;

import java.util.ArrayList;
import java.util.List;

import lotto.Lotto;
import lotto.LottoGenerator;
import lotto.NotEnoughMoneyException;
import lotto.Wallet;

public class LottoShop {

	public static final int LOTTO_PRICE = 1000;

	private static final boolean CERTIFICATE = true;

	public Lottos buyLottos(Wallet wallet) {
		validateWallet(wallet);

		List<Lotto> values = new ArrayList<>();

		for (int i = 0; i < wallet.buyLimit(); i++) {
			values.add(LottoGenerator.generate());
		}

		return new Lottos(CERTIFICATE, values);
	}

	public Lottos buyLottos(Wallet wallet, Lottos beforeBuy) {
		validateWallet(wallet);

		Wallet spendWallet = wallet.pay(beforeBuy.totalPrice());

		return new Lottos(CERTIFICATE, beforeBuy, buyLottos(spendWallet));
	}

	private void validateWallet(Wallet wallet) {
		if (!wallet.isEnough()) {
			throw new NotEnoughMoneyException("로또를 구입하기엔 돈이 부족합니다.");
		}
	}
}
