package step4.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public class Lotto {

    private static final int QTY = 6;
    private static final int LOTTO_VALUE = 45;
    private List<LottoNumber> lottos = new ArrayList<>();

    public Lotto() {
        autoLottoNumber();
    }

    private Lotto(List<LottoNumber> lottoNumbers) {
        this.lottos = lottoNumbers;
    }

    public static Lotto of(List<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    private void autoLottoNumber() {
        LinkedHashSet<LottoNumber> set = new LinkedHashSet<>();

        while (QTY > set.size()) {
            LottoNumber number = new LottoNumber((int) (Math.random() * LOTTO_VALUE) + 1);
            set.add(number);
        }

        this.lottos = new ArrayList<>(set);
        Collections.sort(this.lottos);
    }

    public List<LottoNumber> getLottos() {
        return this.lottos;
    }


}