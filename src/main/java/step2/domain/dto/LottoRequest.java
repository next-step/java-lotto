package step2.domain.dto;

import step2.exception.InvalidExceedPriceException;
import step2.exception.InvalidPriceUnitException;

import java.math.BigDecimal;
import java.util.List;

import static step2.util.BigDecimalUtil.stringToBigDecimal;
import static step2.util.StringUtil.numbers;

public class LottoRequest {

    private static final BigDecimal PRICE_PER_SHEET = BigDecimal.valueOf(1000);

    private BigDecimal price;
    private int automaticCount;
    private List<List<Integer>> manualNumbers;

    public LottoRequest(String priceText, List<String> manualNumbers) {
        BigDecimal price = stringToBigDecimal(priceText);
        int manualCount = manualNumbers.size();
        validate(price, manualCount);

        int totalCount = numberOfLotto(price);
        this.price = price;
        this.automaticCount = totalCount - manualCount;
        this.manualNumbers = numbers(manualNumbers);
    }

    private int numberOfLotto(BigDecimal price) {
        return price.divide(PRICE_PER_SHEET).intValue();
    }

    private void validate(BigDecimal price, int manualCount) {
        validateUnit(price);
        validateExceed(price, manualCount);
    }

    private void validateUnit(BigDecimal price) {
        if (!isValidUnit(price)) {
            throw new InvalidPriceUnitException();
        }
    }

    private boolean isValidUnit(BigDecimal price) {
        return price.remainder(PRICE_PER_SHEET).equals(BigDecimal.ZERO);
    }

    private void validateExceed(BigDecimal price, int manualCount) {
        int totalCount = numberOfLotto(price);
        if (totalCount < manualCount) {
            throw new InvalidExceedPriceException();
        }
    }

    public BigDecimal price() {
        return this.price;
    }

    public int automaticCount() {
        return this.automaticCount;
    }

    public int manualCount() {
        return this.manualNumbers.size();
    }

    public List<List<Integer>> manualNumbers() {
        return this.manualNumbers;
    }

}
