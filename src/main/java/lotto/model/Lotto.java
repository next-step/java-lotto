package lotto.model;

import common.model.Number;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotto {

    private final List<LottoNumbers> lotto;

    public Lotto(List<LottoNumbers> lottoNumbers) {
        this.lotto = lottoNumbers;
    }

    public Map<LottoRank, Number> matchAll(LottoWinner winner) {
        Map<LottoRank, Number> lottoRankNumbers = new HashMap<>();

        for (LottoNumbers lottoNumbers : this.lotto) {
            LottoRank rank = winner.match(lottoNumbers);
            Number count = lottoRankNumbers.getOrDefault(rank, new Number());
            count.plus();
            lottoRankNumbers.put(rank, count);
        }

        return lottoRankNumbers;
    }

    public int getLottoSize() {
        return lotto.size();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (LottoNumbers lottoNumbers : lotto) {
            builder.append(lottoNumbers.toString()).append("\n");
        }
        return builder.toString();
    }
}
