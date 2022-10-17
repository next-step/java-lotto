package lotto.domain;

import lotto.exception.InvalidInputException;

import java.util.Objects;

public class Exchange {

    private static final Integer LOTTO_PRICE = 1000;
    private final Integer purchaseAmount;
    private Integer lottoAmount;

    public Exchange(String inputAmount) {
        this.purchaseAmount = convertToInt(validateInput(inputAmount));
        this.lottoAmount = purchaseLottos();
    }

    private String validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new InvalidInputException();
        }
        return input;
    }

    private Integer convertToInt(String purchaseAmount) {
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new InvalidInputException();
        }
    }

    private Integer purchaseLottos() {
        if (this.purchaseAmount % LOTTO_PRICE != 0) {
            throw new InvalidInputException();
        }
        this.lottoAmount = this.purchaseAmount / LOTTO_PRICE;
        return this.lottoAmount;
    }

    public Integer getPurchaseAmount() {
        return purchaseAmount;
    }

    public Integer getLottoAmount() {
        return lottoAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exchange)) return false;
        Exchange exchange = (Exchange) o;
        return Objects.equals(purchaseAmount, exchange.purchaseAmount) && Objects.equals(lottoAmount, exchange.lottoAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseAmount, lottoAmount);
    }
}
