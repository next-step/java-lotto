package lotto.domain.product;

import lotto.domain.Money;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LotteryTicket implements Product {

    private static final int LOTTO_PRICE = 1000;
    private static final int MAX_LOTTO_SIZE = 6;

    private final Set<LottoNumber> numbers;

    public LotteryTicket() {
        this.numbers = makeRandomNumbers();
    }

    protected LotteryTicket(LotteryTicket lotteryTicket) {
        this.numbers = lotteryTicket.numbers;
    }

    public LotteryTicket(Set<LottoNumber> input) {
        this.numbers = input;
    }

    public LotteryTicket(String input) {
        this(parseInput(input));
    }

    private static Set<LottoNumber> parseInput(String input) {
        Set<LottoNumber> lottoNumbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
        validSizeOf(lottoNumbers);
        return lottoNumbers;
    }

    private static void validSizeOf(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != MAX_LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 숫자는 6개로 이뤄져 있습니다.");
        }
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

    public Set<Integer> getValues() {
        return numbers.stream()
                .map(LottoNumber::getValue)
                .collect(Collectors.toSet());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LotteryTicket that = (LotteryTicket) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numbers);
    }
}
