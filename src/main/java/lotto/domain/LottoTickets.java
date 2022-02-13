package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<WinningResult> calculateWinningResult(final LottoMachine lottoMachine){
        return lottoTickets.stream().map(winningResult -> new WinningResult(
            winningResult.compareLottoAndWinnerNumbers(lottoMachine),
            winningResult.compareLottoAndBonusNumbers(lottoMachine))).collect(
            Collectors.toList());
    }


}
