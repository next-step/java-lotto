package lotto.dto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.List;

public class MyLottos {
    private final List<MyLotto> lottosResult;

    private MyLottos(List<MyLotto> myLottoList) {
        this.lottosResult = myLottoList;
    }

    public static MyLottos of(Lottos lottos) {
        List<MyLotto> myLottos = new ArrayList<>();

        for (Lotto lotto : lottos.getLottos()) {
            myLottos.add(MyLotto.of(lotto));
        }

        return new MyLottos(myLottos);
    }

    public List<MyLotto> getLottosResult() {
        return this.lottosResult;
    }

    public int size() {
        return lottosResult.size();
    }
}
