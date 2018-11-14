package lotto.domain;

import java.text.MessageFormat;
import java.util.List;

public class LottoResult {

    private LottoMachine.LottoType lottoType;
    private List<Lotto> lottos;

    private LottoResult(LottoMachine.LottoType lottoType, List<Lotto> lottos) {
        this.lottoType = lottoType;
        this.lottos = lottos;
    }

    public static LottoResult create(LottoMachine.LottoType lottoType, List<Lotto> lottos) {
        return new LottoResult(lottoType, lottos);
    }

    public int reward() {
        return lottoType.getPrice() * lottos.size();
    }

    @Override
    public String toString() {
        int matchCount = lottoType.getMatchCount();
        int price = lottoType.getPrice();
        return MessageFormat.format("{0}개 일치 ({1}원) - {2}개", matchCount, price, lottos.size());
    }
}
