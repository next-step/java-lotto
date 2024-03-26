package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class ManualLottoGroup {
    private List<ManualLotto> tickets = new ArrayList<>();

    public void add(ManualLotto manualLotto){
        tickets.add(manualLotto);
    }
}
