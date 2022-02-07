package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserLotto {

    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final List<Integer> numberData =
        IntStream.rangeClosed(LottoNumber.LOTTO_FIRST_NUMBER, LottoNumber.LOTTO_LAST_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    private final List<LottoNumber> numbers;

    public UserLotto() {
        this(getLottoNumbers());
    }

    public UserLotto(int... numbers) {
        this(Arrays.stream(numbers).mapToObj(LottoNumber::new).collect(Collectors.toList()));
    }

    public UserLotto(List<LottoNumber> numbers) {
        this.numbers = numbers;
        validateSize();
        validateDuplication();
    }

    private static List<LottoNumber> getLottoNumbers() {
        Collections.shuffle(numberData);
        return numberData.subList(0, LOTTO_NUMBERS_SIZE).stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }

    private void validateSize() {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 넘버는 6개여야 합니다.");
        }
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    private void validateDuplication() {
        if (new HashSet<>(numbers).size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 넘버에 중복이 있습니다.");
        }
    }

    public boolean contains(LottoNumber number) {
        return numbers.stream()
            .anyMatch(lottoNumber -> lottoNumber.getRaw() == number.getRaw());
    }
}
