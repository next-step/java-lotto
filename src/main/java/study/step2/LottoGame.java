package study.step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoGame {
    private final int LOTTO_PRICE_PER_PIECE = 1000;

    private final long price;

    public LottoGame(long price) {
        this.price = price;
    }

    public List<LottoTicket> buyLotto(LottoNumberGenerator numberGenerator) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        long lottoCount = convertMoneyToLottoTickets();
        for (long i = 0; i < lottoCount; i++){
            lottoTickets.add(new LottoTicket(numberGenerator));
        }
        return lottoTickets;
    }

    public double getEarningsRate(long prizeMoney ){
        return (int)(prizeMoney / (double)price * 100) / 100.0;
    }

    public long getPrice(){
        return price;
    }

    private long convertMoneyToLottoTickets() {
        return price/LOTTO_PRICE_PER_PIECE;
    }
}
