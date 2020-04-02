package lotto.service;

import lotto.domain.item.LottoGame;
import lotto.domain.item.LottoNumbers;
import lotto.view.LottoDto;

import java.util.List;

public class LottoService {

    public LottoDto autoPlay(int gameCount) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.createAutoLottoTicket(0);

        LottoDto dto = new LottoDto();
        return dto;
    }

    public LottoDto passivityPlay(List<LottoNumbers> numbers) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.createPassivityLottoTicket(numbers);

        LottoDto dto = new LottoDto();
        return dto;
    }
}
