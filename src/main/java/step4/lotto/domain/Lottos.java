package step4.lotto.domain;

import lotto.util.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lottos {
    List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int lottoCount() {
        return lottos.size();
    }

    public void add(Lotto userLotto) {
        this.lottos.add(userLotto);
    }

    public void addLotto(int autoCount) {
        for (int i = 0; i < autoCount; i++) {
            add(new Lotto(LottoNumber.autoNumber()));
        }
    }

    public void addLotto(List<String> manualLotto) {
        for (String numbers : manualLotto) {
            add(new Lotto(StringUtil.stringToList(numbers)));
        }
    }

    public Result match(WinningLotto winningLotto){
        Result result = new Result();
        lottos.stream()
                .forEach(lotto -> result.plusRankCount(match(lotto, winningLotto)));
        return result;
    }

    public Rank match(Lotto userLotto, WinningLotto winningLotto) {
        return winningLotto.match(userLotto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }

    @Override
    public String toString() {
        String result = lottos.stream()
                        .map(n -> n.toString())
                        .collect(Collectors.joining("\n"));
        return result;
    }
}
