package lotto.domain;

import lotto.dto.WinningLottoDto;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public static WinningLotto from(WinningLottoDto winningLottoDto) {
        Lotto winningLotto = LottoMachine.create(winningLottoDto.winningNumbers());
        LottoNumber bonusNumber = LottoNumber.of(winningLottoDto.bonusNumber());

        return new WinningLotto(winningLotto, bonusNumber);
    }

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto lotto() {
        return lotto;
    }

    public LottoNumber bonusNumber() {
        return bonusNumber;
    }
}
