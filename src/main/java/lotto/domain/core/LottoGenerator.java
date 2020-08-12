package lotto.domain.core;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static lotto.domain.core.LottoNoValidator.FROM_INDEX;
import static lotto.domain.core.LottoNoValidator.MAX_LOTTO_NO_COUNT;
import static lotto.domain.core.LottoNoValidator.verifyRequireNonNull;

public class LottoGenerator {

    public static Lotto from(int... primitiveLottoNos){
        return fromPrimitiveIntArrays(primitiveLottoNos);
    }

    public static Lotto fromPrimitiveIntArrays(int[] primitiveLottoNos){
        verifyRequireNonNull(primitiveLottoNos);

        final List<LottoNo> lottoNos = Arrays.stream(primitiveLottoNos)
                                             .mapToObj(LottoNo::valueOf)
                                             .collect(toList())
            ;
        return Lotto.of(lottoNos);
    }

    public static Lotto fromIntSet(Set<Integer> intLottoNoSet){
        verifyRequireNonNull(intLottoNoSet);

        final Set<LottoNo> lottoNos = intLottoNoSet.stream()
                                                   .map(LottoNo::valueOf)
                                                   .collect(Collectors.toCollection(LinkedHashSet::new))
            ;
        return Lotto.of(lottoNos);
    }

    public static Lotto fromIntList(List<Integer> intLottoNoList){
        verifyRequireNonNull(intLottoNoList);

        final List<LottoNo> lottoNos = intLottoNoList.stream()
                                                     .map(LottoNo::valueOf)
                                                     .collect(toList())
            ;
        return Lotto.of(lottoNos);
    }

    public static Lotto automatic(){
        final List<LottoNo> shuffleLottoNos = LottoNo.shuffle();
        final Set<LottoNo> autoLottoNos = new LinkedHashSet<>(MAX_LOTTO_NO_COUNT);
        autoLottoNos.addAll(shuffleLottoNos.subList(FROM_INDEX, MAX_LOTTO_NO_COUNT));
        return Lotto.of(autoLottoNos);
    }

    public static WinLotto winLotto(Lotto lotto){
        return new WinLotto(lotto,LottoNo.empty());
    }

    public static WinLotto winLotto(Lotto lotto, int bonusNo){
        return new WinLotto(lotto,LottoNo.valueOf(bonusNo));
    }

}
