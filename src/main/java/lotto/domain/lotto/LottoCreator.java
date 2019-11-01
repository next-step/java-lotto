package lotto.domain.lotto;


import lotto.domain.person.Wallet;

public class LottoCreator {

	private LottoNumbersGeneratePolicy createPolicy;

	private static int LOTTO_PRICE = 1000;

	private LottoCreator(LottoNumbersGeneratePolicy createPolicy) {
		this.createPolicy = createPolicy;
	}

	public static LottoCreator of(LottoNumbersGeneratePolicy createPolicy) {
		return new LottoCreator(createPolicy);
	}

	public boolean canAffordToBuyLotto(Wallet wallet) {
		return wallet.hasMoreThan(LOTTO_PRICE);
	}

	public Lotto pickLotto(Wallet wallet) {
		wallet.minus(LOTTO_PRICE);
		return Lotto.of(createPolicy.generate());
	}

}
