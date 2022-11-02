package lotto;

import java.util.*;

import static java.util.stream.Collectors.toSet;

public class Lotto {
    public static final int LOTTO_NUMBER_TOTAL_COUNT = 6;
    public static final Money PRICE = Money.of(1000);

    private final Set<LottoNumber> lotto;

    private Lotto(Set<LottoNumber> lotto) {
        this.lotto = lotto;
    }

    public static Lotto auto(LottoNumberPickStrategy lottoNumberPickStrategy) {
        return Lotto.of(lottoNumberPickStrategy.pickNumbers());
    }

    public static Lotto manual(List<Integer> numbers) {
        return Lotto.of(numbers);
    }

    private static Lotto of(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        checkNumbersValid(numbersSet);
        return new Lotto(numbers.stream()
                .map(LottoNumber::of)
                .collect(toSet()));
    }

    private static void checkNumbersValid(Set<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_TOTAL_COUNT) {
            throw new IllegalArgumentException(String.format("로또 번호는 중복없이 총 %d개이어야 합니다.", LOTTO_NUMBER_TOTAL_COUNT));
        }
        numbers.forEach(number -> {
            if (number < LottoNumber.MIN_LOTTO_NUMBER || LottoNumber.MAX_LOTTO_NUMBER < number) {
                throw new IllegalArgumentException("로또숫자 범위를 벗어났습니다.");
            }
        });
    }

    public int matchCount(Lotto winning) {
        int count = 0;
        for (LottoNumber lottoNumber : winning.lotto) {
            count += matchCount(lottoNumber);
        }
        return count;
    }

    public int matchCount(LottoNumber lottoNumber) {
        if (lotto.contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }

    public List<LottoNumber> getLotto() {
        return List.copyOf(lotto);
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
