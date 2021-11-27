package lotto.model;

import common.model.Number;
import lotto.factory.LottoNumbersFactory;
import lotto.generator.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotto {

    private final List<LottoNumbers> lotto;

    public Lotto(List<LottoNumbers> lottoNumbers) {
        this.lotto = lottoNumbers;
    }

    public Lotto(int count) {
        this.lotto = autoCreateLotto(count);
    }

    public Lotto(List<LottoNumbers> manualLottoNumbers, int count) {
        this.lotto = manualLottoNumbers;
        merge(autoCreateLotto(count - manualLottoNumbers.size()));
    }

    private List<LottoNumbers> autoCreateLotto(int count) {
        List<LottoNumbers> lotto = new ArrayList<>();
        LottoNumberGenerator generator = new LottoNumberGenerator();
        for (int i = 0; i < count; i++) {
            lotto.add(LottoNumbersFactory.autoCreateNumbers(generator));
        }
        return lotto;
    }

    private void merge(List<LottoNumbers> lottoNumbers) {
        this.lotto.addAll(lottoNumbers);
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
