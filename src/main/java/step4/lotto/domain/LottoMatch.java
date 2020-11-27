package step4.lotto.domain;

import step4.lotto.domain.numbers.LottoTicket;
import step4.lotto.domain.numbers.LottoWinningNumber;

import java.util.Iterator;
import java.util.Set;

public class LottoMatch {

    private static final int MATCH_LOTTE_MAX_COUNT = 5;
    private static final int MATCH_LOTTE_MIN_COUNT = 1;

    private String winningNumbers;
    private Set<LottoTicket> buyLottoHashSet;
    private int bonusNumber;

    public LottoMatch(String winningNumbers, Set<LottoTicket> buyLottoHashSet, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.buyLottoHashSet = buyLottoHashSet;
        this.bonusNumber = bonusNumber;
    }

    public void playLottoMatch() {
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(winningNumbers, bonusNumber);

        Iterator it = buyLottoHashSet.iterator();

        while (it.hasNext()) {
            addWinningCount((LottoTicket) it.next(), lottoWinningNumber);
        }
    }


    private void addWinningCount(LottoTicket lottoTicket, LottoWinningNumber lottoWinningNumber) {
        int rank = lottoWinningNumber.getRank(lottoTicket.getLottoTicket());

        if (rank >= MATCH_LOTTE_MIN_COUNT && rank <= MATCH_LOTTE_MAX_COUNT) {
            LottoStatusEnum.findByCount(rank).addWinningCount();
        }
    }
}
