package view;

import lotto.domain.Games;

public class OutputView {

    private static final OutputView instance = new OutputView();

    private OutputView() {}

    public static OutputView getInstance() {
        return instance;
    }

    public void printCalculationResult(int result) {
        System.out.println("계산 결과 : " + result);
    }

    public void printPurchasedGames(Games games) {
        System.out.println(games.count() + "개를 구매했습니다.");
        System.out.println(games);
    }
}
