package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoRank;
import lotto.domain.LottoTicket;
import lotto.domain.WinningLottoTicket;
import lotto.view.LottoConsoleView;

public class LottoMain {


    public static void main(String[] args) {

        LottoConsoleView lottoConsoleView = new LottoConsoleView();

        int buyPrice = lottoConsoleView.inputLottoPrice();

        LottoMachine lottoMachine = new LottoMachine(buyPrice);


        int lottoCount = lottoMachine.lottoCount();

        lottoConsoleView.showLottoCount(lottoCount);

        lottoMachine.getLottoTickets().stream()
                .forEach(lottoTicket -> lottoConsoleView.showLottoNumber(lottoTicket.getLottoNumbers()));

        System.out.println();

        String winningNumber = lottoConsoleView.inputWinningNumber();
        int bonusNumber = lottoConsoleView.inputBonusNumber();

        lottoMachine.saveWinningNumber(new WinningLottoTicket(new LottoTicket(winningNumber), bonusNumber));

        lottoConsoleView.showBeforeStatistics();

        for(LottoRank rank : LottoRank.values()){
            if(rank == LottoRank.NOTTING_PLACE){
                continue;
            }

            lottoConsoleView.showMatch(rank, lottoMachine.rottoRankMatchCount(rank));
        }

        lottoConsoleView.showTotol(lottoMachine.getAggregationOfReturns());

    }

}
