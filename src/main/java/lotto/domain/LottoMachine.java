package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private int buyLottoPrice;

    private final List<LottoTicket> lottoTickets;

    private final static int LOTTO_PRICE = 1000;

    private WinningLottoTicket winningLottoNumbers;

    public LottoMachine(int buyLottoPrice) {
        this(buyLottoPrice, buyRandomLotto(buyLottoPrice));
    }

    public LottoMachine(int buyLottoPrice, List<LottoTicket> lottoTickets){
        this.lottoTickets = lottoTickets;
        this.buyLottoPrice = buyLottoPrice;
        vaildLottoMachine(buyLottoPrice, lottoTickets);
    }

    public void vaildLottoMachine(int buyLottoPrice, List<LottoTicket> lottoTickets) {
        if (buyLottoPrice < LOTTO_PRICE
                || buyLottoPrice % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구매 금액 에러");
        }

        if (lottoTickets.size() != buyLottoPrice / LOTTO_PRICE) {
            throw new IllegalArgumentException("수동 로또 갯수 에러");
        }

    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    private static List<LottoTicket> buyRandomLotto(int buyLottoPrice) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < buyLottoPrice / LOTTO_PRICE; i++) {
            lottoTickets.add(new LottoTicket());
        }

        return lottoTickets;
    }

    public void saveWinningNumber(LottoTicket winningLottoNumbers, int bounsNumber) {
        this.winningLottoNumbers = new WinningLottoTicket(winningLottoNumbers, bounsNumber);
    }

    public WinningLottoTicket getWinningLottoNumbers() {
        return this.winningLottoNumbers;
    }
}
