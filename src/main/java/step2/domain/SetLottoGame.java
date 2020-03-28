package step2.domain;

import step2.view.BuyLotto;
import step2.view.Lotto;

import java.util.*;

public class SetLottoGame {
    private List<Integer> lottoRangeList;
    private Lotto lotto;
    private BuyLotto buyLotto;

    public void startLotto(int totalPrice) {
        lotto = new Lotto();
        lottoRangeList = lotto.getLottoNumberList();
        int lottoCount = getTotalGame(totalPrice);
        buyLotto(lottoCount);
    }

    private void buyLotto(int lottoCount) {
        Set<List<Integer>> buyList = new HashSet<>();

        for (int i = 0; i < lottoCount; i++) {
            buyList.add(extractLottoNumber(lottoRangeList));
        }
        BuyLotto.setBuyLottoList(buyList);
    }

    public static List<Integer> extractLottoNumber(List<Integer> lottoNumberList) {
        Collections.shuffle(lottoNumberList);
        List<Integer> randomNumber = lottoNumberList.subList(0, Lotto.getSelectNumber());
        Collections.sort(randomNumber);

        return randomNumber;
    }

    public int getTotalGame(int totalPrice) {
        buyLotto = new BuyLotto(totalPrice, lotto.getPrice());
        return buyLotto.getBuyLottoCount();
    }
}
