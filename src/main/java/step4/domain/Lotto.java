package step4.domain;

import java.util.*;

public class Lotto {

    private static final int QTY = 6;
    private static final int LOTTO_VALUE = 45;
    private List<Numbers> lottos = new ArrayList<>();

    public Lotto() {
        autoLottoNumber();
    }

    private Lotto(List<Numbers> lottoNumbers) {
        this.lottos = lottoNumbers;
    }

    public static Lotto of(List<Numbers> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    private void autoLottoNumber() {
        Set<Numbers> set = new HashSet<>();
        while (QTY > set.size()) {
            Numbers number = Numbers.of(String.valueOf((int) (Math.random() * LOTTO_VALUE) + 1));
            set.add(number);
        }

        this.lottos = new ArrayList<>(set);
        Collections.sort(this.lottos);
    }

    public List<Numbers> getLottos() {
        return this.lottos;
    }
}