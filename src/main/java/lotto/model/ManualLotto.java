package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class ManualLotto {
    public List<Lotto> setLotto(int manualQuantity, int autoQuantity, List<String> manualNumbers) {
        List<Lotto> lottos = new ArrayList<>();

        setManualLottos(manualQuantity, manualNumbers, lottos);
        setAutoLottos(autoQuantity, lottos);

        return lottos;
    }

    public void setManualLottos(int manualQuantity, List<String> manualNumbersString, List<Lotto> lottos) {
        for (int i = 0; i < manualQuantity; i++) {
            lottos.add(new Lotto(manualNumbersString.get(i)));
        }
    }

    public void setAutoLottos(int autoQuantity, List<Lotto> lottos) {
        for (int i = 0; i < autoQuantity; i++) {
            lottos.add(new Lotto());
        }
    }
}
