package lotto.dto;

import lombok.Getter;
import lombok.ToString;
import lotto.core.SixBall;
import lotto.core.omr.OmrCard;
import lotto.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import static lotto.ui.Program.PRICE_OF_ONE_GAME;

@Getter
@ToString
public class LottoPurchaseDTO {
    private int totalCount;
    private int autoCount;
    private int manualCount;
    private int change;
    private List<SixBall> manualSixBalls = new ArrayList<>();

    public void howMoney(final String textMoney) {
        int money = validationMoney(textMoney);

        this.change = money % PRICE_OF_ONE_GAME;
        this.totalCount = money / PRICE_OF_ONE_GAME;
    }

    public void setManualNumberBuyCount(final String textBuyCount) {
        final int manualCount = validationManualCount(textBuyCount);

        this.manualCount = manualCount;
        this.autoCount = totalCount - manualCount;
    }

    public void appendManualSixBalls(final String csv) {
        try {
            int[] numbers = StringUtils.csvToIntArray(csv);
            this.manualSixBalls.add(SixBall.valueOf(numbers));
        } catch (Exception e) {
            throw new IllegalArgumentException("수동으로 구매할 로또 번호는 숫자만 가능합니다.");
        }
    }

    public OmrCard toOmrCard() {
        OmrCard omrCard = new OmrCard();

        //maanual
        for (int i = 0; i < manualCount; i++) {
            omrCard.marking(manualSixBalls.get(i));
        }

        //auto
        omrCard.auto(autoCount);

        return omrCard;
    }

    public boolean isManual() {
        return manualCount > 0;
    }

    public boolean isChange() {
        return change > 0;
    }

    public String result() {
        return String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.", manualCount, autoCount);
    }

    private int validationMoney(final String textMoney) {
        int money = parseIntElseThrow(textMoney, "구입금액은 숫자만 가능합니다.");
        if (money < PRICE_OF_ONE_GAME) {
            throw new IllegalArgumentException(String.format("구입 최소금액은 %d원 입니다.", PRICE_OF_ONE_GAME));
        }

        return money;
    }

    private int validationManualCount(final String textBuyCount) {
        final int manualCount = parseIntElseThrow(textBuyCount, "수동으로 구매할 로또 수는 숫자만 가능합니다.");

        if (totalCount < manualCount) {
            throw new IllegalArgumentException(String.format("수동으로 최대 %d개만 살수있습니다.", totalCount));
        }
        return manualCount;
    }

    private int parseIntElseThrow(final String textMoney, String errorMessage) {
        try {
            return Integer.parseInt(textMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
