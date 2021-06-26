package lotto.dto;

import lombok.Getter;
import lotto.core.omr.OmrCard;
import lotto.core.omr.Purchase;
import lotto.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

@Getter
public class LottoPurchaseDTO {
    private int money;
    private int manualCount;
    private List<int[]> manualSixBalls = new ArrayList<>();

    public void setMoney(final String money) {
        try {
            this.money = Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입금액은 숫자만 가능합니다.");
        }
    }

    public void setManualCount(final String manualCount) {
        try {
            this.manualCount = Integer.parseInt(manualCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("수동갯수는 숫자만 가능합니다.");
        }
    }

    public void appendManualSixBalls(final String csv) {
        try {
            int[] numbers = StringUtils.csvToIntArray(csv);
            this.manualSixBalls.add(numbers);
        } catch (Exception e) {
            throw new IllegalArgumentException("수동으로 구매할 로또 번호는 숫자만 가능합니다.");
        }
    }

    public OmrCard toOmrCard() {
        Purchase purchase = Purchase.valueOf(money, manualCount);

        return purchase.exchange(manualSixBalls);
    }
}
