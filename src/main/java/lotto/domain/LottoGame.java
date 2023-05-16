package lotto.domain;

import java.util.List;

public class LottoGame {

    private final Lottos lottos;

    public LottoGame(Lottos lottos) {
        this.lottos = lottos;
    }

    public List<List<Integer>> lottos() {
        return lottos.result();
    }

    public LottoScore score(WinningNumbers winningNumbers) {
        List<LottoMatcher> lottoMatchers = lottos.matchResult(winningNumbers);
        return new LottoScore(lottoMatchers);
    }

    public int quantity() {
        return lottos.quantity();
    }

    public void buyAutoLotto(LottoPrice lottoPrice) {
        lottos.buyLotto(lottoPrice);
    }

    public LottoPrice buyManualLotto(int price, List<List<Integer>> listOfNumbers) {
        LottoPrice lottoPrice = new LottoPrice(price);

        if (lottoPrice.greaterThanPrice(listOfNumbers)) {
            throw new RuntimeException("금액이 부족합니다.");
        }

        for (List<Integer> numbers : listOfNumbers) {
            lottos.buyLotto(numbers);
            lottoPrice = lottoPrice.pay();
        }

        return lottoPrice;
    }
}
