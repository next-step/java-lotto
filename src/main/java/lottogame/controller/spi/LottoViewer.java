package lottogame.controller.spi;

import lottogame.domain.LottoTicket;
import lottogame.controller.response.LottoCheckResponse;

import java.util.List;

public interface LottoViewer {

    void draw(List<LottoTicket> lottoTickets);

    void draw(LottoCheckResponse lottoCheckResponse);
}
