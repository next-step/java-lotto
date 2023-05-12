package domain;

import java.util.List;

public class LottoGenerator {
    private LottoResults lottoResults;

    private Money money;

    public LottoGenerator(LottoResults lottoResults) {
        this.lottoResults = lottoResults;
    }

    public LottoGenerator() {
        this.lottoResults = new LottoResults();
    }

    public void generateLottoResultsFromMoney(int money) {
        this.money = new Money(money);
        for (int i = 0; i < getCount(); i++) {
            lottoResults.add(LottoNumGenerator.generateNumbers());
        }
    }

    public int getCount() {
        return money.getCount();
    }

    public int getMoney() {
        return money.getMoney();
    }

    public LottoResults getLottoResults() {
        return lottoResults;
    }
}

