package domain;

import utility.UserInput;
import view.View;

public class LottoGames {

    public static final int LOTTO_NUMBER = 6;
    private static final int MIN_WINNER_NUMBER = 3;

    private Lottos lottos;
    private WinnerNumber winnerNumber;
    private int sum;

    public LottoGames() {
        lottos = new Lottos();
        sum = 0;
    }

    public void run() {
        int tries = UserInput.init();
        makeLottoTicket(tries);
        View.showLottoTickets(lottos);
        winnerNumber = UserInput.getWinnerTicket();

        calculateCount(tries);

        View.result(winnerNumber, sum, tries);
    }


    private void makeLottoTicket(int tries) {
        NumberGenerator generator = new NumberGenerator();
        generator.createLottoNumberCandidate();

        for (int i = 0; i < tries; i++) {
            lottos.addLotto(new Lotto(generator.generate()));
        }
    }

    private void calculateCount(int tries) {
        int count;

        for (int i = 0; i < tries; i++) {
            count = countNumber(lottos.getOneLotto(i));

            if (count > MIN_WINNER_NUMBER) {
                sum += winnerNumber.calculateWinnerRank(count);
            }
        }
    }

    private int countNumber(Lotto lotto) {
        int count = 0;
        for (int j = 0; j < LOTTO_NUMBER; j++) {
            if (lotto.getSixNumber().contains((winnerNumber.getWinnerNumber()[j]))) {
                count++;
            }
        }
        return count;
    }
}
