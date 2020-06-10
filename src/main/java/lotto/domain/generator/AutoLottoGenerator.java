package lotto.domain.generator;

import lotto.domain.data.LottoNumberPool;
import lotto.domain.data.Lotto;
import lotto.domain.data.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AutoLottoGenerator {

    private static List<LottoNumber> createRandomLottoNumbers() {
        List<LottoNumber> lottoNumberAll = LottoNumberPool.getAll();
        Collections.shuffle(lottoNumberAll);
        return lottoNumberAll.stream().limit(Lotto.LOTTO_NUMBER_COUNT).collect(Collectors.toList());
    }

    public static List<Lotto> generate(int autoLottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0 ; i < autoLottoCount ; i++) {
            lottos.add(Lotto.of(createRandomLottoNumbers()));
        }
        return lottos;
    }
}
