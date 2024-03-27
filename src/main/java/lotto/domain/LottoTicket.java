package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    private List<LottoNumber> numbers;

    public static LottoTicket createTicket(List<Integer> inputs) {
        return new LottoTicket(Collections.unmodifiableList(
            inputs.stream().sorted().map(input -> new LottoNumber(input))
                .collect(Collectors.toList())));
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

    public int count(List<LottoNumber> numbers) {
        return (int) numbers.stream().filter(this.numbers::contains).count();
    }

    private static void checkSizeNumbers(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 생성을 위해서는 6개의 숫자가 필요합니다.");
        }
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
