package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottoes {

    private final List<Lotto> lottoes;

    public Lottoes(int lottoCount) {
        this.lottoes = setLottoes(lottoCount);
    }

    private List<Lotto> setLottoes(int lottoCount) {
        final List<Lotto> lottoes = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = setLotto();
            lottoes.add(lotto);
        }
        return lottoes;
    }

    // TODO : 난수를 생성하는 로직과 Lotto 인스턴스를 생성하는 로직이 한 곳에 있으므로 테스트가 어려움
    private Lotto setLotto() {
        return new Lotto(GeneratorNumber.generateLottoNumbers());
    }

    public List<Lotto> getLottos() {
        return lottoes;
    }
}
