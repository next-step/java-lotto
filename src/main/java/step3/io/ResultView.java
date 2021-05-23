package step3.io;

import java.util.List;
import java.util.Map;

import step3.constant.Rank;

public interface ResultView {

    void showInputPrice();

    void showText(String message);

    void buyCount(int size);

    void showTotalLotto(List<List<Integer>> lotto);

    void showInputVictoryNumber();

    void showEmptyLine();

    void showWinning(Map<Rank, Long> map);

    void showBenefit(String benefit);

}
