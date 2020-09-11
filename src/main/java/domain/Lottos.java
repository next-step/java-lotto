package domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public Lottos(int autoTries, Lottos manualCreated) {
        lottos = new ArrayList<>();

        combineLottoManual(manualCreated);
        makeLottoAuto(autoTries);
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public int getNumOfLottos() {
        return lottos.size();
    }

    public Lotto getOneLotto(int index) {
        return lottos.get(index);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }


    private void combineLottoManual(Lottos manualTries) {
        if (manualTries.getNumOfLottos() > 0) {
            lottos.addAll(manualTries.getLottos());
        }
    }

    private void makeLottoAuto(int autoTries) {
        NumberGenerator generator = new NumberGenerator();

        for (int i = 0; i < autoTries; i++) {
            addLotto(new Lotto(generator.generate()));
        }
    }
}
