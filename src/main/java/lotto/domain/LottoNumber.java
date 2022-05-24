package lotto.domain;

import java.util.*;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final Map<Integer, LottoNumber> lottoNumberMap = new HashMap<>();
    private static final String LOTTO_NUMBER_FORMAT = "[0-9]*";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final int number;

    private LottoNumber(int number) {
        validateLottoNumber(number);
        this.number = number;
    }

    private void validateLottoNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자 범위에 벗어납니다.");
        }
    }

    public static LottoNumber createNewNumber(String number) {
        if (!number.matches(LOTTO_NUMBER_FORMAT)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 정수만 입력해주세요.");
        }
        return createNewNumber(Integer.parseInt(number));
    }

    public static LottoNumber createNewNumber(int number) {
        return lottoNumberMap.getOrDefault(number, saveLottoNumber(number));
    }

    public static LottoNumber createNewNumber(GenerateNumberStrategy strategy) {
        int newNumber = strategy.generate();
        return lottoNumberMap.getOrDefault(newNumber, saveLottoNumber(newNumber));
    }

    private static LottoNumber saveLottoNumber(int newNumber) {
        return lottoNumberMap.put(newNumber, new LottoNumber(newNumber));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.number - o.number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
