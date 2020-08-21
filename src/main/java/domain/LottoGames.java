package domain;

import utility.UserInput;
import view.ShowResult;

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
        winnerNumber = UserInput.getLastWinnerNumber();
        calculateWinner();
        ShowResult.result(rankRecord,sum,tries);
    }

    public void makeLottoTicket(int tries) {
        NumberGenerator generator = new NumberGenerator();
        generator.createLottoNumberCandidate();

        for (int i = 0; i < tries; i++) {
            this.lottos.add(new Lotto(generator.generate()));
        }
    }

    public void calculateWinner() {
        Lotto lotto;

        for (int i = 0; i < lottos.size(); i++) {
            lotto = lottos.get(i);

            int count = getCount(lotto);
//            System.out.println(" count is " + count);
            if(count >=3 ){
                calculateWinnerRank(count);
            }
        }
    }

    private int getCount(Lotto lotto) {
        int count = 0;
        for (int j = 0; j < 6; j++) {
            System.out.print(" " + lotto.getSixNumber().get(j));
            if (lotto.getSixNumber().contains((winnerNumber[j]))) {
                count++;
            }
        }
        System.out.println();
        return count;
    }


    public void calculateWinnerRank(int count) {
        for (WinnerRanking rank: WinnerRanking.values()) {
            if(rank.getCount() == count ){
                sum += rank.getWinnerPrice();
                rankRecord[7-count]++;
            }
        }
        System.out.println("Sum is "+  sum);
    }
}
