package lotto.model;

import lotto.autoLottoGenerator.AutoLottoGenerator;

import java.util.List;

public class Lottos {
    private List<Lotto> manulLottos;
    private List<Lotto> autoLottos;

    public Lottos(int autoLottoCount, List<Lotto> manulLottos) {
        this.autoLottos = generateAutoLottos(autoLottoCount);
        this.manulLottos = manulLottos;
    }

    private List<Lotto> generateAutoLottos(int autoLottoCount){
        return AutoLottoGenerator.generate(autoLottoCount);
    }

    public int getTotalLottoCount(){
        return manulLottos.size() + autoLottos.size();
    }
}
