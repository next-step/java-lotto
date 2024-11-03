package lotto.random;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomLottoNumbers implements LottoGenerator {
    @Override
    public List<LottoNumber> executeStrategy() {
        List<Integer> lottoList = new ArrayList<>();
        for ( int i = 1; i <=45; i++) {
            lottoList.add(i);
        }
        Collections.shuffle(lottoList);
        lottoList = lottoList.subList(0,6);
        Collections.sort(lottoList);

        return lottoList.stream().map(i -> new LottoNumber(i)).collect(Collectors.toList());
    }
}
