package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {

    public List<Lotto> issueLottoList(int amount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int count = 0; count < amount; count++) {
            lottoList.add(new Lotto());
        }
        return lottoList;
    }

}
