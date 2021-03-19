package step2.domain;

import step2.dto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public List<Lotto> issueLottoList(int amount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int count = 0; count < amount; count++) {
            lottoList.add(new Lotto());
        }
        return lottoList;
    }

}
