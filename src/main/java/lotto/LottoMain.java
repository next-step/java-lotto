package lotto;

import lotto.domain.Lotto;
import lotto.service.LottoService;

import java.util.ArrayList;
import java.util.List;

import static lotto.util.Util.floorDiv;
import static lotto.util.Util.split;
import static lotto.view.IoView.*;
import static lotto.view.OutView.printResult;

public class LottoMain {
    public static void main(String[] args) {
        int money = inputMoney();

        LottoService lottoService = new LottoService(generateLottoList(money));
        printLottoList(lottoService.getLottoList());

        lottoService.playLotto(split(inputWinningNumbers()));
        printResult(money, lottoService.getMatchPointMap());
    }

    private static List<Lotto> generateLottoList(int money) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < floorDiv(money); i++) {
            Lotto lotto = new Lotto();
            lottoList.add(lotto);
        }
        return lottoList;
    }

}
