package lottogame.controller.spi;

import lottogame.service.response.LottoCheckResponse;

public interface ResultCheckViewer {

    void draw(LottoCheckResponse lottoCheckResponse);

}
