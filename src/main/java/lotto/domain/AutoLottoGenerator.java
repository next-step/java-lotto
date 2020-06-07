package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AutoLottoGenerator implements LottoGenerator {

    private int lottoCount;

    public AutoLottoGenerator(int count) {
        lottoCount = count;
    }

    private List<LottoNumber> createRandomLottoNumbers() {
        List<LottoNumber> lottoNumberAll = LottoNumberPool.getAll();
        Collections.shuffle(lottoNumberAll);
        return lottoNumberAll.stream().limit(Lotto.LOTTO_NUMBER_COUNT).collect(Collectors.toList());
    }

    @Override
    public List<Lotto> generator() {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0 ; i < lottoCount ; i++) {
            lottos.add(Lotto.of(createRandomLottoNumbers()));
        }
        return lottos;
    }
}
