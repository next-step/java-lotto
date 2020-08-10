package camp.nextstep.edu.rebellion.lotto.domain.ticket;

import camp.nextstep.edu.rebellion.lotto.rule.LottoGameRule;
import camp.nextstep.edu.rebellion.lotto.util.StringUtil;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_COUNT = LottoGameRule.getLottoCount();
    private static final int WIN = 1;
    private static final int LOSE = 0;

    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        checkCount(numbers.size());
        checkDuplicate(numbers);
        this.numbers = numbers;
    }

    public Lotto (String input) {
        this (
            StringUtil.convertList(input)
                    .stream()
                    .map(LottoNumber::new)
                    .collect(Collectors.toList())
        );
    }

    public int getMatchCount(Lotto lotto) {
        return this.numbers
                .stream()
                .mapToInt(number -> lotto.contain(number) ? WIN : LOSE)
                .sum();
    }

    public boolean contain(LottoNumber number) {
        return this.numbers
                .stream()
                .anyMatch(n -> n.equals(number));
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void checkCount(int size) {
        if (LOTTO_COUNT != size) {
            throw new IllegalArgumentException("로또 번호 개수가 6개가 아닙니다");
        }
    }

    private void checkDuplicate (List<LottoNumber> numbers) {
        final Set<LottoNumber> set = new HashSet<>(numbers);
        if (LOTTO_COUNT != set.size()) {
            throw new IllegalArgumentException("중복된 번호가 있습니다");
        }
    }
}
