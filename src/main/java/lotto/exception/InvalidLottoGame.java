package lotto.exception;

public class InvalidLottoGame extends RuntimeException {
    public static String INVALID_LOTTO_GAME = "INVALID LOTTO GAME";

    public InvalidLottoGame() {
        super(INVALID_LOTTO_GAME);
    }

    public InvalidLottoGame(String message) {
        super(message);
    }
}
