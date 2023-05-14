package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.Constants.LOTTO_PRICE;

public class Lottos {
    private final List<Lotto> lottos;
    private final LottoNumberGenerator lottoNumberGenerator;

    public Lottos(List<Lotto> lottos, LottoNumberGenerator lottoNumberGenerator) {
        this.lottos = lottos;
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public void buyLotto(int price) {
        checkPrice(price);
        int lottoCount = price / LOTTO_PRICE;
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(lottoNumberGenerator.lotto()));
        }
    }

    public List<LottoMatcher> matchResult(WinningNumbers winningNumbers) {
        return lottos.stream()
                .map(lotto -> winningNumbers.match(lotto))
                .collect(Collectors.toList());
    }

    private static void checkPrice(int price) {
        if (LOTTO_PRICE > price) {
            throw new IllegalArgumentException("로또 구매 비용이 부족합니다.");
        }
    }

    public int quantity() {
        return lottos.size();
    }

    public List<List<Integer>> result() {
        return lottos.stream()
                .map(lotto -> lotto.lottoNumbers()
                        .stream().map(LottoNumber::intValue)
                        .collect(Collectors.toList())).collect(Collectors.toList());

    }
}
