package lotto.domain.product;

import lotto.domain.Money;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LotteryTicket implements Product {

    public static final String NUMBER_INPUT_DELIMITER = ", ";
    public static final String NUMBER_OUTPUT_DELIMITER = ", ";
    public static final String OUTPUT_PREFIX = "[";
    public static final String OUTPUT_SUFFIX = "]";

    public static final int LOTTO_PRICE = 1000;
    public static final int MAX_LOTTO_SIZE = 6;

    private final Set<LottoNumber> numbers;

    public LotteryTicket() {
        this.numbers = makeRandomNumbers();
    }

    public LotteryTicket(String input) {
        this.numbers = parseNumbers(input);
    }

    private Set<LottoNumber> parseNumbers(String input) {
        return Arrays.stream(input.split(NUMBER_INPUT_DELIMITER))
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
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
