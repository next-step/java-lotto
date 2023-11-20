package step2.lotto.domain;

public class LottoMachine {

    private final Lottos purchaseLottos;
    private final LottoPurchaseInfo lottoPurchaseInfo;

    public LottoMachine(final int inputMoney, final LottoNumberGenerator lottoNumberGenerator) {
        this.lottoPurchaseInfo = new LottoPurchaseInfo(inputMoney);
        this.purchaseLottos = new Lottos(LottosFactory.createLottos(lottoPurchaseInfo.getLottoTicketCount(), lottoNumberGenerator));
    }

    public LottoPurchaseInfo getLottoPurchaseInfo () {
        return lottoPurchaseInfo;
    }

    public Lottos getPurchaseLottos() {
        return purchaseLottos;
    }

}
