package lotto.application;

import lotto.domain.*;

import java.util.List;

public class LottoService {

    private final LottoSeller lottoSeller;

    public LottoService(NumberGenerator numberGenerator) {
        this.lottoSeller = new LottoSeller(numberGenerator);
    }

    public UserLottoResult userLottoResult(User user, WinningLotto winningLotto) {
        return user.getUserLottoResult(winningLotto);
    }

    public User makeUser() {
        return new User(lottoSeller);
    }

    public int purchaseCount(User user) {
        return user.getLottos().size();
    }

    public WinningLotto makeWinningLotto(List<Integer> numbers, int bonusNumber) {
        return new WinningLotto(numbers, bonusNumber);
    }
}
