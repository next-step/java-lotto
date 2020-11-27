package step4.lotto.domain;

import step4.lotto.domain.numbers.LottoMachine;
import step4.lotto.domain.numbers.LottoTicket;

import java.util.*;

public class LottoShop {
    private static final int MAKE_AUTO_NUMBER = 6; // 한게임당 필요한 번호 갯수
    private static LottoMachine lottoMachine;

    public LottoShop() {
        lottoMachine = new LottoMachine();
    }

    public static Set<LottoTicket> buyAutoLotto(int lottoBuyCount) {
        Set<LottoTicket> returnSet = new HashSet<>();
        LottoTicket lottoTicket;

        for (int i = lottoBuyCount; i > 0; i--) {
            lottoTicket = lottoMachine.getAutoNumbers(MAKE_AUTO_NUMBER);
            returnSet.add(lottoTicket);
        }

        return returnSet;
    }

    public static Set<LottoTicket> buyManualLotto(List<String> lottoNumber, int buyCount) {
        return lottoMachine.getManualNumbers(lottoNumber, buyCount);
    }
}
