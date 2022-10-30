package lotto.domain;

import lotto.util.LottoNumberGenerator;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    private static final String SPLIT_COMMA_SPACE = "[ ,]+";
    private static final int LOTTO_MAX_RANGE = 6;

    private final Set<LottoNumber> lotto;

    // 수동 로또 생성
    public Lotto(String numberString) {
        this.lotto = new HashSet<>(toList(numberString));
        verifySize(lotto);
    }

    // 자동 로또 생성
    public Lotto() {
        Set<LottoNumber> lotto = new HashSet<>();
        while (lotto.size() < LOTTO_MAX_RANGE) {
            lotto.add(LottoNumber.of(LottoNumberGenerator.generateNumber()));
        }
        this.lotto = lotto;
    }

    private List<LottoNumber> toList(String numberString) {
        String[] splitNumbers = numberString.split(SPLIT_COMMA_SPACE);
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for (String value : splitNumbers) {
            lottoNumbers.add(LottoNumber.of(Integer.parseInt(value)));
        }
        return lottoNumbers;
    }

    private void verifySize(Set<LottoNumber> lotto) {
        if (lotto.size() != LOTTO_MAX_RANGE) {
            throw new IllegalArgumentException("6개의 숫자를 입력해야 합니다.");
        }
    }

    public int match(Lotto numbers) {
        int count = 0;

        for (LottoNumber lottoNumber : lotto) {
            if (numbers.contains(lottoNumber)) {
                count += 1;
            }
        }
        return count;
    }

    public boolean isMatch(LottoNumber bonusBall) {
        return contains(bonusBall);
    }

    private boolean contains(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    public String toString() {
        return lotto.stream().map(LottoNumber::getNumberByString)
                .collect(Collectors.joining(", "));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }
}
