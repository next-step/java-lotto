package lotto.domain;

import java.util.List;

import static lotto.domain.LottoGame.PRICE;

public class IssueRequest {
    private int count;

    public IssueRequest(int count) {
        this.count = count;
    }

    public void issue(List<Lotto> lottos) {
        for (int i = 0; i < this.count; i++) {
            lottos.add(new Lotto());
        }
    }

    public Money getPrice() {
        return PRICE.multiply(this.count);
    }

    public String getBuyCountForPrint() {
        return this.count + "개를 구매했습니다.";
    }
}
