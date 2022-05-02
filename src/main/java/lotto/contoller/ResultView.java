package lotto.contoller;

import lotto.domain.Revenue;

import java.util.List;

public class ResultView {
    private Revenue revenue;

    public ResultView(Revenue revenue) {
        this.revenue = revenue;
    }


    public void print() {
        System.out.println(revenue);
    }
}
