package domain;

import java.util.ArrayList;
import java.util.List;
import util.CreateAutoNumberMachine;

public class LottoList {

    private List<Lotto> lottoList = new ArrayList<>();

    public LottoList(int ticketCount) {
        for (int count = 0; count < ticketCount; count++){
            lottoList.add(
                new Lotto(CreateAutoNumberMachine.createNumbers()
            ));
        }
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
