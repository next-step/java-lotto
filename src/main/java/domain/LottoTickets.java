package domain;

import java.util.*;

public class LottoTickets {
    private final List<Lotto> lottoTickets;
    private int totalPrize;

    public LottoTickets() {
        this.lottoTickets = new ArrayList<>();
    }

    public List<Lotto> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    //테스트 코드에서 Lotto 들을 맘대로 넣을 수 없어서 수정
    public void addLottoTicket(Lotto lotto) {
        lottoTickets.add(lotto);
    }

    public Map<Integer, Integer> checkLottoAnswer(List<Integer> answerNumbers) {
        Map<Integer, Integer> lottoResult = new HashMap<>();
        for (Lotto lotto : lottoTickets) {
            int matchCount = lotto.checkLottoNumbers(answerNumbers);
            int count = lottoResult.getOrDefault(matchCount, 0);
            lottoResult.put(matchCount, count + 1);
        }
        return lottoResult;
    }


    public void calculateLottoTotalPrize() {
        for (Lotto lotto : lottoTickets) {
            totalPrize += Prize.prizes[lotto.getMatchCount()];
        }
    }

    public String calculateLottoRatio(int purchasePrice) {
        return String.format("%.2f", (double) totalPrize / (double) purchasePrice);
    }

}
