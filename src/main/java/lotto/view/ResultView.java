package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Person;

public class ResultView {

    public static void println(String message) {
        System.out.println(message);
    }

    public static void printMyLottos(Person person) {
        int purchasedLotto = person.getNumberOfLotto();
        System.out.printf("%d개를 구매했습니다.\n", purchasedLotto);
        for (Lotto lotto : person.getLottos()) {
            System.out.println(lotto.toString());
        }
    }
 }
