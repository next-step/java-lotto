package lottogame.controller.resultcheck.spi;

import lottogame.service.response.LottoCheckResponse;

public interface ResultCheckViewer {

    void draw(LottoCheckResponse lottoCheckResponse);

}
