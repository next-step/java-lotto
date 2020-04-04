package lotto.view;

import lotto.model.Rank;

import java.util.List;

public class ResultView {

    public void print(List<Rank> gameResults) {
//        3등
        System.out.println("3등 " +
                gameResults.stream().filter(result -> result.getRank() == 3).count());
//        2등
        System.out.println("2등 " +
                gameResults.stream().filter(result -> result.getRank() == 2).count());

//        1등
        System.out.println("1등 " +
                gameResults.stream().filter(result -> result.getRank() == 1).count());

    }
}
