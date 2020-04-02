package lotto.service;

import lotto.domain.item.LottoGame;
import lotto.view.LottoDto;

public class LottoService {

    public LottoDto autoPlay(int gameCount) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.createAutoLottoTicket(0);

        LottoDto dto = new LottoDto();
//        dto.setTickets(this.lottoTickets.getTickets());

        return dto;
    }
}
