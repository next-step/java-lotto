package lotto.domain;

import java.util.*;

public class LottoNumbersGenerator {

    private static final int FIRST_INDEX = 0;

    private final List<LottoNumber> sourceLottoNumbers;

    private LottoNumbersGenerator(List<LottoNumber> sourceLottoNumbers) {
        this.sourceLottoNumbers = Objects.requireNonNull(sourceLottoNumbers);
    }

    public static LottoNumbersGenerator of(List<LottoNumber> sourceLottoNumbers) {
        return new LottoNumbersGenerator(sourceLottoNumbers);
    }

    public LottoNumbers generate() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        while(lottoNumbers.size() < LottoNumbers.requiredSize()) {
            lottoNumbers.add(pickRandomLottoNumber());
        }
        return LottoNumbers.of(new ArrayList<>(lottoNumbers));
    }

    private LottoNumber pickRandomLottoNumber() {
        Collections.shuffle(sourceLottoNumbers);
        return sourceLottoNumbers.get(FIRST_INDEX);
    }
}
