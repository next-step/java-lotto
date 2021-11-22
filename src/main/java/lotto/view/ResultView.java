package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.PurchaseMachine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author han
 */
public class ResultView {


    public void printPurchaseLottos(PurchaseMachine purchaseMachine) {
        List<Lotto> lottoList = purchaseMachine.getLottoList();

        for (Lotto l : lottoList) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            String collect = l.getNumbers().stream().map(String::valueOf).collect(Collectors.joining(","));
            sb.append(collect);
            sb.append("]");
            System.out.println(sb);
        }
    }

    public void printResultStatics(PurchaseMachine purchaseMachine) {

    }
}
