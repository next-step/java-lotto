package game.lotto.view;

import game.lotto.model.Amount;
import game.lotto.model.Lotto;

import java.util.List;

public class ResultView {

    public static void printAmount(Amount amount) {
        System.out.println(amount + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(System.out::println);
        System.out.println();
    }
}
