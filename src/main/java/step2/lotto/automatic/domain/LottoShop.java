package step2.lotto.automatic.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoShop {

    private static final int MAKE_LOTTONUMBER_COUNT = 45; // 로또번호 생성 갯수
    private static final int MAKE_AUTO_NUMBER = 6; // 한게임당 필요한 번호 갯수
    private static LottoAutoMachine lottoAutoNumbers;

    public LottoShop() {
        initLottoShop();
    }

    private void initLottoShop() {
        lottoAutoNumbers = new LottoAutoMachine(MAKE_LOTTONUMBER_COUNT);
    }

    public static List<List<Integer>> buyLotto(int lottoBuyCount) {
        List<List<Integer>> lottoList = new ArrayList<>();
        List<Integer> lotto = new ArrayList<>();

        for (int i = lottoBuyCount; i > 0; i--) {
            lotto = lottoAutoNumbers.getAutoNumbers(MAKE_AUTO_NUMBER);
            Collections.sort(lotto);
            lottoList.add(lotto);
        }

        return lottoList;
    }
}
