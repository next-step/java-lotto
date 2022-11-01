package lotto.input;

import lotto.domain.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoInput {
    private final List<String> manualLottos;

    public ManualLottoInput(List<String> manualLottos) {
        this.manualLottos = manualLottos;
    }

    public int getInputSize(){
        return manualLottos.size();
    }

    public List<Lotto> getLottos(){
        return manualLottos.stream().map(Lotto::from).collect(Collectors.toList());
    }

}
