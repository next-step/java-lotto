package domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottoNumbers = new ArrayList<>();

    public Lottos() {
    }

    public void addLotto(Lotto lotto) {
        this.lottoNumbers.add(lotto);
    }

    public List<Lotto> getLottoNumbers() {
        return lottoNumbers;
    }
}
