package lotto.domain.lotto;


import lotto.domain.lotto.policy.LottoNumbersGeneratePolicy;
import lotto.domain.person.Wallet;

public class LottoCreator {

	private final LottoNumbersGeneratePolicy createPolicy;
	private final LottoType type;

	// 로또 생산자는 로또 가격을 누구나 볼 수 있게 적어 두어야 한다
	public static final int LOTTO_PRICE = 1000;

	private LottoCreator(LottoNumbersGeneratePolicy createPolicy, LottoType type) {
		this.createPolicy = createPolicy;
		this.type = type;
	}

	public static LottoCreator of(LottoNumbersGeneratePolicy createPolicy, LottoType type) {
		return new LottoCreator(createPolicy, type);
	}

	public Lotto pickLotto(Wallet wallet) {
		wallet.minus(LOTTO_PRICE);
		return Lotto.of(createPolicy.generate(), type);
	}

}
