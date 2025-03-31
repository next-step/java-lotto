package lotto.domain.product;

import lotto.domain.Money;

import java.util.HashSet;
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

}
