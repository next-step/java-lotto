package lotto.auto.domain;

import lotto.auto.vo.WinNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(int count) {
        for(int i = 0; i< count; i ++) {
            this.lottos.add(new Lotto());
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Win> checkWins(WinNumber winNumber) {
        return lottos.stream().map(lotto -> lotto.checkWin(winNumber)).collect(Collectors.toList());
    }

}
