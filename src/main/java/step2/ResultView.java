package step2;

import java.util.List;

public class ResultView {
    public void print(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.print(lotto.toString());
            System.out.println("");
        }
    }
}
