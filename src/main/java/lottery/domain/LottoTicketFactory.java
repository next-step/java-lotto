package lottery.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import lottery.LottoConstants;

public class LottoTicketFactory {

    public static List<LottoTicket> generateRandomGames(int numberOfTicket) {
        List<LottoTicket> randomGames = new ArrayList<>();
        IntStream.range(0, numberOfTicket)
            .forEach(i -> randomGames.add(generateRandomGame()));
        return randomGames;
    }

    private static LottoTicket generateRandomGame() {
        Collections.shuffle(LottoConstants.LOTTO_NUMBERS, new Random());
        return new LottoTicket(LottoConstants.LOTTO_NUMBERS.subList(0, LottoConstants.LOTTO_TICKER_SIZE));
    }
}
