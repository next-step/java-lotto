package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.stream().map(Lotto::getNumbers).forEach(System.out::println);
    }
}
