package step2.lotto.automatic.domain;

public class LottoProfitAmount {
    private static final int MATCH_LOTTE_MAX_COUNT = 4;
    private static final int MATCH_LOTTE_MIN_COUNT = 1;

    public static int runLottoProfitAmount() {
        int count = 0;
        LottoStatusEnum lottoEnum;

        for (int i = MATCH_LOTTE_MIN_COUNT; i <= MATCH_LOTTE_MAX_COUNT; i++) {
            lottoEnum = LottoStatusEnum.findByCount(i);
            count = count + (lottoEnum.getPrice() * lottoEnum.getWinningCount());
        }

        return count;
    }


}
