package lotto.domain;

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
        checkPrice(price);
        int lottoCount = price / LOTTO_PRICE;
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(lottoNumberGenerator.lotto()));
        }
    }

    public List<Lotto> lottos() {
        return lottos;
    }

    private List<LottoMatcher> matchResult(List<LottoNumber> winNumber, LottoNumber bonusNumber) {
        return lottos.stream()
                .map(lotto -> lotto.match(winNumber, bonusNumber))
                .collect(Collectors.toList());
    }

    private static void checkPrice(int price) {
        if(LOTTO_PRICE > price) {
            throw new IllegalArgumentException("로또 구매 비용이 부족합니다.");
        }
    }

    public LottoScore score(List<LottoNumber> winNumbers, LottoNumber bonusNumber) {
        checkWinNumbers(winNumbers);
        return new LottoScore(
                LOTTO_PRICE,
                quantity(),
                matchResult(winNumbers, bonusNumber)
        );
    }

    private void checkWinNumbers(List<LottoNumber> winNumbers) {
        if(winNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 당첨번호는 6개 입니다.");
        }
    }

    public int quantity() {
        return lottos.size();
    }
}
