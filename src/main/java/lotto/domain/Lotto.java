package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto implements Product {

    public static final int LOTTO_PRICE = 1000;
    public static final int MAX_LOTTO_SIZE = 6;
    public static final String NUMBER_DELIMITER = ", ";

    private final Set<LottoNumber> numbers;
    private static final Money PRICE = new Money(LOTTO_PRICE);

    public Lotto() {
        this.numbers = makeRandomNumbers();
    }

    public Lotto(String input) {
        this.numbers = parseNumbers(input);
    }

    private Set<LottoNumber> parseNumbers(String input) {
        return Arrays.stream(input.split(NUMBER_DELIMITER))
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
}
