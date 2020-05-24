package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoShop {

    private static final LottoGenerator LOTTO_GENERATOR = new LottoGenerator();

    public List<LottoTicket> buy(int amount) {
        return IntStream.range(0, amount)
                .boxed()
                .map(integer -> LOTTO_GENERATOR.autoGenerate())
                .collect(Collectors.toList());
    }
}
