package domain.lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoLine {
    private static final Random RANDOM = new Random();
    private static final int LOTTO_LINE_SIZE = 6;
    private final Set<LottoNumber> lottoNumbers;

    public LottoLine(Set<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = Collections.unmodifiableSet(lottoNumbers);
    }

    public static LottoLine create() {
        Set<LottoNumber> lottoNumbers = chooseLottoNumber();
        return new LottoLine(lottoNumbers);
    }

    public static LottoLine create(Set<LottoNumber> lottoNumbers) {
        return new LottoLine(lottoNumbers);
    }

    private static Set<LottoNumber> chooseLottoNumber() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();

        while (lottoNumbers.size() < LOTTO_LINE_SIZE) {
            LottoNumber lottoNumber = LottoNumber.from(RANDOM);
            lottoNumbers.add(lottoNumber);
        }
        return Collections.unmodifiableSet(lottoNumbers);
    }

    private void validateLottoNumbers(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_LINE_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    public Set<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableSet(new HashSet<>(lottoNumbers));
    }

    public String getLine() {
        List<Integer> sortedNumbers = lottoNumbers.stream()
                .sorted(Comparator.comparingInt(LottoNumber::getNumber))
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());

        return sortedNumbers.toString();

    }
}

