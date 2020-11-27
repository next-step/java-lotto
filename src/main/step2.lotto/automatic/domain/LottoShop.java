package step2.lotto.automatic.domain;

import step2.lotto.automatic.domain.numbers.LottoMachine;

import java.util.*;

public class LottoShop {

    private static final int MAKE_LOTTONUMBER_COUNT = 45; // 로또번호 생성 갯수
    private static final int MAKE_AUTO_NUMBER = 6; // 한게임당 필요한 번호 갯수
    private static LottoMachine lottoMachine;

    public LottoShop() {
        lottoMachine = new LottoMachine(MAKE_LOTTONUMBER_COUNT);
    }

    public static Set<List<Integer>> buyAutoLotto(int lottoBuyCount) {
        Set<List<Integer>> returnSet = new HashSet<>();
        List<Integer> lotto = new ArrayList<>();

        for (int i = lottoBuyCount; i > 0; i--) {
            lotto = lottoMachine.getAutoNumbers(MAKE_AUTO_NUMBER);
            Collections.sort(lotto);
            returnSet.add(lotto);
        }

        return returnSet;
    }
}
