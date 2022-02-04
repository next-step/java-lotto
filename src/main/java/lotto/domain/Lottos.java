package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(int lottoCount) {
        this.lottos = setLottos(lottoCount);
    }

    private List<Lotto> setLottos(int lottoCount) {
        final List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = setLotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    // TODO : 난수를 생성하는 로직과 Lotto 인스턴스를 생성하는 로직이 한 곳에 있으므로 테스트가 어려움
    private Lotto setLotto() {
        final List<Integer> lottoNumbers = GeneratorNumber.generateLottoNumbers();
        return new Lotto(new ArrayList<>(lottoNumbers));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
