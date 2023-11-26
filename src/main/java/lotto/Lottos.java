package lotto;

import com.sun.jdi.connect.Connector.StringArgument;
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

    public LottoResult result(Lotto resultLotto) {
        Map<LottoResultType,Lottos> result  = new HashMap<>();
        List<Lotto> treeCount = this.lottos.stream()
                                                .filter(each -> resultLotto.howManySameNumber(each) == 3)
                                                .collect(Collectors.toList());
        result.put(LottoResultType.THREE, Lottos.of(treeCount));

        List<Lotto> fourCount = this.lottos.stream()
                                            .filter(each -> resultLotto.howManySameNumber(each) == 4)
                                            .collect(Collectors.toList());
        result.put(LottoResultType.FOUR, Lottos.of(fourCount));

        List<Lotto> fiveCount = this.lottos.stream()
                                            .filter(each -> resultLotto.howManySameNumber(each) == 5)
                                            .collect(Collectors.toList());
        result.put(LottoResultType.FIVE, Lottos.of(fiveCount));

        List<Lotto> allCount = this.lottos.stream()
                                          .filter(each -> resultLotto.howManySameNumber(each) == 6)
                                          .collect(Collectors.toList());
        result.put(LottoResultType.ALL, Lottos.of(allCount));


        return LottoResult.defaultOf(result);
    }
    public double calculatePrice(LottoResultType lottoResultType) {
        int count = this.lottos.size();
        return lottoResultType.calculatePrice(count);
    }

    public int size() {
        return this.lottos.size();
    }

    public String toStringStatus() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : this.lottos) {
            stringBuilder.append(lotto.toStringStatus()).append("\n");
        }
        return stringBuilder.toString();
    }

}
