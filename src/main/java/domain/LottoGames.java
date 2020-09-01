package domain;

import java.util.Arrays;
import java.util.Optional;
import static domain.Rank.RANK_THREE;
import static domain.Rank.RANK_TWO;
import static utility.UserInput.WON;

public class LottoGames {

    public static final int LOTTO_NUMBER = 6;
    public static final int MIN_WINNER_NUMBER = 3;

    private Lottos lottos;
//    private RankRecord rankRecord;
//    private WinnerNumber winnerNumber;

//    public RankRecord getRankRecord() {
//        return rankRecord;
//    }

    public LottoGames(int price) {
        int tries = validatePrice(price);
        lottos = new Lottos();
//        rankRecord = new RankRecord();

        makeLottoTicket(tries);
    }

    public Lottos getLottos() {
        return lottos;
    }

    private void makeLottoTicket(int tries) {
        NumberGenerator generator = new NumberGenerator();

        for (int i = 0; i < tries; i++) {
            lottos.addLotto(new Lotto(generator.generate()));
        }
    }

    private int validatePrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price ERR!");
        }
        return price / WON;
    }

    public void getGameResult(WinnerNumber winnerNumber) {
//        calculateWinnerPrice(winnerNumber);
    }
}
