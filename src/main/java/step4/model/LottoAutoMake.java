package step4.model;

import java.util.ArrayList;
import java.util.List;

public class LottoAutoMake {

    private final LottoCount lottoCount;

    public LottoAutoMake(LottoCount lottoCount) {
        this.lottoCount = lottoCount;
    }

    public List<Lotto> makeAutoLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i=0; i < this.lottoCount.getCount(); i++) {
            lottos.add(new Lotto(new LottoNumbers(LottoNumber.getShufflingNumbers())));
        }

        return lottos;
    }
}
