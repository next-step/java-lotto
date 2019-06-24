package lotto.view;

import lotto.common.Outer;
import lotto.domain.Lottos;

public class ResultView {
    private Outer outer;

    public ResultView(Outer outer) {
        this.outer = outer;
    }
    
    public void printLottos(Lottos lottos) {
        outer.print(lottos.toString());        
    }
}
