package lottery.domain;

import java.util.List;
import lottery.dto.LottoTries;

public class LottoTicketSeller {

    public static LottoTickets purchaseRandomGames(int randomTries) {
        return new LottoTickets(generateRandomGames(randomTries));
    }

    public static LottoTickets purchaseRandomGames(LottoTickets lottoTickets, LottoTries lottoTries) {
        lottoTickets.append(purchaseRandomGames(lottoTries.getRandomTries()));
        return lottoTickets;
    }

    private static List<LottoTicket> generateRandomGames(int numberOfTicket) {
        return LottoTicketFactory.generateRandomGames(numberOfTicket);
    }
}
