package lotto.domain.core;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static lotto.domain.core.LottoNoValidator.FROM_INDEX;
import static lotto.domain.core.LottoNoValidator.MAX_LOTTO_NO_COUNT;
import static lotto.domain.core.LottoNoValidator.verifyLottoNo;

class Lotto {
    private final Collection<LottoNo> lottoNos;

    private Lotto(Collection<LottoNo> lottoNos) {
        this.lottoNos = lottoNos;
    }

    static Lotto of(Collection<LottoNo> lottoNos) {
        verifyLottoNo(lottoNos);
        return new Lotto(lottoNos);
    }

    static Lotto automaticGenerator(){
        final List<LottoNo> shuffleLottoNos = LottoNo.shuffle();
        final Set<LottoNo> autoLottoNos = new LinkedHashSet<>(MAX_LOTTO_NO_COUNT);
        autoLottoNos.addAll(shuffleLottoNos.subList(FROM_INDEX, MAX_LOTTO_NO_COUNT));
        return of(autoLottoNos);
    }

    long countOfMatch(Lotto otherLotto){
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
