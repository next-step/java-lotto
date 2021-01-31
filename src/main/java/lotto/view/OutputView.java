package lotto.view;

import lotto.wrapper.Count;
import lotto.wrapper.InputString;
import lotto.wrapper.Money;
import lotto.domain.LottoTicket;
import lotto.wrapper.OutputString;

import java.util.Arrays;
import java.util.List;

public class OutputView {
    private static final List<Money> PRIZE_REWARDS =
            Arrays.asList(new Money(5000),
                    new Money(50_000),
                    new Money(1_500_000),
                    new Money(30_000_000),
                    new Money(2_000_000_000));

    // 구매 메시지
    public static void printBuy() {
        Constants.BUY_MSG.print();
    }

    public static void printBuyerTickets(Count amount) {
        System.out.printf("%d", amount.getCount());
        Constants.AFTER_BUY_MSG.print();
    }

    // 구매자 로또 정보 메시지
    public static void printBuyTicketsNumbers(List<LottoTicket> tickets) {
        List<Integer> ticketNumbers;
        for (LottoTicket ticket : tickets) {
            ticketNumbers = ticket.getLottoNumbers();
            printOneTicketNumbers(ticketNumbers);
        }
    }

    // 로또 한 장의 정보 출력
    private static void printOneTicketNumbers(List<Integer> ticketNumbers) {
        StringBuilder ticketString = new StringBuilder("[");
        for (Integer ticketNumber : ticketNumbers) {
            ticketString.append(Integer.toString(ticketNumber));
            ticketString.append(",");
        }
        ticketString.deleteCharAt(ticketString.lastIndexOf(","));
        ticketString.append("]");
        System.out.println(ticketString);
    }

    // 로또 당첨 번호 메시지지
    public static void printLottoMsg() {
        Constants.LOTTO_NUMBERS_MSG.print();
    }

    // 로또 당첨 번호 출력
    public static void printLottoNumbers(LottoTicket lotto) {
        StringBuilder lottoString = new StringBuilder();
        List<Integer> lottoNumbers = lotto.getLottoNumbers();
        for (Integer lottoNumber : lottoNumbers) {
            lottoString.append(Integer.toString(lottoNumber));
            lottoString.append(",");
        }
        lottoString.deleteCharAt(lottoString.lastIndexOf(","));
        System.out.println(lottoString);
    }

    // 로또 보너스 번호 메시
    public static void printBonusMsg() {
        Constants.BONUS_NUMBER_MSG.print();
    }

    // 로또 보너스 번호 출력
    public static void printBonusNumber(LottoTicket lotto) {
        Integer bonus = lotto.getBonusNumber().getLottoNumber();
        System.out.println(bonus);
    }

    public static void printResult(List<Count> result) {
        for (int i = 0; i < result.size(); i++) {
            printOnce(result, i);
        }
    }

    public static void printOnce(List<Count> result, int i) {
        if (i == 3) {
            System.out.printf("%d개 일치 (%d원) - %d개\n", i + 3, PRIZE_REWARDS.get(i).getMoney(), result.get(i).getCount());
        } else {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%d원) - %d개\n", i + 3, PRIZE_REWARDS.get(i).getMoney(), result.get(i).getCount());
        }
    }

    public static void printRevenue(Double resRevenue) {
        Constants.RESULT_TITLE_MSG.print();
        Constants.RESULT_DELIMITER_MSG.print();
        System.out.printf("총 수익률은 %f 입니다.", resRevenue);
    }

}
