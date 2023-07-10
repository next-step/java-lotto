package lotto.auto.domain;

import lotto.auto.vo.WinNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoPaper {
    private List<Lotto> lottos;

    public LottoPaper(int count) {
        this.lottos = new ArrayList<Lotto>(count);
    }

    public void addAutoLotto() {
        lottos.add(new Lotto());
    }

    public void addAutoLottos(int count) {
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto());
        }
    }

    public void addManualLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Win> checkWins(WinNumber winNumber) {
        return lottos.stream().map(lotto -> lotto.checkWin(winNumber)).collect(Collectors.toList());
    }

}
