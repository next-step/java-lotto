package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotteries {
    private final List<Lottery> lotteries;

    public Lotteries(final List<Lottery> lotteries) {
        this.lotteries = lotteries;
    }

    public int count() {
        return lotteries.size();
    }

    public List<LottoNumbers> getLottoNumbers() {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        for (Lottery lottery : lotteries) {
            lottoNumbers.add(lottery.getLottoNumbers());
        }
        return Collections.unmodifiableList(lottoNumbers);
    }
}
