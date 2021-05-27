package lotto.presentation;

import lotto.domain.*;

import java.util.List;

import static lotto.domain.LottoOptions.LOTTO_PRICE;

/**
 * 비즈니스 호출 객체
 */
public final class LottoStore {
    private final LottoInput lottoInput;
    private final LottoOutput lottoOutput;
    private final Money lottoPrice;

    public LottoStore(final LottoInput lottoInput, final LottoOutput lottoOutput) {
        this.lottoInput = lottoInput;
        this.lottoOutput = lottoOutput;
        this.lottoPrice = new Money(LOTTO_PRICE);
    }

    public void trade() {
        // 구매
        final Money moneyToPurchaseLotto = lottoInput.inputMoneyToPurchaseLotto();
        final LottoMachine lottoMachine = new LottoMachine(lottoPrice);
        final int allLottoCount = lottoMachine.getPurchableLottoCount(moneyToPurchaseLotto);

        // 로또 수동
        final int manualLottoCount = lottoInput.inputManualLottoCount();
        final PurchaseInformation manualPurchaseInformation = new ManualPurchaseInformation(allLottoCount, manualLottoCount);
        final List<String> inputManualLottoNumbers = lottoInput.inputManualLottoNumbers(manualPurchaseInformation.getLottoCount());
        final List<Lotto> manualLottos = lottoMachine.pullSlot(manualPurchaseInformation, new LottoNumberManualGenerator(inputManualLottoNumbers));

        // 로또 자동
        final PurchaseInformation autoPurchaseInformation = new AutoPurchaseInformation(allLottoCount, manualLottoCount);
        final List<Lotto> autoLottos = lottoMachine.pullSlot(autoPurchaseInformation, new LottoNumberAutoGenerator());

        // 로또 구매 결과
        final Lottos lottos = new Lottos(manualLottos, autoLottos);
        lottoOutput.printPurchasedLottos(lottos, manualPurchaseInformation);

        // 당첨번호 입력
        final Lotto answerLottoNumbers = lottoInput.inputAnswerLottoNumbers();
        final LottoNumber bonusNumber = lottoInput.inputBonusNumber();

        // 추첨
        final WinningResult winningResult = new WinningResult(answerLottoNumbers, bonusNumber);
        winningResult.matchWinningLotto(lottos);
        lottoOutput.printWinningStatistics(winningResult);
        lottoOutput.printProfitRate(winningResult.getProfitRate(moneyToPurchaseLotto));
    }
}
