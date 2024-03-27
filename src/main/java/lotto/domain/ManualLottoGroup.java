package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoGroup {
    private List<ManualLotto> tickets = new ArrayList<>();
    private final ManualLottoCount manualLottoCount;

    public ManualLottoGroup(ManualLottoCount manualLottoCount) {
        this.manualLottoCount = manualLottoCount;
    }

    public void add(ManualLotto manualLotto){
        tickets.add(manualLotto);
    }

    public int getLeftOvers(Cash cash) {
        return manualLottoCount.getLeftOvers(cash);
    }

    public int getCount(){
        return manualLottoCount.getCount();
    }

    public List<LottoNumber> convertToLottoNumbers() {
        return this.tickets.stream()
                .map(iter -> new LottoNumber(iter.getNumbers()))
                .collect(Collectors.toList());
    }
}
