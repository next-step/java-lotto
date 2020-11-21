package lotto.domain;

import static lotto.domain.LottoGameConfig.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {

    private static List<Integer> lottoNumbers = IntStream.range(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER+1).boxed().collect(Collectors.toList());

    private List<LottoTicket> lottoTickets;

    private int gameMoney;

    public LottoTickets(int gameMoney) {

        this.gameMoney = gameMoney;
        this.lottoTickets = IntStream.range(0, gameMoney/LOTTO_GAME_MONEY_UNIT)
                .mapToObj(ticket -> new LottoTicket(makeLottoNumber()))
                .collect(Collectors.toList());
    }

    public int getGameMoney() {
        return this.gameMoney;
    }

    public int getTicketCount() {
        return lottoTickets.size();
    }

    private List<Integer> makeLottoNumber() {
        Collections.shuffle(lottoNumbers);
        List<Integer> randomLottoNumber  = lottoNumbers.stream().limit(LOTTO_TICKET_NUMBER_COUNT).collect(Collectors.toList());
        return randomLottoNumber;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

}
