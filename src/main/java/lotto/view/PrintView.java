package lotto.view;

import lotto.domain.Lottos;

public class PrintView {

    public static void printNumberOfLotto(int size) {
        System.out.printf("%d개를 구매했습니다.\n", size);
    }

    public static void printLottoNumber(Lottos lottos) {
        lottos.get().stream()
            .forEach(lotto -> System.out.println(lotto.get()));
    }
}
