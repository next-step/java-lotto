package lotto_auto.domain;

import lotto_auto.service.LottoService;

import java.util.Set;

public class LottoWinner {
    private final Set<Integer> winnerNumbers;

    public LottoWinner(String input) {
        this.winnerNumbers = LottoService.validateLottoWinner(input);
    }

    public Set<Integer> getWinnerNumbers() {
        return winnerNumbers;
    }

}
