package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class ManualLottos {

    private List<String> values = new ArrayList<>();

    public ManualLottos(List<String> values) {
        this.values = values;
    }

    public int size() {
        return values.size();
    }

    public String getManualLotto(int index) {
        return values.get(index);
    }
}
