package lotto.view;

import lotto.common.Outer;
import lotto.domain.BoughtLottos;

public class ResultView {
    private Outer outer;

    public ResultView(Outer outer) {
        this.outer = outer;
    }
    
    public void printLottos(BoughtLottos lottos) {
        outer.print(lottos.toString());        
    }
}
