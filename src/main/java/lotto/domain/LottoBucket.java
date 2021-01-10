package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoBucket {

    private final List<Lotto> lottos;
    private int manualLottoCount = 0;
    private int autoLottoCount = 0;

    public LottoBucket() {
        this.lottos = new ArrayList<>();
    }

    public void createLotto(Lotto lotto) {
        lotto.createLotto();
        addLotto(lotto);
    }

    protected void addLotto(Lotto lotto){
        lottos.add(lotto);
    }

    protected void increaseManualLottoCount() {
        this.manualLottoCount += 1;
    }

    protected void increaseAutoLottoCount() {
        this.autoLottoCount += 1;
    }
    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public int countOfManualLotto() {
        return this.manualLottoCount;
    }
    public int countOfAutoLotto() {
        return this.autoLottoCount;
    }
}
