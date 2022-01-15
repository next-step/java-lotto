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

    public List<Lotto> addLottoTicket(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            lottoTickets.add(new Lotto());
        }
        return lottoTickets;
        //lottoTickets.stream().limit(lottoCount).forEach(lotto -> lottoTickets.add(new Lotto()));
    }


    //서비스 , 출력 부분
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
