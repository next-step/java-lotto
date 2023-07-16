package lottogame.controller.spi;

import lottogame.controller.response.LottoCheckResponse;
import lottogame.domain.LottoTickets;

public interface LottoViewer {

    void draw(LottoTickets lottoTickets);

    void draw(LottoCheckResponse lottoCheckResponse);
}
