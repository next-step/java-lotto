package lotto;

import static lotto.LottoType.AUTO;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_NUMBERS_LIMIT = 6;

    private LottoType type;
    private final List<LottoNumber> numbers;


    private Lotto(LottoType type, List<LottoNumber> numbers) {
        validLottoSize(numbers);
        validDuplicatedLottoNumber(numbers);
        numbers.sort(Comparator.comparingInt(LottoNumber::getNumber));
        this.type = type;
        this.numbers = numbers;
    }
    public static Lotto of(List<LottoNumber> numbers){
        return new Lotto(AUTO, numbers);
    }

    public static Lotto of(LottoType type, List<LottoNumber> numbers){
        return new Lotto(type, numbers);
    }

    public static Lotto of(LottoType type, String ... numbers){
        return new Lotto(type, Arrays.stream(numbers)
            .map(LottoNumber::new)
            .collect(Collectors.toList()));
    }

    public static Lotto of(String ... numbers){
        return new Lotto(AUTO, Arrays.stream(numbers)
            .map(LottoNumber::new)
            .collect(Collectors.toList()));
    }

    public int countMatch(Lotto other) {
        return (int) numbers.stream()
            .filter(other::contains)
            .count();
    }

    public boolean matchBonus(LottoNumber bonus){
        return numbers.contains(bonus);
    }

    public boolean contains(LottoNumber number){
        return numbers.contains(number);
    }

    private void validLottoSize(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_LIMIT) {
            throw new IllegalArgumentException("로또 하나 당 6개의 숫자를 가져야합니다.");
        }
    }

    private void validDuplicatedLottoNumber(List<LottoNumber> numbers) {
        if ((int) numbers.stream().distinct().count() != LOTTO_NUMBERS_LIMIT) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return type == lotto.type && Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
