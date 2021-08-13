package lotto.step2.domain;

import java.util.*;

public class Lotto {
    private static final int LOTTO_PRICE = 1000;
    private List<LottoTicket> lottoTickets;

    public Lotto(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("돈이 부족합니다. 로또 1장의 가격은 " + LOTTO_PRICE + "원입니다.");
        }
        this.lottoTickets = new ArrayList<>();
        int lottoCount = money / LOTTO_PRICE;
        for (int i = 0; i < lottoCount; i++) {
            generate(LottoMachine.mixLottoNumbers());
        }
    }

    public Lotto(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    @Override
    public String toString() {
        return lottoTickets.toString();
    }

    public void generate(List<LottoNumber> lottoNumbers) {
        lottoTickets.add(new LottoTicket(new HashSet<>(lottoNumbers)));
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public LottoResult matchLottoTicket(LottoTicket winningNumber) {
        Map<WinningRank, Integer> winningRankInfo = new HashMap<>();
        for (LottoTicket lottoTicket : this.lottoTickets) {
            int matchCount = lottoTicket.matchWinningNumber(winningNumber);
            WinningRank findRank = WinningRank.findWinningRank(matchCount);
            winningRankInfo.put(findRank,winningRankInfo.getOrDefault(findRank,0)+1);
        }
        return new LottoResult(winningRankInfo);
    }
}
