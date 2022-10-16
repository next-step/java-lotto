package autoLotto;

import static java.util.stream.IntStream.*;

public class OutputView {

    public void outputQuantity(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public void outputLottos(Lottos lottos) {

        range(0, lottos.getLottosSize())
                 .forEach(i -> System.out.println(lottos.getLotto(i)));
    }
}
