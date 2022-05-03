package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.LottoNumber.MAX_VALUE;
import static lotto.domain.LottoNumber.MIN_VALUE;

public class LottoNumbers {
    private static final int ZERO = 0;

    private final List<LottoNumber> lottoNumbers;

    static LottoNumbers generateLottoNumbers(int from, int to) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for (int i = from; i <= to; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }

        return new LottoNumbers(lottoNumbers);
    }

    public static LottoNumbers all() {
        return generateLottoNumbers(MIN_VALUE, MAX_VALUE);
    }

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        if (isNullOrEmpty(lottoNumbers)) {
            throw new IllegalArgumentException("lottoNumbers는 빈 값일 수 없습니다.");
        }

        if (isDuplicated(lottoNumbers)) {
            throw new IllegalArgumentException("lottoNumbers는 중복된 값이 들어갈 수 없습니다.");
        }
    }

    private boolean isNullOrEmpty(List<LottoNumber> lottoNumbers) {
        return lottoNumbers == null || lottoNumbers.isEmpty();
    }

    private boolean isDuplicated(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.size() != lottoNumbers.stream().distinct().count();
    }

    public int size() {
        return lottoNumbers.size();
    }

    public LottoNumbers getRandomNumbers(int size) {
        return this.shuffle().subList(size).sort();
    }

    private LottoNumbers sort() {
        List<LottoNumber> lottoNumbers = getLottoNumbers();
        Collections.sort(lottoNumbers);
        return new LottoNumbers(lottoNumbers);
    }

    private LottoNumbers shuffle() {
        List<LottoNumber> lottoNumbers = getLottoNumbers();
        Collections.shuffle(lottoNumbers);
        return new LottoNumbers(lottoNumbers);
    }

    private LottoNumbers subList(int size) {
        return new LottoNumbers(new ArrayList<>(lottoNumbers.subList(ZERO, size)));
    }

    public int match(LottoNumbers lottoNumbers) {
        List<LottoNumber> matchedNumbers = new ArrayList<>(this.lottoNumbers);
        matchedNumbers.retainAll(lottoNumbers.lottoNumbers);
        return matchedNumbers.size();
    }

    public List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(lottoNumbers);
    }

}
