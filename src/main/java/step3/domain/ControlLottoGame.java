package step3.domain;

import java.math.BigDecimal;
import java.util.*;

public class ControlLottoGame {
    private static final int LOTTO_PRICE = 1000;
    private static final int BONUS_BALL = 5;

    public BuyLotto startLotto(int totalPrice) {
        LottoInfo lottoInfo = new LottoInfo(LOTTO_PRICE);
        BuyInfo buyInfo = new BuyInfo(totalPrice, lottoInfo.getLottoPrice());
        Lotto lotto = new Lotto();
        Set<List<Integer>> buyLottoList = new HashSet<>();
        for (int i = 0; i < buyInfo.getTotalCount(); i++) {
            List<Integer> lottoList = lotto.getRandomLottoList();
            buyLottoList.add(lottoList);
        }
        BuyLotto buyLotto = new BuyLotto(buyLottoList);
        return buyLotto;
    }

    public RankList setRanktList(WinLotto winLotto, BuyLotto buyLotto) {
        Iterator<List<Integer>> iterator = buyLotto.getBuyLottoList().iterator();
        List<WinInformation> list = new ArrayList<>();
        while (iterator.hasNext()) {
            WinInformation winInformation = setRank(winLotto, iterator.next());
            list.add(winInformation);
        }
        RankList rankList = new RankList(list);

        return rankList;
    }

    private WinInformation setRank(WinLotto winLotto, List<Integer> next) {
        int matchCount = winLotto.match((List<Integer>) next);
        boolean bonusBallMatch = false;
        if(matchCount == BONUS_BALL){
            bonusBallMatch = winLotto.matchBonusball((List<Integer>) next);
        }
        return WinInformation.matchWinInformation(matchCount,bonusBallMatch);
    }

    public ResultInfo setResult(RankList rankList) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i <= 6; i++) {

        }

        stringBuffer.append(WinInformation.EQUALS_COUNT_3.getCount()
                + WinInformation.EQUALS_COUNT_3.getTitle()
                + "(" + WinInformation.EQUALS_COUNT_3.getPrice() + "원) - "
                + rankList.match(WinInformation.EQUALS_COUNT_3) + "개");
        return null;
    }
}
