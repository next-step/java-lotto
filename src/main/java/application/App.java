package application;

import lotto.Lotto;
import lotto.LottoTicket;
import lotto.LottoType;
import lotto.ManyTickets;
import view.LottoInput;
import view.LottoOutput;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        LottoInput lottoInput = new LottoInput();
        Lotto lotto = new Lotto();
        int number = lottoInput.getTicketCount(); // 전체 로또 반복 갯수
        int manualTicketNumber = lottoInput.getActiveTicketCount(number); //  자동 로또 갯수
        List<LottoTicket> pasiveTickets = lottoInput.getLottoPassiveTickets();

        ManyTickets manyLottoTickets = lotto.purChase(pasiveTickets, manualTicketNumber); // 구입 한 로또 리스트

        LottoOutput lottoOutput = new LottoOutput();
        lottoOutput.printTickets(manyLottoTickets); // UI.메소드

        List<Integer> winningNumbers = lottoInput.getWinningNumber();  // 지난주 당첨 번호 리스트 scan
        int bonusNumber = lottoInput.getBonusNumber();

        Map<LottoType, Long> results = lotto.winningStatistics(manyLottoTickets, winningNumbers, bonusNumber);// 당첨 통계 메소드

        lottoOutput.printWinningList(results); // 당첨 통계  ui 메소드

        BigDecimal rate = lotto.rateResult(results, lottoInput.getAmount()); // 수익률  계산 메소드

        lottoOutput.printRate(rate);  // 수익률  ui 메소드


    }
}
