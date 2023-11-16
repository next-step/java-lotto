package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class ResultView {

    public void issuedTicket(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.selectedNumber());
        }
    }
}
