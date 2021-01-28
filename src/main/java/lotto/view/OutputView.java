package lotto.view;

import lotto.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private static final String BUY_MSG = "구입금액을 입력해 주세요.";
    private static final String AFTER_BUY_MSG = "개를 구매했습니다.";
    private static final String LOTTO_NUMBERS_MSG = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MSG = "보너스 볼을 입력해 주세요.";
    private static final String RESULT_TITLE_MSG = "당첨 통계";
    private static final String RESULT_DELIMITER_MSG = "---------";

    private static final int[] PRIZE_REWARDS = {
        5000, 50_000, 1_500_000, 30_000_000, 2_000_000_000
    };
    // 구매 메시지
    public static void printBuy () {
        System.out.println(BUY_MSG);
    }
    public static void printBuyerTickets (int amount) {
        System.out.printf("%d%s\n", amount, AFTER_BUY_MSG);
    }
    // 구매자 로또 정보 메시지
    public static void printBuyTicketsNumbers (List<LottoTicket> tickets) {
        List<Integer> ticketNumbers;
        for(LottoTicket ticket : tickets) {
            ticketNumbers = ticket.getLottoNumbers();
            printOneTicketNumbers(ticketNumbers);
        }
    }
    // 로또 한 장의 정보 출력
    private static void printOneTicketNumbers (List<Integer> ticketNumbers) {
        StringBuilder ticketString = new StringBuilder("[");
        for(Integer ticketNumber : ticketNumbers) {
            ticketString.append(Integer.toString(ticketNumber));
            ticketString.append(",");
        }
        ticketString.deleteCharAt(ticketString.lastIndexOf(",")-1);
        ticketString.append("]");
        System.out.println(ticketString);
    }

    // 로또 당첨 번호 메시지지
    public static void printLottoMsg () {
        System.out.println(LOTTO_NUMBERS_MSG);
    }

    // 로또 당첨 번호 출력
    public static void printLottoNumbers (LottoTicket lotto) {
        StringBuilder lottoString = new StringBuilder();
        List<Integer> lottoNumbers = lotto.getLottoNumbers();
        for(Integer lottoNumber : lottoNumbers) {
            lottoString.append(Integer.toString(lottoNumber));
            lottoString.append(",");
        }
        lottoString.deleteCharAt(lottoString.lastIndexOf(",")-1);
        System.out.println(lottoString);
    }
    // 로또 보너스 번호 메시
    public static void printBonusMsg () {
        System.out.println(BONUS_NUMBER_MSG);
    }
    // 로또 보너스 번호 출력
    public static void printBonusNumber (LottoTicket lotto) {
        Integer bonus = lotto.getBonusNumber().getLottoNumber();
        System.out.println(bonus);
    }
    // 로또 당첨 결과 메시지
    public static void printResult() {
        System.out.println(RESULT_TITLE_MSG);
        System.out.println(RESULT_DELIMITER_MSG);
    }
    public static void printResult(List<Integer> result) {
        for(int i=0; i<result.size(); i++){
            // TODO : if i == 3, it is match 5 and bonus.
            if(i==3){
                System.out.printf("%d개 일치 (%d원) - %d개\n",i+3,PRIZE_REWARDS[i],result.get(i));
            }
            else {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%d원) - %d개\n",i+3,PRIZE_REWARDS[i],result.get(i));
            }
        }
    }
    public static void printRevenue(Double resRevenue) {
        System.out.printf("총 수익률은 %f 입니다.", resRevenue);
    }

}
