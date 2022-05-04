package autolotto.domain;

import autolotto.constant.Rank;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private static final int LOTTO_PRICE = 1000;
    private final List<LottoNumbers> lottoNumbers = new ArrayList<>();

    public void createLotto(int quantity) {
        for (int count = 0; count < quantity; count++) {
            LottoNumbers lottoNumbers = new LottoNumbers(LottoGenerator.generate());
            add(lottoNumbers);
        }
    }

    public Results confirm(WinningLotto winningLotto) {
        Results results = new Results();

        for (LottoNumbers lottoNumber : lottoNumbers) {
            int countOfMatch = lottoNumber.match(winningLotto);
            boolean isBonus = lottoNumber.checkBonus(winningLotto, countOfMatch);
            results.plusWinners(Rank.find(countOfMatch, isBonus));
        }
        return results;
    }

    public int cost() {
        return lottoNumbers.size() * LOTTO_PRICE;
    }

    public int getQuantity(int amount) {
        return amount / LOTTO_PRICE;
    }

    public List<LottoNumbers> getLottoNumbers() {
        return lottoNumbers;
    }

    protected void add(LottoNumbers lottoNumbers) {
        this.lottoNumbers.add(lottoNumbers);
    }
}
