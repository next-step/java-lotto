package lotto.step2.domain;

import java.util.*;

public class Lotto {
    private static final int LOTTO_PRICE = 1000;
    private List<LottoTicket> lottoTickets;

    public Lotto(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("돈이 부족합니다. 로또 1장의 가격은 "+LOTTO_PRICE+"원입니다.");
        }
        this.lottoTickets = new ArrayList<>();
        for (int i = 0; i < money; i++) {
            buyLotto(LottoMachine.mixLottoNumbers());
        }
    }

    @Override
    public String toString() {
        return lottoTickets.toString();
    }

    public void buyLotto(List<LottoNumber> lottoNumbers) {
        lottoTickets.add(new LottoTicket(new HashSet<>(lottoNumbers)));
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public void matchLottoTicket(LottoResult lottoResult) {
        for (LottoTicket lottoTicket : this.lottoTickets) {
            lottoResult.checkLottoTicket(lottoTicket);
        }
    }

    public LottoResult matchLottoTicket2(LottoTicket winningNumber) {
        Map<Integer , Integer> map = new HashMap<>();
        for (LottoTicket lottoTicket : this.lottoTickets) {
            int matchCount = lottoTicket.matchWinningNumber(winningNumber);
            WinningRank findRank = WinningRank.findWinningRank(matchCount);
        }
        return new LottoResult();
    }


}
