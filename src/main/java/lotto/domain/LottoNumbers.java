package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers implements Iterable<LottoNumber> {

    private static final int MAX_LOTTO_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers generate() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = LottoNumber.MIN_LOTTO_NUMBER; i <= LottoNumber.MAX_LOTTO_NUMBER; i++) {
            lottoNumbers.add(LottoNumber.of(i));
        }
        Collections.shuffle(lottoNumbers);
        return new LottoNumbers(lottoNumbers.stream()
                .limit(MAX_LOTTO_COUNT)
                .collect(Collectors.toList()));
    }

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public Iterator<LottoNumber> iterator() {
        return lottoNumbers.iterator();
    }
}
