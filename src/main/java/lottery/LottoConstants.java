package lottery;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoConstants {

    public static final Integer TICKET_PRICE = 1000;
    public static final Integer LOTTO_TICKER_SIZE = 6;
    public static final List<Integer> LOTTO_NUMBERS = IntStream.range(1, 46)
                                                               .boxed()
                                                               .collect(Collectors.toList());
}
