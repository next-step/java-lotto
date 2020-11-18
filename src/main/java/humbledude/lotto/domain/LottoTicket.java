package humbledude.lotto.domain;

import java.util.Set;

public class LottoTicket {
    public static final int LOTTO_SIZE_OF_NUMBERS = 6;

    private final Set<LottoNumber> numbers;

    public LottoTicket(Set<LottoNumber> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public Set<LottoNumber> getNumbers() {
        return numbers;
    }

    private void validateNumbers(Set<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_SIZE_OF_NUMBERS) {
            throw new IllegalArgumentException("로또는 겹치지 않는 6개 숫자로만 만들수 있어요");
        }
    }
}
