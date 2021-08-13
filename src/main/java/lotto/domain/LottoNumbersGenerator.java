package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoNumbersGenerator {

    private static final int FIRST_LOTTO_NUMBER = 0;

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
        return sourceLottoNumbers.get(FIRST_LOTTO_NUMBER);
    }

    public List<LottoNumbers> generate(long quantity) {
        return Stream.generate(this::generate)
                .limit(quantity)
                .collect(Collectors.toList());
    }
}
