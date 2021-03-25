package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoStore {
    public static final int LOTTO_PRICE = 1000;

    private LottoStore() {

    }

    public static List<Lotto> issue(String amount) {
        return issue(partInt(amount));
    }

    private static int partInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자값을 입력해주세요.");
        }
    }

    private static List<Lotto> issue(int amount) {
        int requestTicketCount = amount / LOTTO_PRICE;
        return IntStream.range(0, requestTicketCount)
                .mapToObj(i -> new Lotto())
                .collect(Collectors.toList());
    }


}
