package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.strategy.RandomGenerateStrategy;

public class LottoTicketGenerator {

    private static final String NOT_PURCHASEABLE_EXCEPTION_MESSAGE = "[ERROR] 1000원 단위로 입력해주세요.";
    private static final int LOTTO_PRICE = 1_000;
    private static final int ZERO = 0;

    final LottoTicket lottoTicket;

    private LottoTicketGenerator(LottoTicket lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public static LottoTicketGenerator from(Price price) {
        validatePrice(price.getValue());
        LottoTicket lottoTicket = generateLottoTicketFromPrice(price);

        return new LottoTicketGenerator(lottoTicket);
    }

    public LottoTicket getLottoTicket() {
        return lottoTicket;
    }

    private static LottoTicket generateLottoTicketFromPrice(Price price) {
        int count = convertPriceToCount(price.getValue());
        List<Lotto> lottoTicket = generateLottoTicket(count);

        return LottoTicket.of(lottoTicket, price.getValue());
    }

    private static List<Lotto> generateLottoTicket(int count) {
        return IntStream.range(ZERO, count)
            .mapToObj(
                index -> LottoGenerator.of(RandomGenerateStrategy.getInstance()).getLotto()
            )
            .collect(Collectors.toList());
    }

    private static int convertPriceToCount(int price) {
        return price / LOTTO_PRICE;
    }

    private static void validatePrice(int price) {
        if (!isPurchasable(price)) {
            throw new IllegalArgumentException(NOT_PURCHASEABLE_EXCEPTION_MESSAGE);
        }
    }

    private static boolean isPurchasable(int price) {
        return price >= LOTTO_PRICE && price % LOTTO_PRICE == 0;
    }

}
