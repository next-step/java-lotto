package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLottosGenerator implements LottosGenerator {
    private List<String> lottoValues;

    public ManualLottosGenerator(List<String> lottoValues) {
        this.lottoValues = lottoValues;
    }

    @Override
    public List<Lotto> generate(Money money) {
        if (lottoValues == null || lottoValues.isEmpty()) {
            throw new NullPointerException();
        }
        int count = lottoValues.size();
        money.deduct(moneyOfCount(count));
        return lottoValues.stream()
            .map(lottoValue -> Lotto.fromComma(lottoValue))
            .collect(Collectors.toList());
    }
}
