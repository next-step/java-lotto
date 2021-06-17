package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(int quantity) {
        createAutoLottos(quantity);
    }

    public Lottos(int autoQuantity, int manualQuantity, List<String> manualNumbers) {
        createManualLottos(manualQuantity, manualNumbers);
        createAutoLottos(autoQuantity);
    }

    private void createAutoLottos(int quantity) {
        AutoLotto autoLotto = new AutoLotto();
        for (int i = 0; i < quantity; i++) {
            lottos.add(new Lotto(autoLotto.createLottoNumbers()));
        }
    }

    private void createManualLottos(int quantity, List<String> manualNumbers) {
        ManualLotto manualLotto = new ManualLotto();
        for (int i = 0; i < quantity; i++) {
            lottos.add(new Lotto(manualLotto.createLottoNumbers(manualNumbers.get(i))));
        }
    }

    public void countWinningResults(Lotto winningNumbers, LottoNumber bonusNumber, WinningResult winningResult) {
        for (Lotto lotto : lottos) {
            int numberOfWinningNumbers = lotto.countWinningNumbers(winningNumbers);
            boolean existenceOfBonusNumber = lotto.contains(bonusNumber);
            winningResult.addNumberOfWinning(numberOfWinningNumbers, existenceOfBonusNumber);
        }
    }

    public float calculateEarningRate(int earningPrice, int purchasePrice) {
        return (float) earningPrice / (float) purchasePrice;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
