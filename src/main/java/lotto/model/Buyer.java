package lotto.model;

import java.util.List;
import java.util.Map;

public class Buyer {

    private LottoPaper lottoPaper;

    public Buyer() {
    }

    public void purchase(int money) {
        this.lottoPaper = LottoMachine.purchase(money);
    }

    public boolean hasLotto() {
        return !this.lottoPaper.isEmpty();
    }

    public void confirm() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.lottoPaper.size()).append("개를 구매했습니다").append("\n");
        sb.append(this.lottoPaper.confirm());

        System.out.println(sb);
    }

    public Map<Integer, Integer> matches(List<LottoNumber> winningNumbers) {
        return this.lottoPaper.matches(winningNumbers);
    }
}
