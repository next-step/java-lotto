package lottoAuto.model;

import java.beans.beancontext.BeanContext;

public class LottoResult {
    private int count;
    private Boolean isBonus;

    public LottoResult(int count,Boolean isBonus) {
        this.count = count;
        this.isBonus = isBonus;
    }

    public int getCount() {
        return count;
    }

    public Boolean getBonus() {
        return isBonus;
    }
}
