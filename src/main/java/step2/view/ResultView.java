package step2.view;

import step2.model.LottoTickets;

import java.util.List;

public class ResultView {

    private ResultView() {
    }

    public static void printTickets(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.getCount() + "장을 구매했습니다.");
        lottoTickets.getNumberGroups()
                .forEach(t -> System.out.println(t.toString()));
    }

    public static void printWinningStatistics(LottoTickets lottoTickets,  List<Integer> winningNumbers) {

    }
}
