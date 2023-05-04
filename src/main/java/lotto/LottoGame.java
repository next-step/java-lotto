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
        List<LottoMatcher> collect = lottos.stream()
                .map(lotto -> lotto.match(winNumber))
                .collect(Collectors.toList());
        return collect;
    }

    public LottoScore result(List<LottoNumber> winNumber) {
        List<LottoMatcher> lottoMatchers = matchResult(winNumber);
        return score(lottoMatchers);
    }

    public LottoScore score(List<LottoMatcher> lottoMatchers) {
        LottoScore lottoScore = new LottoScore();

        lottoScore.purchase(quantity() * LOTTO_PRICE);

        lottoMatchers.forEach(lottoMatcher -> {
            switch (lottoMatcher) {
                case FIRST_MATCH:
                    lottoScore.addFirst();
                    break;
                case SECOND_MATCH:
                    lottoScore.addSecond();
                    break;
                case THIRD_MATCH:
                    lottoScore.addThird();
                    break;
                case FOURTH_MATCH:
                    lottoScore.addFourth();
                    break;
                case NONE_MATCH:
                    // do nothing
                    break;
            }
        });

        return lottoScore;
    }

    public int quantity(){
        return lottos.size();
    }
}
