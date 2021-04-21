package step4.lotto.domain;

import lotto.util.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lottos {
    List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public int lottoCount() {
        return lottos.size();
    }

    public void add(Lotto userLotto) {
        this.lottos.add(userLotto);
    }

    public void createManualLottos(List<String> manualLotto) {
        for(String numbers : manualLotto){
            add(new Lotto(StringUtil.stringToList(numbers)));
        }
    }

    public void createAutoLottos(int autoCount){
        for(int i = 0; i< autoCount; i++){
            add(new Lotto(LottoNumber.autoNumber()));
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }


}
