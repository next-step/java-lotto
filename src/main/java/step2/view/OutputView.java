package step2.view;

import java.util.List;

public class OutputView {

    private OutputView() {
    }

    public static void purchaseLotto(int lottoTicketCount) {
        System.out.println(lottoTicketCount + "개를 구매했습니다.");
    }

    public static void printLottoTickets(List<String> lottoNumbersListToString) {
        lottoNumbersListToString.forEach(str -> System.out.println("[ " + str + " ]"));
    }

    public static void printStatics() {
        System.out.println("당첨 통계");
        System.out.println("-------");


    }


}
