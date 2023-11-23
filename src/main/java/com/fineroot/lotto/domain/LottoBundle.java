package com.fineroot.lotto.domain;

import com.fineroot.lotto.dto.LottoBundleStatus;
import com.fineroot.lotto.dto.WinningNumberSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoBundle {

    private final List<Lotto> lottoList;


    private LottoBundle(int lotteryCount) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < lotteryCount; i++) {
            lottoList.add(Lotto.create());
        }
    }

    private LottoBundle(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public static LottoBundle from(int lotteryCount) {
        return new LottoBundle(lotteryCount);
    }

    public static LottoBundle fromList(List<String> lottoList) {
        return new LottoBundle(
                lottoList.stream().map(e -> Arrays.stream(e.split(",")).mapToInt(Integer::parseInt).toArray())
                        .map(e -> Lotto.from(Arrays.stream(e).boxed().toArray(Integer[]::new))).collect(
                                Collectors.toList()));
    }

    public LottoBundleStatus toLottoBundleStatus() {
        return LottoBundleStatus.from(lottoList.stream().map(Lotto::toString).collect(Collectors.toList()));
    }

    public WinnerStatus matchWinner(WinningNumberSet winningNumberSet) {
        WinnerStatus winnerStatus = WinnerStatus.create();
        for (Lotto lotto : lottoList) {
            WinningRank rank = lotto.matchWithWinningNumber(winningNumberSet);
            winnerStatus.increaseWinningCount(rank);
        }
        return winnerStatus;
    }

}
