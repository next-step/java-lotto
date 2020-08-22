package domain;

import utility.UserInput;
import view.View;

import java.util.ArrayList;
import java.util.List;

public class LottoGames {
    private List<Lotto> lottos;
    private int[] winnerNumber;
    private int sum;
    private int[] rankRecord;

    public LottoGames() {
        lottos = new ArrayList<>();
        sum = 0;
        rankRecord = new int[5];
    }

    public void run() {
        int tries = UserInput.init();
        makeLottoTicket(tries);
        showLottoTickets();
        winnerNumber = UserInput.getWinnerTicket();

        calculateCount(tries);

        View.result(rankRecord, sum, tries);
    }

    private void calculateCount(int tries) {
        int count;
        for (int i = 0; i < tries; i++) {
            count = getCount(lottos.get(i));
            calculateWinnerRank(count);
        }
    }

    public void makeLottoTicket(int tries) {
        NumberGenerator generator = new NumberGenerator();
        generator.createLottoNumberCandidate();

        for (int i = 0; i < tries; i++) {
            this.lottos.add(new Lotto(generator.generate()));
        }
    }

    public void showLottoTickets() {
        for (int i = 0; i < lottos.size(); i++) {
            View.getLottoNumbers(lottos.get(i));
        }
    }


    private int getCount(Lotto lotto) {
        int count = 0;
        for (int j = 0; j < 6; j++) {
            if (lotto.getSixNumber().contains((winnerNumber[j]))) {
                count++;
            }
        }
        return count;
    }

    public void calculateWinnerRank(int count) {
        for (WinnerRanking rank : WinnerRanking.values()) {
            if (rank.getCount() == count) {
                sum += rank.getWinnerPrice();
                rankRecord[7 - count]++;
            }
        }
    }
}
