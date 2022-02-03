package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private static final int LOTTO_PRICE = 1000;
    private final int lottoCounts;
    private final List<Lotto>lottoTickets;

    public LottoTickets(final int price) {
        this.lottoCounts = price / LOTTO_PRICE;
        this.lottoTickets = makeLottoTickets(lottoCounts);
    }

    private List<Lotto> makeLottoTickets(final int lottoCount) {
        final List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoTickets.add(new Lotto());
        }
        return lottoTickets;
    }

    public int getLottoCounts() {
        return this.lottoCounts;
    }

    public List<Lotto>getLottoTickets(){
        return lottoTickets;
    }

    public List<Integer> countCorrectWinNumber(LottoMachine lottoMachine){
        List<Integer>correctNumbers=new ArrayList<>();
        for (Lotto lotto:lottoTickets) {
            correctNumbers.add(lotto.compareLottoAndWinnerNumbers(lottoMachine));
        }
        return correctNumbers;
    }



}
