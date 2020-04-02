package lotto.service;

import lotto.domain.item.LottoGame;
import lotto.domain.item.LottoNumbers;
import lotto.domain.item.LottoTickets;
import lotto.view.LottoDto;

import java.util.List;

public class LottoService {

    public LottoDto autoPlay(int gameCount) {
        LottoGame lottoGame = new LottoGame();
        LottoTickets tickets = lottoGame.createAutoLottoTicket(gameCount);

        LottoDto dto = new LottoDto();
        dto.setTickets(tickets);
        return dto;
    }

    public LottoDto passivityPlay(List<LottoNumbers> numbers) {
        LottoGame lottoGame = new LottoGame();
        LottoTickets tickets = lottoGame.createPassivityLottoTicket(numbers);

        LottoDto dto = new LottoDto();
        dto.setTickets(tickets);
        return dto;
    }
}
