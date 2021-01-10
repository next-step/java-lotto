package lotto.domain;

import java.util.*;

public class LottoNumber {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    public static final int LOTTO_LENGTH = 6;
    public static Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();
    private final int number;

    static {
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        return Optional.ofNullable(lottoNumbers.get(number))
                .orElseThrow(IllegalArgumentException::new);
    }

    public static LottoNumber of(String number) {
        return Optional.ofNullable(lottoNumbers.get(Integer.parseInt(number)))
                .orElseThrow(IllegalArgumentException::new);
    }

    public static List<Integer> makeLotto() {
        List<Integer> autoLottoNumbers = new ArrayList<>();
        lottoNumbers.forEach((number, lotto) -> autoLottoNumbers.add(number));

        Collections.shuffle(autoLottoNumbers);
        List<Integer> numbers = new ArrayList<>(autoLottoNumbers.subList(0, LOTTO_LENGTH));
        Collections.sort(numbers);

        return numbers;
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

    public int getNumber() {
        return number;
    }
}
