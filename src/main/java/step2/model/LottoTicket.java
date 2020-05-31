package step2.model;

import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private static final int ALLOWED_LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> numbers;

    private LottoTicket(List<LottoNumber> numbers) {
        if (isInvalidCount(numbers)) {
            throw new IllegalArgumentException("로또 번호는 6개만 입력 가능합니다.");
        }

        this.numbers = numbers;
    }

    private boolean isInvalidCount(List<LottoNumber> numbers) {
        return numbers == null || numbers.size() != ALLOWED_LOTTO_NUMBER_COUNT;
    }

    public static LottoTicket create(List<LottoNumber> lottoNumbers) {
        return new LottoTicket(lottoNumbers);
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(this.numbers);
    }

    public int getMatchCount(List<Integer> winningNumbers) {
        return Math.toIntExact(this.numbers.stream()
                .map(LottoNumber::getValue)
                .filter(winningNumbers::contains)
                .count());
    }
}
