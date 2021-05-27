package study.lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {
    /*아래 로또 사이즈와, 로또 숫자 범위의 책임은 어디에 있어야 하나, 사이즈는 로또번호가 사이즈대로 모이는 로또용지, 숫자는 로또 번호 객체에 있어야 할 것 같다는 생각을 처음엔 하였으나,
    로또의 종류가 다양하게 있으니 게임에 맞게 번호와 사이즈가 달라 질 것이므로 게임이 갖고 있어야 한다고 생각하였습니다.
    물론 이 경우 다른 종류의 게임이 있기 때문에 전략패턴처럼 공통과, 각 게임의 특징이 담긴 객체로 분리하여야 하지만 추가되지 않을 수도 있는 고려사항이기때문에 요구사항만 적용하였습니다.*/
    public static final int MARK_SIZE = 6;
    public static final List<Integer> AVAILABLE_LOTTONUMBERS = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());

    private static final BigDecimal lottoPrice = BigDecimal.valueOf(1000);

    public int purchaseableNumber(BigDecimal amount){
        return amount.divide(lottoPrice,0, RoundingMode.DOWN).intValue();
    }

    public PurchasedLottos purchase(BigDecimal purchaseAmount) {

        return new PurchasedLottos(purchaseableNumber(purchaseAmount));
    }

    public WinningResult checkPrize(PurchasedLottos purchasedLottos, LottoNumbers winningNumbers) {
        WinningResult winningResult = new WinningResult();
        for (LottoNumbers lottoNumbers : purchasedLottos.values()) {
            int matchCount = lottoNumbers.matchWinningNumberCount(winningNumbers);
            winningResult.addPrize(matchCount);
        }

        return winningResult;
    }

    public BigDecimal profitRate(BigDecimal purchaseAmount, BigDecimal prizeAmount) {
        return prizeAmount.divide(purchaseAmount,2, RoundingMode.HALF_UP);
    }
}
