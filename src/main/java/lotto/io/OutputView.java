package lotto.io;

import lotto.model.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void viewLotto(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers().stream().map(Object::toString).collect(Collectors.joining(","))));
    }
}
