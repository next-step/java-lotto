package domain;

import static utility.UserInput.WON;

public class LottoGames {

    public static final int LOTTO_NUMBER = 6;
    static final int MIN_WINNER_NUMBER = 3;

    private Lottos lottos;
    private int tries;

    public LottoGames(int input) {
        validatePrice(input);
        lottos = new Lottos();
    }

    public int getTries() {
        return tries;
    }

    public Lottos makeLottoTicket() {
        NumberGenerator generator = new NumberGenerator();

        for (int i = 0; i < tries; i++) {
            lottos.addLotto(new Lotto(generator.generate()));
        }
        return lottos;
    }

    private int validatePrice(int price) {
        if (price % WON != 0) {
            throw new IllegalArgumentException("Price ERR!");
        }
        return this.tries = price / WON;
    }
}
