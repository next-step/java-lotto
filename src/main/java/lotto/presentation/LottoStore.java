package lotto.presentation;

import lotto.domain.*;

public class LottoStore {
    private final LottoInput lottoInput;
    private final LottoOutput lottoOutput;

    public LottoStore(LottoInput lottoInput, LottoOutput lottoOutput) {
        this.lottoInput = lottoInput;
        this.lottoOutput = lottoOutput;
    }

    public void trade() {
        // 구매
        Money money = lottoInput.inputMoneyToPurchaseLotto();
        LottoMachine lottoMachine = new LottoMachine(money);
        Lottos lottos = lottoMachine.pullSlot();
        lottoOutput.printPurchasedLottos(lottos, money);

        // 당첨번호 입력
        Lotto answerLottoNumbers = lottoInput.inputAnswerLottoNumbers();

        // 추첨
        Bank bank = new Bank(answerLottoNumbers);
        LottoWallet lottoWallet = bank.matchLottos(lottos, money);
        lottoOutput.printWinningStatistics(lottoWallet);
        lottoOutput.printProfitRate(lottoWallet.getProfitRate());
    }
}
