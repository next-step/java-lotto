package domain;

import java.util.ArrayList;
import java.util.List;
import util.CreateAutoNumberMachine;

public class LottoList {

    private List<LottoNumbers> lottos = new ArrayList<>();

    public LottoList(int ticketCount) {
        for (int count = 0; count < ticketCount; count++){
            lottos.add(
                CreateAutoNumberMachine.createNumbers()
            );
        }
    }

    public List<LottoNumbers> getLottos() {
        return lottos;
    }
}
