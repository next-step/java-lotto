package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class LottoTicket {
    public static final int TICKET_SIZE = 6;
    private final Set<LottoNumber> numbers;

    public LottoTicket(Set<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(Set<LottoNumber> numbers) {
        if (numbers.size() != TICKET_SIZE) {
            throw new IllegalArgumentException("로또는 6개의 번호로 이루어져야합니다");
        }
    }

    public boolean containsLottoNumber(LottoNumber number) {
        return numbers.contains(number);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return new HashSet<>(numbers);
    }
}
