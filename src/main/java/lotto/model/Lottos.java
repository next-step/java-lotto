package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        AutoLottoMaker autoLottoMaker = new AutoLottoMaker();
        for (int i = 0; i < quantity; i++) {
            lottos.add(autoLottoMaker.createLotto());
        }
    }

    private void createManualLottos(int quantity, List<String> manualNumbers) {
        ManualLottoMaker manualLottoMaker = new ManualLottoMaker();
        for (int i = 0; i < quantity; i++) {
            lottos.add(manualLottoMaker.createLotto(manualNumbers.get(i)));
        }
    }

    public WinningResults countWinningResults(WinningLotto winningLotto) {
        Map<WinningResult, Integer> results = new HashMap<>();
        for (WinningResult value : WinningResult.values()) {
            results.put(value, 0);
        }
        for (Lotto lotto : lottos) {
            int numberOfWinningNumbers = winningLotto.countWinningNumbers(lotto);
            boolean existenceOfBonusNumber = winningLotto.containsBonusNumber(lotto);
            WinningResult winningResult = WinningResult.addNumberOfWinning(numberOfWinningNumbers, existenceOfBonusNumber);
            results.put(winningResult, results.get(winningResult) + 1);
        }
        return new WinningResults(results);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
