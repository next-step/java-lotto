package lotto.domain.exception;

public class CannotBeGreaterPlayableLottoCount extends RuntimeException {

    private static final CannotBeGreaterPlayableLottoCount CANNOT_BE_GREATER_PLAYABLE_LOTTO_COUNT =
            new CannotBeGreaterPlayableLottoCount("플레이 가능한 수 보다 큰 수는 입력될 수 없습니다.");

    private CannotBeGreaterPlayableLottoCount(String message) {
        super(message);
    }

    public static CannotBeGreaterPlayableLottoCount getInstance() {
        return CANNOT_BE_GREATER_PLAYABLE_LOTTO_COUNT;
    }
}
