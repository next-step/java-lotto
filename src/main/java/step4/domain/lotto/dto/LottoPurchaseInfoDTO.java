package step4.domain.lotto.dto;

import step4.Constant;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchaseInfoDTO {
    private final int money;
    private final int manualSize;
    private final List<String> manualNumbers;

    public int getAutoTicketsSize() {
        return money/Constant.LOTTO_PRICE - manualSize;
    }

    public int getMoney() {
        return money;
    }

    public int getManualSize() {
        return manualSize;
    }

    public List<String> getManualNumbers() {
        return manualNumbers;
    }

    public static class Builder {
        private final int money;
        private final List<String> manualNumbers = new ArrayList<>();
        private int manualSize;

        public Builder(int money) {
            this.money = money;
        }

        public Builder manualSize(int value) {
            this.manualSize = value;
            return this;
        }

        public Builder inputManualNumbers(List<String> value) {
            this.manualNumbers.addAll(value);
            return this;
        }

        public LottoPurchaseInfoDTO build() {
            return new LottoPurchaseInfoDTO(this);
        }

        public void isValid() {
            if (manualSize != manualNumbers.size()) {
                throw new IllegalArgumentException(Constant.ERROR_INVALID_MANUALLY_SIZE);
            }
        }
    }

    private LottoPurchaseInfoDTO(Builder builder) {
        builder.isValid();
        money = builder.money;
        manualSize = builder.manualSize;
        manualNumbers = builder.manualNumbers;
    }

}
