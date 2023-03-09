package service;

import java.util.ArrayList;
import java.util.List;

import domain.Lotto;
import domain.LottoList;
import domain.LottoPrice;
import view.InputView;

public class LottoService {

    public LottoService(int money) {
        int lottoCount = money / LottoPrice.PRICE.getPrice();
        InputView.printBuyCount(lottoCount);

        LottoList lottoList = new LottoList(makeLottoList(lottoCount));
        InputView.printLottoList(lottoList.getLottoList());

    }

    List<Lotto> makeLottoList(int lottoCount) {
        List<Lotto> lottoList = new ArrayList<Lotto>();
        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(i, new Lotto());
        }

        return lottoList;
    }
}
