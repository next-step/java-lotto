package lottos.controller;

import lottos.domain.Lotto;
import lottos.domain.Lottos;


public class ConsoleOutputView {

    public void print(Lottos lottos) {
        for (Lotto lotto : lottos.getElements()) {
            System.out.println(lotto.getElements());
        }
        System.out.println();
    }
}
