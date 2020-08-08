package camp.nextstep.edu.rebellion.lotto.domain.ticket;

import camp.nextstep.edu.rebellion.lotto.rule.LottoGameRule;
import camp.nextstep.edu.rebellion.lotto.util.StringUtil;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private static final int WIN = 1;
    private static final int LOSE = 0;

    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        checkCount(numbers.size());
        checkDuplicate(numbers.stream());
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
        if(LottoGameRule.getLottoCount() != size) {
            throw new IllegalArgumentException("로또 번호 개수가 6개가 아닙니다");
        }
    }

    private void checkDuplicate (final Stream<LottoNumber> stream) {
        final Set<LottoNumber> seen = new HashSet<>();
        if (!stream.allMatch(seen::add)) {
            throw new IllegalArgumentException("중복된 번호가 있습니다");
        }
    }
}
