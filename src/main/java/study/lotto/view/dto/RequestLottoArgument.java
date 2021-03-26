package study.lotto.view.dto;

import study.lotto.domain.Money;
import study.lotto.exception.LottoException;

import java.util.Objects;

import static study.lotto.util.Constants.GUIDE_ERR_CANNOT_PARSE_STRING_TO_INTEGER;
import static study.lotto.util.Constants.GUIDE_ERR_NOT_FOUND_MONEY;
import static study.lotto.util.Validation.isNotNullAndIsBlank;

public class RequestLottoArgument {

    private final Money money;
    private final int autoCount;

    private RequestLottoArgument(final Money money) {
        this(money, 0);
    }

    private RequestLottoArgument(final Money money, final int manualCount) {
        money.ensureBuyLotto(manualCount);
        this.money = money;
        this.autoCount = autoCount(manualCount);
    }

    public static RequestLottoArgument of(final int money) {
        return new RequestLottoArgument(Money.of(money));
    }

    public static RequestLottoArgument of(final String money) {
        if(isNotNullAndIsBlank(money)) {
            throw new LottoException(GUIDE_ERR_NOT_FOUND_MONEY);
        }
        return new RequestLottoArgument(Money.of(money));
    }

    public static RequestLottoArgument of(final Money money, final String manualCount) {
        try {
            return new RequestLottoArgument(money, Integer.parseInt(manualCount));
        } catch (NumberFormatException e) {
            throw new LottoException(GUIDE_ERR_CANNOT_PARSE_STRING_TO_INTEGER);
        }
    }

    private int autoCount(final int manualCount) {
        return money.autoSize(manualCount);
    }

    public int autoSize() {
        return autoCount;
    }

    public int totalSize() {
        return money.totalSize();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final RequestLottoArgument that = (RequestLottoArgument) o;
        return autoCount == that.autoCount
                && Objects.equals(money, that.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, autoCount);
    }

    @Override
    public String toString() {
        return String.valueOf(money);
    }
}
