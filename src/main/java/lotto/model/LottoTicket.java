package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

    private List<LottoNumbers> lottoNumberList = new ArrayList<>();

    public List<LottoNumbers> getTicket(int gameCount) {
        for (int count = 0; count < gameCount; count++) {
            lottoNumberList.add(new LottoNumbers());
        }
        return lottoNumberList;
    }
}
