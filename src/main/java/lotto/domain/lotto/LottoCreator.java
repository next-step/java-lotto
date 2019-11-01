package lotto.domain.lotto;


import lotto.domain.person.Wallet;

public class LottoCreator {

	private LottoNumbersGeneratePolicy createPolicy;

	// 로또 생산자는 로또 가격을 누구나 볼 수 있게 적어 두어야 한다
	public static final int LOTTO_PRICE = 1000;

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
