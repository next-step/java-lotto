package auto_lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoVendingMachine {


    private final static int lottoPrice = 1000;
    List<LottoTicket> lottoTickets = new ArrayList<>();

    //구매전략
    public List<LottoTicket> receive(int money) {
        return generate(getNumberOfLotto(money));
    }

    public int getNumberOfLotto(int money) {
        return money / lottoPrice;
    }

    //로또 생성
    private List<LottoTicket> generate(int quantity) {
        for (int i = 0; i < quantity; i++) {
            lottoTickets.add(new LottoTicket(new RandomNumber()));
        }
        return lottoTickets;
    }


    public List<WinningStatistic> checkIfWinningEntry(List<Integer> winingNumberOfLastWeek) {
        List<WinningStatistic> winningStatistics = new ArrayList<>();

        for (LottoTicket lottoTicket : lottoTickets) {
            //몇개 일치
            int result = getNumberOfMatch(winingNumberOfLastWeek, lottoTicket.numbers);

            //결과
            winningStatistics.add(WinningStatistic.getByMatches(result));
        }

        return winningStatistics;
    }

    public static int getNumberOfMatch(List<Integer> winingNumberOfLastWeek, List<Integer> userNumber) {
        return (int) winingNumberOfLastWeek.stream()
                .filter(userNumber::contains)
                .count();
    }
}
