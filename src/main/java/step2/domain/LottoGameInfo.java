package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoGameInfo {
    private int price;
    private int countOfTicket;
    private int matchCount;
    private List<Integer> winningInfomations;
    private List<Lotto> lottoTickets;


    public LottoGameInfo(int price) {
        validatePrice(price);
        this.price = price;
        this.countOfTicket = ticketCount(price);
        this.lottoTickets = generateLottoTickets(this.countOfTicket);
        this.winningInfomations = new ArrayList<>();
        this.matchCount = 0;
    }

    public int ticketCount(int price) {
        return price / 1000;
    }

    public void validatePrice(int price) {
        if (price < LottoConstant.LOTTO_PRICE) {
            throw new IllegalArgumentException(LottoConstant.VALID_LOTTO_PRICE_MESSAGE);
        }
    }

    public List<Lotto> generateLottoTickets(int countOfTicket) {
        lottoTickets = new ArrayList<>();
        for (int i = 0; i < countOfTicket; i++) {
            lottoTickets.add(new Lotto());
        }
        return lottoTickets;
    }


    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public List<Integer> getWinningInfomations() {
        return winningInfomations;
    }

    public int getCountOfTicket() {
        return countOfTicket;
    }
}
