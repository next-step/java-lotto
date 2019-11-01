package lotto.domain;

class LottoCreator {

	private static int LOTTO_PRICE = 1000;

	static boolean canAffordToBuyLotto(Wallet wallet) {
		return wallet.hasMoreThan(LOTTO_PRICE);
	}

	static Lotto pickLotto(Wallet wallet) {
		wallet.minus(LOTTO_PRICE);
		return new Lotto();
	}

}
