package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos(int lottoCount) {
        this.lottos = makeLottos(lottoCount);
    }

    private List<Lotto> makeLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        IntStream.range(0, lottoCount).forEach(value -> lottos.add(new Lotto()));
        return lottos;
    }

    public List<Lotto> lottos() {
        return lottos;
    }

    public void checkWinning(Lotto winningLotto) {
        lottos.forEach(lotto -> lotto.checkWinning(winningLotto));
    }

    public int countFifthWinner() {
        return (int) lottos.stream().filter(Lotto::isFifthWinner).count();
    }

    public int countFourthWinner() {
        return (int) lottos.stream().filter(Lotto::isFourthWinner).count();
    }

    public int countThirdWinner() {
        return (int) lottos.stream().filter(Lotto::isThirdWinner).count();
    }

    public int countFirstWinner() {
        return (int) lottos.stream().filter(Lotto::isFirstWinner).count();
    }
}
