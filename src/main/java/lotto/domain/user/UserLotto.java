package lotto.domain.user;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.number.LottoNumber;

public class UserLotto {

    public static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<LottoNumber> numbers;

    public UserLotto(List<LottoNumber> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 넘버는 6개여야 합니다.");
        }
    }

    public List<LottoNumber> getNumbers() {
        return new ArrayList<>(numbers);
    }

    private void validateDuplication(List<LottoNumber> numbers) {
        HashSet<Integer> set = numbers.stream()
            .map(LottoNumber::getRaw)
            .collect(Collectors.toCollection(HashSet::new));

        if (set.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 넘버에 중복이 있습니다.");
        }
    }

    public boolean contains(LottoNumber number) {
        return numbers.stream()
            .anyMatch(lottoNumber -> lottoNumber.getRaw() == number.getRaw());
    }
}
