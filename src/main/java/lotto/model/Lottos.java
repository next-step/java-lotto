package lotto.model;

import java.util.List;

public class Lottos {
    private int autoLottoCount;
    private List<Lotto> manulLottos;
    private List<Lotto> autoLottos;

    public Lottos(int autoLottoCount, List<Lotto> autoLottos) {
        this.autoLottoCount = autoLottoCount;
        this.autoLottos = autoLottos;
    }

    public int getTotalLottoCount(){
        return manulLottos.size() + autoLottos.size();
    }
}
