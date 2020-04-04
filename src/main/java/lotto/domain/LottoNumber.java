package lotto.domain;

import lotto.generator.LottoNumberGenerator;
import lotto.generator.NumberGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;

    private final int lottoNumber;

    private static final Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

    static {
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    public static LottoNumber newRandomNumber() {
        return lottoNumbers.get(new LottoNumberGenerator().getRandomNumber());
    }

    public static LottoNumber newRandomNumber(NumberGenerator lottoNumberGenerator) {
        return Optional.ofNullable(lottoNumbers.get(lottoNumberGenerator.getRandomNumber()))
                .orElseThrow(IllegalArgumentException::new);
    }

    public static LottoNumber newChooseNumber(int number) {
        return Optional.ofNullable(lottoNumbers.get(number))
                .orElseThrow(IllegalArgumentException::new);
    }

    public static LottoNumber newChooseNumber(String input) {
        return LottoNumber.newChooseNumber(convertNumber(input));
    }

    private LottoNumber(int number) {
        this.lottoNumber = number;
        validateNumberRange(this.lottoNumber);
    }

    public int getLottoNumber() {
        return this.lottoNumber;
    }

    private void validateNumberRange(Integer number) {
        Objects.requireNonNull(number, "로또 번호를 생성하는데 실패했습니다.");
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("로또 숫자 범위를 넘어섰습니다.");
        }
    }

    private static int convertNumber(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
        return number;
    }

    @Override
    public int compareTo(LottoNumber o) {
        if (this.lottoNumber < o.getLottoNumber()) {
            return -1;
        } else if (this.lottoNumber == o.getLottoNumber()) {
            return 0;
        }
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
