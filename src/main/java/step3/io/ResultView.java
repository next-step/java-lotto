package step3.io;

import java.util.List;

public interface ResultView {

    void showInputPrice();

    void showText(String message);

    void buyCount(int size);

    void showTotalLotto(List<List<Integer>> lotto);

    void showInputVictoryNumber();

    void showEmptyLine();

    void showWinning(List<Integer> winningWithNumbers);

    void showBenefit(String benefit);

}
