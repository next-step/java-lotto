package lotto.domain;

import lotto.dto.WinningLottoDto;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public static WinningLotto from(WinningLottoDto winningLottoDto) {
        Lotto winningLotto = LottoFactory.create(winningLottoDto.winningNumbers());
        LottoNumber bonusNumber = LottoNumber.of(winningLottoDto.bonusNumber());

        return new WinningLotto(winningLotto, bonusNumber);
    }

    public WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto winningLotto() {
        return winningLotto;
    }

    public LottoNumber bonusNumber() {
        return bonusNumber;
    }
}
