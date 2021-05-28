package lotto.domain;

public class LottoGame {

	private RandomNumbersGenerator randomNumbersGenerator;

	public LottoGame(RandomNumbersGenerator randomNumbersGenerator) {
		this.randomNumbersGenerator = randomNumbersGenerator;
	}

	public Lottos purchaseLottos(PurchaseRequest purchaseRequest) {
		return new Lottos(randomNumbersGenerator, purchaseRequest.getPurchaseAmount(), purchaseRequest.getManualLottos());
	}

}
