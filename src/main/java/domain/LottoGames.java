package domain;

public class LottoGames {

    public static final int LOTTO_NUMBER = 6;
    public static final int MIN_WINNER_NUMBER = 3;

    private Lottos lottos;

    public LottoGames(int input) {
        int tries = validatePrice(input);
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
        if (price <= 0) {
            throw new IllegalArgumentException("Price ERR!");
        }
        return price;
    }
}
