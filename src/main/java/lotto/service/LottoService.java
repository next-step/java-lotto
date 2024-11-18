package lotto.service;

import lotto.domain.Games;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;

public class LottoService {

    public Games purchaseLotto(int money) {
        return new Games(money);
    }

    public LottoNumbers findWinner(String input) {
        return new LottoNumbers(input);
    }

    public LottoResult checkResult(LottoNumbers winner, LottoNumber bonusLottoNumber, Games games) {
        return new LottoResult(winner, bonusLottoNumber, games);
    }
}
