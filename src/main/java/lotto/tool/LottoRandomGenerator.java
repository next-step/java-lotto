package lotto.tool;

import lotto.domain.LottoBall;
import lotto.domain.LottoBasicNumber;
import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class LottoRandomGenerator implements LottoGenerator {

    private final int autoCount;

    public LottoRandomGenerator(int autoCount) {
        this.autoCount = autoCount;
    }

    @Override
    public List<LottoTicket> generate() {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < autoCount; i++) {
            shuffle();
            addRandomTickets(lottoTickets);
        }
        return lottoTickets;
    }

    private void addRandomTickets(List<LottoTicket> lottoTickets) {
        List<LottoBall> lottoBalls = new ArrayList<>();

        for (int j = 0; j < LottoTicket.LOTTO_SIZE; j++) {
            lottoBalls.add(LottoBasicNumber.basicNumbers.get(j));
        }
        sort(lottoBalls);
        lottoTickets.add(new LottoTicket(lottoBalls));
    }

    private void shuffle() {
        LottoShuffler.shuffle(LottoBasicNumber.basicNumbers);
    }

    @Override
    public List<LottoBall> sort(List<LottoBall> lottoBalls) {
        return null;
    }
}
