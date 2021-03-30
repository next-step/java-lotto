package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> manualLottos, List<Lotto> lottos) {
        this.lottos = manualLottos;
        this.lottos.addAll(lottos);
    }

    public int lottoCount() {
        return lottos.size();
    }

    public List<String> numbers() {
        return lottos.stream()
                .map(Lotto::numbers)
                .collect(Collectors.toList());
    }

    public ResultGroup getResult(WinningLotto winingLotto) {
        ResultGroup resultGroup = new ResultGroup();
        for (Lotto lotto : lottos) {
            resultGroup.update(winingLotto.howMatch(lotto));
        }
        return resultGroup;
    }

    public void addLotto(List<Lotto> lottos) {
        this.lottos.addAll(lottos);
    }
}
