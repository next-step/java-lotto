package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public List<Lotto> issue(int issueCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < issueCount; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }
}
