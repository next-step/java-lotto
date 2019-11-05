package lottery.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketFactory {

    private static final List<Integer> LOTTO_NUMBERS = IntStream.range(1, 46)
                                                                .boxed()
                                                                .collect(Collectors.toList());



    public static List<LottoTicket> generateRandomGames(int numberOfTicket) {
        List<LottoTicket> randomGames = new ArrayList<>();
        IntStream.range(0, numberOfTicket)
            .forEach(i -> randomGames.add(generateRandomGame()));
        return randomGames;
    }

    private static LottoTicket generateRandomGame() {
        Collections.shuffle(LOTTO_NUMBERS, new Random());
        return new LottoTicket(LOTTO_NUMBERS.subList(0, 6));
    }
}
