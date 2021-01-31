package lotto.view;

import lotto.wrapper.Count;
import lotto.wrapper.Money;
import lotto.domain.LottoTicket;
import lotto.wrapper.OutputString;

import java.util.Arrays;
import java.util.List;

public class OutputView {
    private static final OutputString BUY_MSG = new OutputString("구입금액을 입력해 주세요.");
    private static final OutputString AFTER_BUY_MSG = new OutputString("개를 구매했습니다.");
    private static final OutputString LOTTO_NUMBERS_MSG = new OutputString("지난 주 당첨 번호를 입력해 주세요.");
    private static final OutputString BONUS_NUMBER_MSG = new OutputString("보너스 볼을 입력해 주세요.");
    private static final OutputString RESULT_TITLE_MSG = new OutputString("당첨 통계");
    private static final OutputString RESULT_DELIMITER_MSG = new OutputString("---------");
    private static final List<Money> PRIZE_REWARDS =
            Arrays.asList(new Money(5000),
                    new Money(50_000),
                    new Money(1_500_000),
                    new Money(30_000_000),
                    new Money(2_000_000_000));

    // 구매 메시지
    public static void printBuy() {
        BUY_MSG.print();
    }

    public static void printBuyerTickets(Count amount) {
        System.out.printf("%d", amount.getCount());
        AFTER_BUY_MSG.print();
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
        LOTTO_NUMBERS_MSG.print();
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
        BONUS_NUMBER_MSG.print();
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
        RESULT_TITLE_MSG.print();
        RESULT_DELIMITER_MSG.print();
        System.out.printf("총 수익률은 %f 입니다.", resRevenue);
    }

}
