package lotto;

import lotto.domain.Game;
import lotto.view.InputView;

import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        int price = InputView.inputPrice();
        List<Integer> winNumbers = InputView.inputWinNumbers();

        Game game = new Game(price / 1000);
        Map<Integer, Integer> result = game.play(winNumbers);
    }
}
