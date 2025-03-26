package lotto;

import java.util.List;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Seller {
    public static List<Lotto> sell(int money) {
        int lottoCount = money/Lotto.PRICE;

        return IntStream.range(0, lottoCount)
                .mapToObj(it -> LottoTicketMachine.issue())
                .collect(Collectors.toUnmodifiableList());
    }
}
