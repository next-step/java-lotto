package lottery.domain;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lottery.LottoConstants;

public class LottoTicketFactory {

    public static List<LottoTicket> generateRandomGames(int numberOfTicket) {
        return IntStream.range(0, numberOfTicket)
            .mapToObj(i -> generateRandomGame())
            .collect(Collectors.toList());
    }

    private static LottoTicket generateRandomGame() {
        Collections.shuffle(LottoConstants.LOTTO_NUMBERS, new Random());
        return new LottoTicket(LottoConstants.LOTTO_NUMBERS.subList(0, LottoConstants.LOTTO_TICKER_SIZE));
    }
}
