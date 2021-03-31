package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<LottoNumbers> auto;
    private List<LottoNumbers> manual;

    public Lotto() {
        this.auto = new ArrayList<>();
        this.manual = new ArrayList<>();
    }

    public List<LottoNumbers> auto() {
        return auto;
    }
    public List<LottoNumbers> manual() {
        return manual;
    }

    public void buy(int count) {
        for (int i = 0; i < count; i++) {
            auto.add(new LottoNumbers());
        }
        for (LottoNumbers lottoNumbers : auto) {
            lottoNumbers.mark();
        }
    }

    public void buy(int count, List<LottoNumbers> lottoNumbers) {
        for (int i = 0; i < count; i++) {
            lottoNumbers.add(new LottoNumbers());
        }
        for (LottoNumbers lottoNumber : lottoNumbers) {
            lottoNumber.mark();
        }
    }

    public void buyManual(int manualCount, int total) {
        this.buy(manualCount, this.manual);
        this.buy(total - manualCount, this.auto);
    }
}
