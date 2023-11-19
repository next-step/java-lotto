package lotto.domain;

import java.util.*;

public class Lotto {
    public static final String INVALID_COUNT = "로또 번호는 6개여야 합니다.";
    public static final int LOTTO_NUMBER_COUNT = 6;

    private Set<LottoNumber> lottoNumbers = new HashSet<>();

    private Lotto(final Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(Integer... number) {
        this(Arrays.asList(number));
    }

    public Lotto(List<Integer> numbers) {
        for (Integer number : numbers) {
            this.lottoNumbers.add(LottoNumber.of(number));
        }
        lottoCountCheck();
    }

    public Lotto(String[] lottoNumberTokens) {
        for (String token : lottoNumberTokens) {
            this.lottoNumbers.add(LottoNumber.of(Integer.valueOf(token.trim())));
        }

        lottoCountCheck();
    }

    public static Lotto auto() {
        return new Lotto(LottoNumberGenerator.generate());
    }

    private void lottoCountCheck() {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_COUNT);
        }
    }

    public int getRightNumber(Lotto lotto) {
        return (int) lottoNumbers.stream()
                .filter(lotto::contains)
                .count();
    }

    public boolean contains(final LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
