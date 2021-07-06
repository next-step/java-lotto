package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private static final int LOTTO_SIZE = 6;
    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(int quantity) {
        createAutoLottos(quantity);
    }

    public Lottos(int manualQuantity, int autoQuantity, List<String> manualNumbers) {
        createManualLottos(manualQuantity, manualNumbers);
        createAutoLottos(autoQuantity);
    }

    public void createAutoLottos(int quantity) {
        for (int i = 0; i < quantity; i++) {
            lottos.add(LottoFactory.createAutoLotto());
        }
    }

    public void createManualLottos(int quantity, List<String> manualNumbers) {
        for (int i = 0; i < quantity; i++) {
            String separator = ", ";
            String[] splitManualNumbers = manualNumbers.get(i).split(separator);
            List<LottoNumber> lottoNumbers = new ArrayList<>();
            for (int j = 0; j < LOTTO_SIZE; j++) {
                int lottoNumber = Integer.parseInt(splitManualNumbers[j]);
                lottoNumbers.add(LottoNumber.of(lottoNumber));
            }
            lottos.add(LottoFactory.createManualLotto(lottoNumbers));
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
