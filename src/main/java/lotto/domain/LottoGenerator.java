package lotto.domain;

public class LottoGenerator {

    public Lottos execute(int count) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < count; ++i) {
            lottos.buy();
        }
        return lottos;
    }
}
