package lotto.domain;

import lotto.match.LottoResult;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoList {

    private final List<Lotto> lottos;

    public LottoList(Integer count) {
        this(IntStream.range(0, count)
                .mapToObj(x -> new Lotto(LottoMaker.getNumbers()))
                .collect(Collectors.toUnmodifiableList()));
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

    public List<String> getLottoTextList(){
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.toUnmodifiableList());
    }
}
