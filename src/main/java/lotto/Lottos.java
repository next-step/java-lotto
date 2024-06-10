package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private final List<Lotto> lottos;
    private Integer count;
    private static final Integer UNIT_PRICE = 1000;

    private List<Integer> lottoOriginValue;

    public Lottos(final int amount) {
        lottoOriginValue = IntStream.range(1, 46).boxed().collect(Collectors.toList());
        lottos = new ArrayList<>();
        this.count = amount / UNIT_PRICE;
    }

    public void generate() {
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(generateRandomNumbers()));
        }
    }

    public Integer getSize() {
        return lottos.size();
    }

    private List<LottoNumber> generateRandomNumbers() {
                Collections.shuffle(lottoOriginValue);
        return lottoOriginValue.stream()
                .map(n -> new LottoNumber(n))
                .collect(Collectors.toList());
    }

    public void checkNumberLastWeek(LastWeekWinningNumber lastWeekMatched) {

    }
}
