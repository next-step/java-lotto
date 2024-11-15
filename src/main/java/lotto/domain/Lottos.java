package lotto.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos implements Iterable<Lotto> {
    private final List<Lotto> passivityLottos;
    private final List<Lotto> autoLottos;

    public Lottos(List<Lotto> passivityLottos, List<Lotto> autoLottos) {
        this.passivityLottos = passivityLottos;
        this.autoLottos = autoLottos;
    }

    public int passivitySize() {
        return passivityLottos.size();
    }

    public int autoSize() {
        return autoLottos.size();
    }

    public List<Rank> matchAll(WinningLotto winningLotto) {
        return matchAll(winningLotto, totalLottos());
    }

    private List<Lotto> totalLottos() {
        return Stream.concat(passivityLottos.stream(), autoLottos.stream()).collect(Collectors.toList());
    }

    private static List<Rank> matchAll(WinningLotto winningLotto, List<Lotto> allLottos) {
        List<Rank> result = new ArrayList<>();
        for (Lotto lotto : allLottos) {
            result.add(winningLotto.match(lotto));
        }
        return result;
    }

    @Override
    public Iterator<Lotto> iterator() {
        return totalLottos().iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lottos lottos = (Lottos) o;
        return Objects.equals(passivityLottos, lottos.passivityLottos) && Objects.equals(autoLottos,
                lottos.autoLottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passivityLottos, autoLottos);
    }
}
