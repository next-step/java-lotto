package lotto.view.model;

import lotto.domain.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class UserManualLottoInput {
    private final List<Lotto> manualLottos;

    private UserManualLottoInput(List<Lotto> manualLottos) {
        this.manualLottos = manualLottos;
    }

    public static UserManualLottoInput from(List<List<Integer>> manualNums) {
        List<Lotto> manualLottos = new ArrayList<>();
        for (List<Integer> manualNum : manualNums) {
            manualLottos.add(Lotto.createManual(manualNum));
        }
        return new UserManualLottoInput(manualLottos);
    }

    public int getManualAmount() {
        return manualLottos.size();
    }
}
