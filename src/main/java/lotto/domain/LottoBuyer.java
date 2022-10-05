package lotto.domain;

import lotto.strategy.NumberGenerateStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoBuyer {

    private final LottoShop lottoShop;
    private List<Lotto> myLotto;
    private int purchaseAmount;

    public LottoBuyer(LottoShop lottoShop) {
        this.lottoShop = lottoShop;
    }

    public void buy(int money) {
        purchaseAmount = lottoShop.lottoTryCount(money);
    }

    public void generateNumbers(NumberGenerateStrategy numberGenerateStrategy) {
        this.myLotto = IntStream.range(0, purchaseAmount)
                .mapToObj(range -> lottoShop.createLotto(numberGenerateStrategy))
                .collect(Collectors.toList());
    }

    public List<Lotto> getMyLotto() {
        return this.myLotto;
    }

    public List<MatchingResult> matchingResults(List<Integer> answer) {
        this.myLotto.forEach(lotto -> lotto.match(answer));
        return this.myLotto.stream()
                .filter(lotto -> lotto.matchingCount() >= 3)
                .map(lotto -> lotto.getMatchingResult())
                .collect(Collectors.toList());
    }
}
