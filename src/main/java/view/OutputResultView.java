package view;


import java.util.ArrayList;
import java.util.List;

public class OutputResultView {

    private List<Integer> lottoMatchCounts = new ArrayList();
    private double profit;

    public OutputResultView(List<Integer> lottoMatchCounts, double profit) {
        lottoMatchCounts.stream().forEach(v -> this.lottoMatchCounts.add(v));
        this.profit = profit;
    }

    public List<Integer> getLottoMatchCounts() {
        return lottoMatchCounts;
    }

    public String getProfit() {
        return String.valueOf(profit);
    }
}
