package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class ConsoleResultView implements ResultView{
    @Override
    public void lottos(Lottos lottos) {
        for (Lotto lotto : lottos.lottos()) {
            System.out.println(lotto.lotto());
        }
    }
}
