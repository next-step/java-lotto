package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int lottoCount() {
        return lottos.size();
    }

    public List<String> numbers() {
        return lottos.stream()
                .map(Lotto::numbers)
                .collect(Collectors.toList());
    }

    public ResultGroup getResult(Lotto winingLotto) {
        ResultGroup resultGroup = new ResultGroup();
        for (Lotto lotto : lottos) {
            int howMatch = lotto.howMatch(winingLotto);
            resultGroup.update(ResultMap.of(howMatch));
        }
        return resultGroup;
    }
}
