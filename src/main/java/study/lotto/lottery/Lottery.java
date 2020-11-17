package study.lotto.lottery;

import study.lotto.core.*;
import study.lotto.dispenser.Lottos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Lottery {

    private final WinLottoNumbers winLottoNumbers;
    private final Lottos lottos;

    private List<WinningLotto> winningLottos = new ArrayList<>();

    public Lottery(WinLottoNumbers winLottoNumbers, Lottos lottos) {
        this.winLottoNumbers = winLottoNumbers;
        this.lottos = lottos;
    }

    public LotteryResult checkLotto() {
        // 당첨 번호 확인 및 분류
        for (Lotto lotto : lottos) {
            winningLottos.add(lotto.lottery(winLottoNumbers));
        }

        return new LotteryResult(getOnlyWinningLottos(), calcTotalReturnRatio());
    }

    private List<WinningLotto> getOnlyWinningLottos() {
        return this.winningLottos.stream()
                .filter(winningLotto -> winningLotto.getLottoRank() != LottoRank.NONE)
                .collect(Collectors.toList());
    }

    private double calcTotalReturnRatio() {
        int totalPrizeAmount = winningLottos.stream().mapToInt(WinningLotto::getPrize).sum();
        int totalPurchaseAmount = lottos.getTotalPurchaseAmount();
        return (double)totalPrizeAmount / totalPurchaseAmount;
    }

}
