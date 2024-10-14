package lotto.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LottoInput {

    private final Pattern NUMBER_PATTERN = Pattern.compile("\\d");
    private final int LIMIT_AMOUNT = 100000;

    public int purchaseValid(String amount) {
        if(amount.isBlank()) {
            throw new IllegalArgumentException("구매금액이 없을수는 없습니다.");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(amount);
        if(!matcher.find()) {
            throw new IllegalArgumentException("구매금액은 숫자만 입력이 가능합니다.");
        }

        int purchasedAmount = Integer.parseInt(amount);

        if(purchasedAmount < 0) {
            throw new IllegalArgumentException("음수는 허용하지 않습니다.");
        }

        if(purchasedAmount >= LIMIT_AMOUNT) {
            throw new IllegalArgumentException("구매금액은 " + LIMIT_AMOUNT + "를 초과할 수 없습니다.");
        }

        return purchasedAmount;
    }
}
