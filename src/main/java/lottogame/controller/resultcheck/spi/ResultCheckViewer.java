package lottogame.controller.resultcheck.spi;

import lottogame.domain.response.LottoCheckedResponse;

public interface ResultCheckViewer {

    void draw(LottoCheckedResponse lottoCheckedResponse);

}
