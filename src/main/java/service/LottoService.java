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

        lottos = new Lottos(makeLottoList(lottoCount));
        ResultView.printLottoList(lottos.getLottos());

    }

    public LottoService(int money, int manualLottoCount) {
        List<Lotto> newLottos = new ArrayList<>();

        ResultView.printManualLottoInput();

        int autoLottoCount = money / LottoPrice.PRICE.getPrice() - manualLottoCount;

        IntStream.range(0, manualLottoCount).forEach(it -> {
            String stringLotto = InputView.scanManualLotto();
            newLottos.add(new Lotto(stringLotto));
        });

        newLottos.addAll(makeLottoList(autoLottoCount));

        ResultView.printBuyManualAndAutoCount(manualLottoCount, autoLottoCount);
        ResultView.printLottoList(newLottos);

        this.lottos = new Lottos(newLottos);
    }

    public void setFirstPlaceLotto(String input, String bonusLottoNumber) {
        firstPlaceLotto = new FirstPlaceLotto(input, bonusLottoNumber);
    }

    List<Lotto> makeLottoList(int lottoCount) {
        List<Lotto> lottoList = new ArrayList<Lotto>();

        IntStream.range(0, lottoCount)
                .forEach(it -> lottoList.add(it, new Lotto()));

        return lottoList;
    }

    public void printLottoResult() {
        ResultView.printLottoResult(lottos, firstPlaceLotto);
    }
}
