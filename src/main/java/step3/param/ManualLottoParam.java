package step3.param;

import java.util.List;

public class ManualLottoParam {
    List<ManualLottoNumbersParam> manualLottos;

    public ManualLottoParam(List<ManualLottoNumbersParam> manualLottos) {
        this.manualLottos = manualLottos;
    }

    public static ManualLottoParam from(List<ManualLottoNumbersParam> manualLottos) {
        return new ManualLottoParam(manualLottos);
    }

    public List<ManualLottoNumbersParam> getManualLottos() {
        return manualLottos;
    }
}
