package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {

    private static List<Integer> lottoNumbers = IntStream.range(1, 46).boxed().collect(Collectors.toList());

    private List<LottoTicket> lottoTickets;

    private int ticketCount;
    private int gameMoney;

    public LottoTickets(int gameMoney) {
        this.gameMoney = gameMoney;
        this.ticketCount = gameMoney/1000;
        this.lottoTickets = IntStream.range(0, ticketCount)
                .mapToObj(ticket -> new LottoTicket(makeLottoNumber()))
                .collect(Collectors.toList());
    }

    public int getGameMoney() {
        return this.gameMoney;
    }

    public int getTicketCount() {
        return this.ticketCount;
    }

    private List<Integer> makeLottoNumber() {
        Collections.shuffle(lottoNumbers);
        List<Integer> randomLottoNumber  = lottoNumbers.stream().limit(6).collect(Collectors.toList());
        return randomLottoNumber;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

}
