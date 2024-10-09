package step2.view;

import step2.model.LottoResult;

public class ResultView {
    public void printLottoResult(LottoResult lottoResult) {
        lottoResult.getLottoResults()
                .stream()
                .forEach(lotto -> {
                    System.out.println(lotto.toString());
                });
    }
}
