package lotto.core.omr;

import lotto.core.SixBall;

import java.util.List;

public class Purchase {
    public static final Price DEFAULT_PRICE = new Price(1000);

    private final int autoCount;
    private final int manualCount;

    private Purchase(final int manualCount, final int autoCount) {
        this.manualCount = manualCount;
        this.autoCount = autoCount;
    }

    public static Purchase valueOf(final int money)  {
        return valueOf(money, 0);
    }

    public static Purchase valueOf(final int money, final int manualCount)  {
        int totalCount = DEFAULT_PRICE.howMany(money);

        if (totalCount == 0) {
            throw new IllegalArgumentException(String.format("구입 최소금액은 %s원 입니다.", DEFAULT_PRICE));
        }

        if (totalCount < manualCount) {
            throw new IllegalArgumentException(String.format("수동으로 최대 %d개만 살수있습니다.", totalCount));
        }

        return new Purchase(manualCount, totalCount - manualCount);
    }

    public OmrCard exchange() {
        OmrCard omrCard = new OmrCard(this);

        omrCard.auto(autoCount);

        return omrCard;
    }

    public OmrCard exchange(final List<int[]> manualSixBalls) {
        if (manualCount == 0) {
            return exchange();
        }

        OmrCard omrCard = new OmrCard(this);

        //maanual
        for (int i = 0; i < manualCount; i++) {
            SixBall sixBall = SixBall.valueOf(manualSixBalls.get(i));
            omrCard.marking(sixBall);
        }

        //auto
        omrCard.auto(autoCount);

        return omrCard;
    }

    public int getAutoCount() {
        return autoCount;
    }

    public int getManualCount() {
        return manualCount;
    }

    public int getTotalCount() {
        return autoCount + manualCount;
    }

    public int getTotalPrice() {
        return DEFAULT_PRICE.calcAmountWithPrice(getTotalCount());
    }
}
