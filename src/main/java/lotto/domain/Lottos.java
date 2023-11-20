package lotto.domain;

import java.util.*;

public class Lottos {

    private static Random random = new Random();

    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(int count) {
        for (int i = 0; i < count; i++) {
            Lotto lotto = makeLotto();
            lottos.add(lotto);
        }
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getLottosSize() {
        return lottos.size();
    }

    public Lotto getLottoIndex(int index) {
        return lottos.get(index);
    }

    private Lotto makeLotto() {
        Set<LottoNumber> lottoNumbers = new TreeSet<>(Comparator.comparing(LottoNumber::getNumber));
        while (lottoNumbers.size() != 6) {
            LottoNumber number = new LottoNumber(random.nextInt(45) + 1);
            lottoNumbers.add(number);
        }
        return new Lotto(lottoNumbers);
    }
}
