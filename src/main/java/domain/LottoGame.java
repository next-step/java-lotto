package domain;

public class LottoGame {
    private LottoResults lottoResults;

    private Money money;

    public LottoGame() {
        this.lottoResults = new LottoResults();
    }

    public void generateLottoResultsFromMoney(int money) {
        this.money = new Money(money);
        for (int i = 0; i < getCount(); i++) {
            lottoResults.add(LottoNumGenerator.generateResult());
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

