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

    public LottoStore(final LottoInput lottoInput, final LottoOutput lottoOutput) {
        this.lottoInput = lottoInput;
        this.lottoOutput = lottoOutput;
    }

    public void trade() {
        // 구매
        final Money lottoPrice = new Money(LOTTO_PRICE);
        final Money toPurchaseLotto = lottoInput.inputMoneyToPurchaseLotto();
        final List<Lotto> lottos = new LottoMachine(lottoPrice).pullSlot(toPurchaseLotto, new LottoNumberAutoGenerator());
        lottoOutput.printPurchasedLottos(lottos);

        // 당첨번호 입력
        final Lotto answerLottoNumbers = lottoInput.inputAnswerLottoNumbers();
        final LottoNumber bonusNumber = lottoInput.inputBonusNumber();

        // 추첨
        final WinningResult winningResult = new WinningResult(answerLottoNumbers, bonusNumber);
        winningResult.matchWinningLotto(lottos);
        lottoOutput.printWinningStatistics(winningResult);
        lottoOutput.printProfitRate(winningResult.getProfitRate(toPurchaseLotto));
    }
}
