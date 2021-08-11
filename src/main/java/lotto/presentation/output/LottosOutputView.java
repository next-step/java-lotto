package lotto.presentation.output;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.List;

public class LottosOutputView {
    public void output(Lottos lottos){
        List<Lotto> lottosElements = lottos.getElements();
        lottosElements.forEach(System.out::println);
    }
}
