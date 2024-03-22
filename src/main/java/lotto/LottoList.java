package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoList {

    private final List<Lotto> lottos;

    public LottoList(Integer count) {
        this(IntStream.range(0, count).mapToObj(x -> new Lotto()).collect(Collectors.toUnmodifiableList()));
    }

    public LottoList(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoResult getLottoResult(List<Integer> answerSheet) {
        return new LottoResult(lottos,answerSheet);
    }

    public int size(){
        return lottos.size();
    }

    public void print(){
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
