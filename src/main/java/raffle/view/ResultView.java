package raffle.view;

import raffle.lotto.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public void buyLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for(Lotto lotto: lottos){
            System.out.println(lotto.getLottoNumber());
        }
    }
}
