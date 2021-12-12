package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int amount) {
        this.lottos = init(amount);
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private List<Lotto> init(int amount) {
        validate(amount);
        List<Lotto> lottos = new ArrayList<>();
        int num = amount / Lotto.PRICE;
        for (int i = 0; i < num; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    private void validate(int amount) {
        if (amount < Lotto.PRICE) {
            throw new IllegalArgumentException("잔액이 부족합니다.");
        }
    }


    public LottoResult result(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        return result(new Lotto(winningNumbers), bonusNumber);
    }

    public LottoResult result(Lotto winningNumbers, LottoNumber bonusNumber) {
        Map<Rank, Integer> lottoResult = new HashMap<>();
        for (Lotto lotto : lottos) {
            int matchedCount = lotto.matchedCount(winningNumbers);
            boolean matchedBonus = lotto.matchedBonus(bonusNumber);
            Rank rank = Rank.valueOf(matchedCount, matchedBonus);
            lottoResult.put(rank, lottoResult.getOrDefault(rank, 0) + 1);
        }
        return new LottoResult(this, lottoResult);
    }

    public List<Lotto> lottos() {
        return lottos;
    }

    public int numberOfLotto() {
        return lottos.size();
    }

    public int amountOfLottos() {
        return Lotto.PRICE * lottos.size();
    }
}
