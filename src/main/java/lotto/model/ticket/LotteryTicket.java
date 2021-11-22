package lotto.model.ticket;

import lotto.model.domain.Lotto;
import lotto.model.game.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class LotteryTicket {

    private final List<Lotto> numbers;

    public LotteryTicket(List<Lotto> chosenNumbers) {
        checkDuplicate(chosenNumbers);
        checkNumbersSize(chosenNumbers);
        this.numbers = chosenNumbers;
    }

    public List<Lotto> getNumbers() {
        return numbers;
    }

    public String print() {
        List<String> list = numbers.stream().map(Lotto::print).collect(Collectors.toList());
        return "[" + String.join(", ", list) + "]";
    }

    public boolean match(Lotto number) {
        return this.numbers.contains(number);
    }

    private void checkDuplicate(List<Lotto> numbers) {
        if(numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 번호가 있습니다.");
        }
    }

    private void checkNumbersSize(List<Lotto> numbers) {
        if(numbers.size() != LottoNumber.CHOOSE_COUNT) {
            throw new IllegalArgumentException("6개 번호가 선택되어야 합니다.");
        }
    }
}