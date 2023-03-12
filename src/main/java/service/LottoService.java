package service;

import java.util.ArrayList;
import java.util.List;

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
        InputView.printLottoList(lottos.getLottos());

    }

    public void setFirstPlaceLotto(String input, String bonusLottoNumber) {
        firstPlaceLotto = new FirstPlaceLotto(input, bonusLottoNumber);
    }

    List<Lotto> makeLottoList(int lottoCount) {
        List<Lotto> lottoList = new ArrayList<Lotto>();
        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(i, new Lotto());
        }

        return lottoList;
    }

    public void calculateLottoRank() {
        lottos.calculateLottoRank(firstPlaceLotto);
    }

    public void printLottoResult() {
        ResultView.printLottoResult(lottos);
    }
}
