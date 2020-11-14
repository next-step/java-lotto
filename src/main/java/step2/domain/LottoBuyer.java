package step2.domain;

import step1.StringUtils;
import step2.dto.LottoStatisticsResult;
import step2.dto.WinLotteryResult;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static util.Preconditions.checkArgument;

public class LottoBuyer {
    public static final String MONEY_MUST_NOT_BE_NULL = "money must not be null";
    public static final String WINNING_NUMBER_MUST_NOT_BE_BLANK = "winning number must not be blank";
    public static final String WINNING_NUMBER_SIZE_NOT_VALID = "winning number size must be " + Lotto.getLottoNumbersLength();
    private static final String SEPARATOR = ", ";
    private final Money money;
    private Lottos lottos = Lottos.EMPTY;

    private LottoBuyer(final Money money) {
        this.money = money;
    }

    public static LottoBuyer of(final Money money) {
        checkArgument(Objects.nonNull(money), MONEY_MUST_NOT_BE_NULL);
        return new LottoBuyer(money);
    }

    public static LottoBuyer of(final int money) {
        return of(Money.of(money));
    }

    public Lottos buy() {
        this.lottos = LottoStore.sell(money);
        return getLottos();
    }

    public Lottos getLottos() {
        return lottos;
    }

    public LottoStatisticsResult getWinLotteryStatistics(final String winningNumberExpression) {
        checkArgument(StringUtils.isNotBlank(winningNumberExpression), WINNING_NUMBER_MUST_NOT_BE_BLANK);
        final List<LottoNumber> lottoNumbers = Arrays.stream(winningNumberExpression.split(SEPARATOR))
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toList());

        checkArgument(lottoNumbers.size() == Lotto.getLottoNumbersLength(), WINNING_NUMBER_SIZE_NOT_VALID);
        return getWinLotteryStatistics(Lotto.of(lottoNumbers));
    }

    public LottoStatisticsResult getWinLotteryStatistics(final Lotto winningLottery) {
        final WinLotteryResult result = lottos.countHitNumber(winningLottery);
        return new LottoStatisticsResult(result, getProfit(result));
    }

    private double getProfit(final WinLotteryResult result) {
        final Money prize = result.getTotalPrizeMoney();
        return prize.divide(money);
    }
}
