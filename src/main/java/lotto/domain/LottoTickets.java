package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private static final int LOTTO_PRICE = 1000;
    private final int lottoCounts;
    private final List<Lotto> lottoTickets;
    private final LottoGenerator lottoGenerator=new RandomLottoGenerator();

    public LottoTickets(final int price) {
        this.lottoCounts = price / LOTTO_PRICE;
        this.lottoTickets = makeLottoTickets(lottoCounts);
    }

    private List<Lotto> makeLottoTickets(final int lottoCount) {
        final List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoTickets.add(new Lotto(lottoGenerator.generateLottoNumber()));
        }
        return lottoTickets;
    }

    public int getLottoCounts() {
        return this.lottoCounts;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public List<Integer> countCorrectWinNumber(final LottoMachine lottoMachine) {
        List<Integer> correctNumbers = new ArrayList<>();
        for (Lotto lotto : lottoTickets) {
            correctNumbers.add(lotto.compareLottoAndWinnerNumbers(lottoMachine));
        }
        return correctNumbers;
    }

    public List<Integer> checkBonusNumber(final LottoMachine lottoMachine) {
        final List<Integer> checkBonusNumber = new ArrayList<>();
        for (Lotto lotto : lottoTickets) {
            checkBonusNumber.add(lotto.compareLottoAndBonusNumbers(lottoMachine));
        }
        return checkBonusNumber;
    }

}
