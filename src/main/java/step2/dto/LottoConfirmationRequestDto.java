package step2.dto;

import step2.domain.lotto.Lotto;

public final class LottoConfirmationRequestDto {

    private final Lotto lotto;

    public static final LottoConfirmationRequestDto newInstance(Lotto lotto) {
        return new LottoConfirmationRequestDto(lotto);
    }

    public static final LottoConfirmationRequestDto newInstance(String sentence) {
        return new LottoConfirmationRequestDto(sentence);
    }

    private LottoConfirmationRequestDto(String sentence) {
        this(Lotto.newInstance(sentence));
    }

    private LottoConfirmationRequestDto(Lotto lotto) {
        this.lotto = lotto;
    }




    public final Lotto getLotto() {
        return lotto;
    }
}
