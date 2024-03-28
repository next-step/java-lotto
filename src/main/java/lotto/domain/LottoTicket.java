package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    private final List<LottoNumber> numbers;

    public static LottoTicket createTicket(List<Integer> inputs) {
        List<LottoNumber> lottoNumbers = inputs.stream()
            .sorted()
            .map(LottoNumber::new)
            .collect(Collectors.toUnmodifiableList());
        return new LottoTicket(lottoNumbers);
    }

    private LottoTicket(List<LottoNumber> inputs) {
        checkSizeNumbers(inputs);
        checkUniqueNumbers(inputs);
        this.numbers = inputs;
    }

    private static void checkUniqueNumbers(List<LottoNumber> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("중복 값은 입력할 수 없습니다.");
        }
    }

    private static void checkSizeNumbers(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 생성을 위해서는 6개의 숫자가 필요합니다.");
        }
    }

    public LottoPrice getPrice(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        return LottoPrice.valueOf(matchNumberCount(winningNumbers), matchBonusNumber(bonusNumber));
    }

    private int matchNumberCount(List<LottoNumber> winningNumbers) {
        return (int) winningNumbers.stream().filter(this.numbers::contains).count();
    }

    private boolean matchBonusNumber(LottoNumber number) {
        return number.match(numbers);
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
