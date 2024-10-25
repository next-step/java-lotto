package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {

    public static void renderingLottos(List<Lotto> lottos){
        System.out.println(String.format("%d개를 구매했습니다.",lottos.size()));
        for(Lotto lotto: lottos){
            System.out.println(lotto);
        }
    }
}
