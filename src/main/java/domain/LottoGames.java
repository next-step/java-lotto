package domain;

import static utility.UserInput.WON;

public class LottoGames {

    private Lottos lottos;

    public LottoGames(int price) {
        int tries = validatePrice(price);
        lottos = new Lottos();

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
}
