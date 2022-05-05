package lotto.contoller;

import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.Revenue;

import java.util.List;

public class ResultView {
    private Revenue revenue;

    public ResultView(Revenue revenue) {
        this.revenue = revenue;
    }

    public ResultView() {

    }


    public void print(Customer customer) {
        System.out.println(revenue);
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
