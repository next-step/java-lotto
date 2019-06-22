package step2.iksoo.lottoAuto;

import java.util.List;
import java.util.stream.IntStream;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottoList) {
        this.lottos = lottoList;
        this.printLotto();
    }

    private void printLotto() {
        IntStream.range(0, this.lottos.size())
                .forEach(n -> this.lottos.get(n).printLotto());
    }
}
