package lotto.model;

import lotto.autoLottoGenerator.AutoLottoGenerator;

import java.util.Collections;
import java.util.List;

public class Lottos {
    private List<Lotto> allLottos;

    private Lottos(List<Lotto> allLottos) {
        this.allLottos = Collections.unmodifiableList(allLottos);
    }

    public static Lottos getAllLottos(int autoLottoCount, List<Lotto> manulLottos) {
        List<Lotto> lottos = generateAutoLottos(autoLottoCount);
        for(Lotto manualLotto:manulLottos){
            lottos.add(manualLotto);
        }
        return new Lottos(lottos);
    }

    private static  List<Lotto> generateAutoLottos(int autoLottoCount) {
        return AutoLottoGenerator.generate(autoLottoCount);
    }

    private List<Lotto> addLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            allLottos.add(lotto);
        }
        return allLottos;
    }

    public int getToTalLottoCount(){
        return allLottos.size();
    }
}
