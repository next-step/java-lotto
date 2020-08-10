package lotto.domain.core;

import java.util.Collection;

import static lotto.domain.core.LottoNoValidator.verifyLottoNo;

public class Lotto {
    private final Collection<LottoNo> lottoNos;

    private Lotto(Collection<LottoNo> lottoNos) {
        this.lottoNos = lottoNos;
    }

    static Lotto of(Collection<LottoNo> lottoNos) {
        verifyLottoNo(lottoNos);
        return new Lotto(lottoNos);
    }

    public long countOfMatch(Lotto otherLotto){
        return lottoNos.stream()
                       .filter(otherLotto::contains)
                       .count()
            ;
    }

    boolean contains(LottoNo lottoNo){
        return lottoNos.contains(lottoNo);
    }

    int size(){
        return lottoNos.size();
    }
}
