package step2.view;

import step2.model.Rank;

import java.util.List;
import java.util.Map;

public class ResultView {
    public void showLotto(List<List<Integer>> lottoList) {
        for (List<Integer> lotto : lottoList) {
            System.out.println(lotto);
        }

        System.out.println();
    }

    public void showResult(Map<Rank, Integer> result, String winningRate) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        
        for (Rank rank : Rank.values()) {
            getMessage(result, rank);
        }
        System.out.println("총 수익률은 "+ winningRate +"입니다.");
    }

    private void getMessage(Map<Rank, Integer> result, Rank rank) {
        int countOfMatch = rank.getCountOfMatch();
        int winningPrice = rank.getWinningPrice();

        if (rank.equals(rank.SECOND)) {
            System.out.println(countOfMatch + "개 일치, 보너스 볼 일 (" + winningPrice + ")-" + result.get(rank) + "개");
            return;
        }

        if (!rank.equals(rank.MISS)) {
            System.out.println(countOfMatch + "개 일치 (" + winningPrice + ")-" + result.get(rank) + "개");
        }

    }
}
