package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private final LottoNumberGenerator lottoNumberGenerator;
    private final List<Lotto> lottos;

    public LottoGame(LottoNumberGenerator lottoNumberGenerator, List<Lotto> lottos) {
        this.lottoNumberGenerator = lottoNumberGenerator;
        this.lottos = lottos;
    }

    public void buyLotto(int price) {
        int lottoCount = price / LOTTO_PRICE;
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(lottoNumberGenerator.lotto()));
        }
    }

    public List<Lotto> lottos() {
        return lottos;
    }

    private List<LottoMatcher> matchResult(List<LottoNumber> winNumber) {
        return lottos.stream()
                .map(lotto -> lotto.match(winNumber))
                .collect(Collectors.toList());
    }

    public LottoScore score(List<LottoNumber> winNumber) {
        List<LottoMatcher> lottoMatchers = matchResult(winNumber);
        LottoScore lottoScore = new LottoScore();
        lottoScore.purchase(quantity() * LOTTO_PRICE);
        lottoScore.updateScore(lottoMatchers);
        return lottoScore;
    }

    public int quantity() {
        return lottos.size();
    }
}
