package step2.dto;

import step2.domain.lotto.Lotto;

public final class LottoConfirmationRequestDto {

    private final Lotto lotto;


    private LottoConfirmationRequestDto(Lotto lotto) {
        this.lotto = lotto;
    }

    private LottoConfirmationRequestDto(String sentence) {
        this(Lotto.newInstance(sentence));
    }

    public static final LottoConfirmationRequestDto newInstance(Lotto lotto) {
        return new LottoConfirmationRequestDto(lotto);
    }

    public static final LottoConfirmationRequestDto newInstance(String sentence) {
        return new LottoConfirmationRequestDto(sentence);
    }

    public final Lotto getLotto() {
        return lotto;
    }
}
