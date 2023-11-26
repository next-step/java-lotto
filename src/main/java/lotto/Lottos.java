package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public boolean sameSize(int expectSize){
        return lottos.size() == expectSize;
    }

    public LottoResult countMatching(Lotto resultLotto) {
        Map<LottoResultType,Lottos> result  = new HashMap<>();
        List<Lotto> treeCount = this.lottos.stream()
                                                .filter(each -> resultLotto.howManySameNumber(each) == 3)
                                                .collect(Collectors.toList());

        List<Lotto> fourCount = this.lottos.stream()
                                            .filter(each -> resultLotto.howManySameNumber(each) == 4)
                                            .collect(Collectors.toList());
        List<Lotto> fiveCount = this.lottos.stream()
                                            .filter(each -> resultLotto.howManySameNumber(each) == 5)
                                            .collect(Collectors.toList());
        List<Lotto> allCount = this.lottos.stream()
                                          .filter(each -> resultLotto.howManySameNumber(each) == 6)
                                          .collect(Collectors.toList());

        result.put(LottoResultType.TREE, Lottos.of(treeCount));
        result.put(LottoResultType.FOUR, Lottos.of(fourCount));
        result.put(LottoResultType.FIVE, Lottos.of(fiveCount));
        result.put(LottoResultType.ALL, Lottos.of(allCount));

        return LottoResult.defaultOf(result);
    }

    @Override
    public String toString() {
        return "lotto.Lottos{" +
            "lottos=" + lottos +
            '}';
    }

    public double calculatePrice(LottoResultType lottoResultType) {
        int count = this.lottos.size();
        return lottoResultType.calculatePrice(count);
    }
}
