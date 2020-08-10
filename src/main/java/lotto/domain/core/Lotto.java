package lotto.domain.core;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import static java.util.stream.Collectors.toCollection;
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

    public int countOfMatch(Lotto otherLotto){
        long count = lottoNos.stream()
                             .filter(otherLotto::contains)
                             .count();
        return Math.toIntExact(count);
    }

    boolean contains(LottoNo lottoNo){
        return lottoNos.contains(lottoNo);
    }

    int size(){
        return lottoNos.size();
    }

    public Set<Integer> getPrimitiveLottoNos(){
        return lottoNos.stream()
            .map(LottoNo::getLottoNo)
            .collect(toCollection(LinkedHashSet::new))
            ;
    }
}
