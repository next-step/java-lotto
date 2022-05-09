package step2.view;

import step2.domain.LottoNumber;
import step2.domain.LottoWinners;
import step2.domain.Lottos;
import step2.domain.Rank;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public void display(LottoWinners winner, int money) {
        for (Rank rank : winner.ranks()) {
            System.out.println(rank.matchCount + "개 일치" + secondBall(rank) + "(" + rank.price +"원)-" + winner.countByRank(rank) + "개");
        }
        System.out.println("총 수익률은 " + winner.rate(money) + " 입니다");
    }

    private String secondBall(Rank rank) {
        if (rank == Rank.RANK_2)
            return ", 보너스 볼 일치";

        return "";
    }

    public void lottoPick(Lottos lottos) {
        for (int i = 0; i < lottos.size(); i++) {
            displayLottoNumber(lottos.numbers(i));
        }
    }

    private void displayLottoNumber(List<LottoNumber> numbers) {
        System.out.println(numbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(", ")));
    }
}
