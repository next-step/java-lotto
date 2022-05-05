package step2.view;

import step2.domain.LottoWinners;
import step2.domain.Rank;

import java.util.List;

public class ResultView {
    public void lottoCount(int number) {
        System.out.println(number + "개를 구매했습니다");
    }

    public void displayLottoNumber(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public void display(LottoWinners winners, double rate) {
        for (Rank rank : winners.ranks()) {
            System.out.println(rank.matchCount + "개 일치" + secondBall(rank) + "(" + rank.price +"원)-" + winners.countByRank(rank) + "개");
        }
        System.out.println("총 수익률은 " + rate + " 입니다");
    }

    private String secondBall(Rank rank) {
        if (rank == Rank.RANK_2)
            return ", 보너스 볼 일치";

        return "";
    }
}
