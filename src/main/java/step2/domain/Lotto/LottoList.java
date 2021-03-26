package step2.domain.Lotto;

import java.util.List;

public class LottoList {

    private final List<Lotto> lottoList;

    private LottoList(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public static LottoList newInstance(List<Lotto> lottoList) {
        return new LottoList(lottoList);
    }
}
