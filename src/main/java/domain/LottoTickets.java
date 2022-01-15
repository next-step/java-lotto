package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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


    public int[] checkLottoAnswer(List<Integer> answerNumbers) {
        final int[] lottoResult = new int[7];
        for (Lotto lotto : lottoTickets) {
            lottoResult[lotto.checkLottoNumbers(answerNumbers)]++;
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
