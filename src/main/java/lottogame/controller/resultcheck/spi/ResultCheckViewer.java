package lottogame.controller.resultcheck.spi;

import java.util.List;
import lottogame.domain.LottoPrize;

public interface ResultCheckViewer {

    void draw(List<LottoPrize> lottoPrizes);

}
