package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import domain.FirstPlaceLotto;
import domain.Lotto;
import domain.Lottos;
import domain.type.LottoPrice;
import view.InputView;
import view.ResultView;

public class LottoService {
    Lottos lottos;
    FirstPlaceLotto firstPlaceLotto;

    public LottoService(int money) {
        int lottoCount = money / LottoPrice.PRICE.getPrice();
        InputView.printBuyCount(lottoCount);

        lottos = new Lottos(lottoCount);
        ResultView.printLottoList(lottos.getLottos());

    }

    public LottoService(int money, int manualLottoCount) {
        ResultView.printManualLottoInput();
        int autoLottoCount = money / LottoPrice.PRICE.getPrice() - manualLottoCount;
        this.lottos = new Lottos(manualLottoCount, autoLottoCount);
        ResultView.printBuyManualAndAutoCount(manualLottoCount, autoLottoCount);
        ResultView.printLottoList(lottos.getLottos());
    }

    public void setFirstPlaceLotto(String input, String bonusLottoNumber) {
        firstPlaceLotto = new FirstPlaceLotto(input, bonusLottoNumber);
    }

    public void printLottoResult() {
        ResultView.printLottoResult(lottos, firstPlaceLotto);
    }
}
