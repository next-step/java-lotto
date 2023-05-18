package domain;

import java.util.List;

public class LottoGame {
    private LottoResults lottoResults;

    private Money money;

    public LottoGame() {
        this.lottoResults = new LottoResults();
    }

    public void generateLottoResultsFromMoney(ManualRequest manualRequest, int money) {
        int manualCount = manualRequest.getManualCount();
        List<int[]> manualNumbers = manualRequest.getManualNumbers();
        this.money = new Money(money);
        if (manualCount != manualNumbers.size()) {
            throw new IllegalArgumentException("수동 구매가 잘못되었습니다.");
        }
        // 수동 구매
        for (int i = 0; i < manualCount; i++) {
            lottoResults.add(LottoNumGenerator.generateManualNumbers(manualNumbers.get(i)));
        }
        for (int i = 0; i < getCount(); i++) {
            lottoResults.add(LottoNumGenerator.generateNumbers());
        }
    }

    public void writeManualLottoResults(int money) {
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

