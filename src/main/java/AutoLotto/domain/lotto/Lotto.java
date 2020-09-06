package AutoLotto.domain.lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private final List<LottoNum> lotto;

    public Lotto() {
        this.lotto = createLotto();
    }

    public List<LottoNum> getLotto() {
        return lotto;
    }

    private List<LottoNum> createLotto() {
            List<LottoNum> lottoNumList = IntStream.range(1, 45).mapToObj(LottoNum::new).collect(Collectors.toList());
            Collections.shuffle(lottoNumList);
            return lottoNumList.stream().limit(6).collect(Collectors.toList());
    }
}

