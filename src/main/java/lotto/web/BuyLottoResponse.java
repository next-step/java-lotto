package lotto.web;

import java.util.List;
import lotto.domain.Lotto;

public class BuyLottoResponse {
    private long inputMoney;
    private List<Lotto> lottos;
    private long count;
    private long manualCount;
    private long autoCount;

    public static class Builder {
        private long inputMoney;
        private List<Lotto> lottos;
        private long manualCount;

        public Builder inputMoney(long inputMoney) {
            this.inputMoney = inputMoney;
            return this;
        }

        public Builder lottos(List<Lotto> lottos) {
            this.lottos = lottos;

            return this;
        }

        public Builder manualCount(long manualCount) {
            this.manualCount = manualCount;
            return this;
        }

        public BuyLottoResponse build() {
            return new BuyLottoResponse(this);
        }
    }

    private BuyLottoResponse(Builder builder) {
        this.inputMoney = builder.inputMoney;
        this.lottos = builder.lottos;
        this.count = builder.lottos.size();
        this.manualCount = builder.manualCount;
        this.autoCount = builder.lottos.size() - builder.manualCount;
    }

    public long getInputMoney() {
        return inputMoney;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public long getCount() {
        return count;
    }

    public long getManualCount() {
        return manualCount;
    }

    public long getAutoCount() {
        return autoCount;
    }
}

