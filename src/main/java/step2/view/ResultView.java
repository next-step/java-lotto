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
        for (Rank rank : Rank.values()) {
            System.out.println(rank.matchNum + "개 일치" + "(" + rank.price +"원)-" + winners.count(rank) + "개");
        }
        System.out.println("총 수익률은 " + String.format("%.2f", rate) + "% 입니다");
    }
}
