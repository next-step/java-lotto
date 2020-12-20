package step2;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class LottoPurchaseRequest {
    private Money money;
    private List<LottoNumbers> manualNumbers;

    public LottoPurchaseRequest(Money money, LottoNumbers... manualNumbers) {
        this.money = money;
        this.manualNumbers = Arrays.asList(manualNumbers);
    }

    public LottoPurchaseRequest(Money money, List<LottoNumbers> manualNumbers) {
        this.money = money;
        this.manualNumbers = manualNumbers;
    }

    public List<LottoNumbers> getManualNumbers() {
        return manualNumbers;
    }

    public int getAutoCount(Money lottoPrice) {
        return (this.money.getValue() - (manualNumbers.size() * lottoPrice.getValue())) / lottoPrice.getValue();
    }

    public boolean valid(Money lottoPrice) {
        return this.money.divide(lottoPrice.getValue()) >= this.manualNumbers.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoPurchaseRequest that = (LottoPurchaseRequest) o;
        return Objects.equals(money, that.money) &&
                Objects.equals(manualNumbers, that.manualNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, manualNumbers);
    }
}
