package step4.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public Lottos(int purchaseAmount) {
        this.lottoList = generateNumbers(purchaseAmount);
    }

    public Lottos(int purchaseAmount, NumberGenerator numberGenerator) {
        this.lottoList = generateNumbers(purchaseAmount, numberGenerator);
    }

    public List<Lotto> generateNumbers(int purchaseAmount) {
        return generateNumbers(purchaseAmount, new SimpleNumberGenerator());
    }

    public List<Lotto> generateNumbers(int purchaseAmount, NumberGenerator numberGenerator) {
        List<Lotto> newLottoList = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            newLottoList.add(new Lotto(numberGenerator.generateNumbers()));
        }
        return newLottoList;
    }

    public Lottos(List<List<Integer>> manualLottos, int purchaseAmount) {
        List<Lotto> newLottoList = toLottoList(manualLottos);
        newLottoList.addAll(generateNumbers(purchaseAmount));
        this.lottoList = newLottoList;
    }

    private List<Lotto> toLottoList(List<List<Integer>> manualLottos) {
        List<Lotto> newLottoList = new ArrayList<>();
        for (List<Integer> manualLotto : manualLottos) {
            newLottoList.add(Lotto.of(manualLotto));
        }
        return newLottoList;
    }

    public int getAmount() {
        return lottoList.size();
    }

    public LottosTotalResult getResult(WinningLottoNumbers winningLottoNumbers) {
        LottosTotalResult lottosTotalResult = new LottosTotalResult();
        for (Lotto lotto : lottoList) {
            lottosTotalResult.plusOne(winningLottoNumbers.matchedCount(lotto), winningLottoNumbers.isBonusMatched(lotto));
        }
        return lottosTotalResult;
    }


    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
