package study.step3.domain;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LottoTickets {
    private final static int INIT_INDEX = 0;
    private final static int LOTTO_PRICE_PER_PIECE = 1000;

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public int countLottoTickets(){
        return lottoTickets.size();
    }

    public List<LottoTicket> getLottoTickets() {
        return new ArrayList<>(lottoTickets);
    }

    public static LottoTickets publish(long lottoCounting) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (long i = INIT_INDEX; i < lottoCounting; i++){
            lottoTickets.add(LottoTicket.auto());
        }
        return new LottoTickets(lottoTickets);
    }

    public LottoResult confirmWinningResult(WinningLotto lastWinningNumbers) {
        return new LottoResult(checkLottoRank(lastWinningNumbers));
    }

    private WinningRanks checkLottoRank(WinningLotto lastWinningNumbers) {
        return lottoTickets.stream()
                           .map(lottoTicket -> lottoTicket.checkWinningRank(lastWinningNumbers))
                           .collect(collectingAndThen(toList(),WinningRanks::new));
    }
}