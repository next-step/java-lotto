package lotto.view.dto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottosDto {
    private final Lottos manualLottos;
    private final Lottos autoLottos;

    public LottosDto(int money, Lottos manualLottos) {
        this.manualLottos = manualLottos;
        this.autoLottos = new Lottos(money, manualLottos.size());
    }

    public int manualSize() {
        return this.manualLottos.size();
    }

    public int autoSize() {
        return this.autoLottos.size();
    }

    public List<Lotto> getLottos() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(manualLottos.getLottos());
        lottos.addAll(autoLottos.getLottos());
        return Collections.unmodifiableList(lottos);
    }
}
