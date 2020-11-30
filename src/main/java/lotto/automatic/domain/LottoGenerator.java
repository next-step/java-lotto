package lotto.automatic.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoGenerator {

    private static final List<LottoNumber> lottoNum = IntStream.rangeClosed(1, 45)
            .mapToObj(LottoNumber::new)
            .collect(toList());


    private final ShuffleStrategy strategy;

    public LottoGenerator(ShuffleStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Lotto> generateLotto(int countOfLotto) {

        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < countOfLotto; i++) {
            strategy.shuffle(lottoNum);
            lottoList.add(new Lotto(lottoNum.stream()
                    .limit(6)
                    .collect(toList())));
        }

        return lottoList;
    }

}
