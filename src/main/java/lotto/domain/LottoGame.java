package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.Constants.LOTTO_PRICE;

public class LottoGame {
    private final LottoNumberGenerator lottoNumberGenerator;
    private final List<Lotto> lottos;

    public LottoGame(LottoNumberGenerator lottoNumberGenerator, List<Lotto> lottos) {
        this.lottoNumberGenerator = lottoNumberGenerator;
        this.lottos = lottos;
    }

    public void buyLotto(int price) {
        checkPrice(price);
        int lottoCount = price / LOTTO_PRICE;
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(lottoNumberGenerator.lotto()));
        }
    }

    public List<Lotto> lottos() {
        return lottos;
    }

    private List<LottoMatcher> matchResult(WinningNumbers winningNumbers) {
        return lottos.stream()
                .map(lotto -> winningNumbers.match(lotto))
                .collect(Collectors.toList());
    }

    private static void checkPrice(int price) {
        if (LOTTO_PRICE > price) {
            throw new IllegalArgumentException("로또 구매 비용이 부족합니다.");
        }
    }

    public LottoScore score(WinningNumbers winningNumbers) {
        return new LottoScore(matchResult(winningNumbers));
    }

    public int quantity() {
        return lottos.size();
    }
}
