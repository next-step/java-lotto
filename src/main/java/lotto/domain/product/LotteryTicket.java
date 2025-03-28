package lotto.domain.product;

import lotto.domain.Money;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.view.output.OutputView.NUMBER_OUTPUT_DELIMITER;
import static lotto.view.output.OutputView.OUTPUT_PREFIX;
import static lotto.view.output.OutputView.OUTPUT_SUFFIX;

public class LotteryTicket implements Product {

    private static final int LOTTO_PRICE = 1000;
    private static final int MAX_LOTTO_SIZE = 6;

    private final Set<LottoNumber> numbers;

    public LotteryTicket() {
        this.numbers = makeRandomNumbers();
    }

    public LotteryTicket(Set<LottoNumber> input) {
        this.numbers = input;
    }

    private Set<LottoNumber> makeRandomNumbers() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        while (validateSize(lottoNumbers)) {
            lottoNumbers.add(LottoNumber.makeRandomNumber());
        }
        return lottoNumbers;
    }

    private boolean validateSize(Set<LottoNumber> numbers) {
        return numbers.size() < MAX_LOTTO_SIZE;
    }

    @Override
    public Integer divideBy(Money money) {
        return money.divideBy(LOTTO_PRICE);
    }

    public Integer getLottoNumbersCount() {
        return numbers.size();
    }

    public Integer getResultBy(LotteryTicket winningTicket) {
        return Math.toIntExact(this.numbers.stream()
                .filter(winningTicket.numbers::contains)
                .count());
    }

    public String getValues() {
        return numbers.stream()
                .map(LottoNumber::getValue)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(NUMBER_OUTPUT_DELIMITER, OUTPUT_PREFIX, OUTPUT_SUFFIX));
    }

}
