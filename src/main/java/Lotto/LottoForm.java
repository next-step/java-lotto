package Lotto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LottoForm {

    private BigDecimal buyPrice;
    private int manualLottoCount;
    private List<String> manualLottosNumber;

    protected LottoForm(BigDecimal buyPrice, int manualLottoCount) {
        this.buyPrice = buyPrice;
        this.manualLottoCount = manualLottoCount;
        manualLottosNumber = new ArrayList<String>();
    }

    public void setManualLottoNumber(List<String> manualLottoNumber) {
        this.manualLottosNumber = manualLottoNumber;
    }
    public void addManualLottoNumber(String manualLottoNumber){
        manualLottosNumber.add(manualLottoNumber);
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public List<String> getManualLottosNumber() {
        return manualLottosNumber;
    }
}
