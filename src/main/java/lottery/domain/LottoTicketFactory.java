package lottery.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketFactory {

    public static List<LottoTicket> generateRandomGames(int numberOfTicket) {
        return IntStream.range(0, numberOfTicket)
            .mapToObj(i -> LottoTicket.ofRandom())
            .collect(Collectors.toList());
    }

}
