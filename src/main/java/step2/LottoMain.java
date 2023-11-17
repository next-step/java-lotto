package step2;

import step2.domain.lotto.LottoNumber;
import step2.domain.lotto.LottoTicket;
import step2.domain.lotto.LottoWinningRank;

import java.util.ArrayList;
import java.util.List;

import static step2.domain.lotto.LottoGame.playLotto;
import static step2.view.InputView.inputPurchaseAmount;
import static step2.view.InputView.totalCount;
import static step2.view.InputView.winningLottoNumber;
import static step2.view.OutputView.printLottoNumbers;
import static step2.view.OutputView.result;

public class LottoMain {

    public static void main(String[] args) {
        int purchaseAmount = inputPurchaseAmount();
        int totalCount = totalCount(purchaseAmount);
        LottoWinningRank lottoWinningRank = playLotto(createLottoTickets(totalCount), LottoTicket.from(winningLottoNumber()));
        result(purchaseAmount, lottoWinningRank.getWinningCountMap());
    }

    private static List<LottoTicket> createLottoTickets(int totalCount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < totalCount; i++) {
            LottoTicket lottoTicket = LottoTicket.from(new LottoNumber());
            lottoTickets.add(lottoTicket);
            printLottoNumbers(lottoTicket.getLottoNumbers());
        }
        return lottoTickets;
    }
}
