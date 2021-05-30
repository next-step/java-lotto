package lotto;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {

	public static final int LOTTO_PRICE = 1000;

	public Lottos buyLottos(Wallet wallet) {
		validateWallet(wallet);

		List<Lotto> values = new ArrayList<>();

		for (int i = 0; i < wallet.buyLimit(); i++) {
			values.add(LottoGenerator.generate());
		}

		return new Lottos(values);
	}

	public Lottos buyLottos(Wallet wallet, List<String> beforeBuy) {
		validateWallet(wallet);

		Lottos manualLottos
			= new Lottos(beforeBuy.stream()
				.map(LottoGenerator::generate)
				.collect(toList()));
		Wallet spendWallet = wallet.spend(beforeBuy.size());

		return new Lottos(manualLottos, buyLottos(spendWallet));
	}

	private void validateWallet(Wallet wallet) {
		if (!wallet.isEnough()) {
			throw new NotEnoughMoneyException("로또를 구입하기엔 돈이 부족합니다.");
		}
	}
}
