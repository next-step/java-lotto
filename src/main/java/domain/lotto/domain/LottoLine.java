package domain.lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoLine {
    private static final int LOTTO_LINE_SIZE = 6;
    private final Set<LottoNumber> lottoNumbers;

    public LottoLine(Set<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoLine create(Random random) {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        chooseLottoNumber(random, lottoNumbers);
        return new LottoLine(lottoNumbers);
    }

    private static void chooseLottoNumber(Random random, Set<LottoNumber> lottoNumbers) {
        while (lottoNumbers.size() < LOTTO_LINE_SIZE) {
            LottoNumber lottoNumber = LottoNumber.from(random);
            lottoNumbers.add(lottoNumber);
        }
    }


    private void validateLottoNumbers(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_LINE_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public String getLine() {
        List<Integer> sortedNumbers = lottoNumbers.stream()
                .sorted(Comparator.comparingInt(LottoNumber::getNumber))
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());

        return sortedNumbers.toString();

    }

}

