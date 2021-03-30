package step2.dto;

import step2.domain.lotto.Lotto;

public final class LottoWinningCheckRequestDto {

    private final Lotto winningLotto;

    public static final LottoWinningCheckRequestDto newInstance(Lotto lotto) {
        return new LottoWinningCheckRequestDto(lotto);
    }

    public static final LottoWinningCheckRequestDto newInstance(String sentence) {
        return new LottoWinningCheckRequestDto(sentence);
    }

    private LottoWinningCheckRequestDto(String sentence) {
        this(Lotto.of(sentence));
    }

    private LottoWinningCheckRequestDto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public final Lotto getWinningLotto() {
        return winningLotto;
    }
}
