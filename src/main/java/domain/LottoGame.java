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
        List<List<Integer>> manualNumbers = manualRequest.getManualNumbers();
        this.money = new Money(money, manualCount);
        if (manualCount != manualNumbers.size()) {
            throw new IllegalArgumentException("수동 구매가 잘못되었습니다.");
        }
        // 수동 구매
        generateManualResults(manualCount, manualNumbers);
        generateAutomaticResults();
    }

    private void generateAutomaticResults() {
        for (int i = 0; i < getAutomaticCount(); i++) {
            lottoResults.add(LottoNumGenerator.generateAutomaticResults());
        }
    }

    private void generateManualResults(int manualCount, List<List<Integer>> manualNumbers) {
        for (int i = 0; i < manualCount; i++) {
            lottoResults.add(LottoNumGenerator.generateManualResults(manualNumbers.get(i)));
        }
    }

    public int getCount() {
        return money.getTotalCount();
    }

    public int getAutomaticCount() {
        return money.getAutomaticCount();
    }

    public int getMoney() {
        return money.getMoney();
    }

    public LottoResults getLottoResults() {
        return lottoResults;
    }
}

