package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MyLottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public MyLottos(List<Lotto> lottos) {
        this.lottos.addAll(lottos);
    }

    public static MyLottos of(List<Lotto>... lottosList) {
        return new MyLottos(Arrays.stream(lottosList)
                .flatMap(List::stream).collect(Collectors.toList()));
    }


    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(this.lottos);
    }

    public void addManualLottos(MyLottos myLottos) {
        this.lottos.addAll(myLottos.lottos);
    }

    public LottoResult getLottoResult(WinningLotto winningLotto) {
        LottoResult lottoResult = new LottoResult();
        lottos.forEach(lotto -> lottoResult.add(winningLotto.getPrize(lotto)));
        return lottoResult;
    }
}
