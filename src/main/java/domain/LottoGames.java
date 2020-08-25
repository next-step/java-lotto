package domain;

import utility.UserInput;
import view.View;

public class LottoGames {

    public static final int LOTTO_NUMBER = 6;
    private static final int MIN_WINNER_NUMBER = 3;

    private Lottos lottos;
    private WinnerNumber winnerNumber;

    public LottoGames() {
        lottos = new Lottos();
    }

    public Lottos run(int tries) {
        return lottos =  makeLottoTicket(tries);

//        View.showLottoTickets(lottos);
//        winnerNumber = UserInput.getWinnerTicket();

        int sum = calculateCount(tries);

        View.result(winnerNumber, sum, tries);
    }


    private Lottos makeLottoTicket(int tries) {
        NumberGenerator generator = new NumberGenerator();

        for (int i = 0; i < tries; i++) {
            lottos.addLotto(new Lotto(generator.generate()));
        }
    }

    private int calculateCount(int tries) {
        int count;
        int sum = 0;

        for (int i = 0; i < tries; i++) {
            count = countNumber(lottos.getOneLotto(i));

            if (count > MIN_WINNER_NUMBER) {
                sum += winnerNumber.calculateWinnerRank(count);
            }
        }
        return sum;
    }

    private int countNumber(Lotto lotto) {
        int count = 0;
        for (int j = 0; j < LOTTO_NUMBER; j++) {
            if (lotto.getLottoNumber().contains((winnerNumber.getWinnerNumber()[j]))) {
                count++;
            }
        }
        return count;
    }
}
