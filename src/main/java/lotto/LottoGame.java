package lotto;

import lotto.constant.LottoRank;
import lotto.model.LottoTicket;
import lotto.model.WinningInfo;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.EnumMap;
import java.util.List;

public class LottoGame {

    private static int LOTTO_PRICE = 1000;

    public void exec() {
        InputView inputView = new InputView();
        int money = inputView.receiveInputMoney();
        WinningInfo winningInfo = inputView.receiveInputWinningInfo();

        int lottoCount = getLottoCount(money);
        List<LottoTicket> lottoTicketList = LottoTicketMaker.issueLottoList(lottoCount);
        ResultView.printLottos(lottoCount, lottoTicketList);

        EnumMap<LottoRank, Integer> result = scratchLottoList(winningInfo, lottoTicketList);
        double rateReturn = getRateReturn(result, money);
        ResultView.printResult(result, rateReturn);
    }

    public double getRateReturn(EnumMap<LottoRank, Integer> gameResult, double cost) {

        int totalPrize = 0;
        for (LottoRank lottoRank : gameResult.keySet()) {
            totalPrize += lottoRank.getPrize() * gameResult.get(lottoRank);
        }
        return totalPrize / cost;
    }


    public EnumMap<LottoRank, Integer> scratchLottoList(WinningInfo winningInfo, List<LottoTicket> lottoTicketList) {

        EnumMap<LottoRank, Integer> map = new EnumMap<>(LottoRank.class);
        for (LottoRank lottoRank : LottoRank.values()) {
            map.put(lottoRank, 0);
        }

        for (LottoTicket lottoTicket : lottoTicketList) {
            int matchCount = getMatchCount(winningInfo, lottoTicket);
            boolean bonusBall = containsBonusBall(winningInfo, lottoTicket);
            LottoRank lottoRank = getRank(matchCount, bonusBall);
            map.put(lottoRank, map.get(lottoRank) + 1);
        }
        return map;
    }

    public LottoRank getRank(int matchCount, boolean containsBonusBall) {
        if (matchCount == LottoRank.FIRST.getMatchCount()) {
            return LottoRank.FIRST;
        }
        if (matchCount == LottoRank.SECOND.getMatchCount()
            && containsBonusBall == true) {
            return LottoRank.SECOND;
        }
        if (matchCount == LottoRank.THIRD.getMatchCount()) {
            return LottoRank.THIRD;
        }
        if (matchCount == LottoRank.FOURTH.getMatchCount()) {
            return LottoRank.FOURTH;
        }
        if (matchCount == LottoRank.FIFTH.getMatchCount()) {
            return LottoRank.FIFTH;
        }
        return LottoRank.LOSE;
    }

    public static int getLottoCount(int money) {
        return money / LOTTO_PRICE;
    }

    public int getMatchCount(WinningInfo winningInfo, LottoTicket lottoTicket) {
        return (int) lottoTicket.lotto.stream()
                .distinct()
                .filter(winningInfo.winningLottos::contains)
                .count();
    }

    public boolean containsBonusBall(WinningInfo winningInfo, LottoTicket lottoTicket) {
        return lottoTicket.lotto.contains(winningInfo.bonusNumber);
    }
}
