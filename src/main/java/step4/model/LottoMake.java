package step4.model;

import step4.utils.NumberSplitUtils;

import java.util.ArrayList;
import java.util.List;

public class LottoMake {

    private final int autoLottoCount;
    private final List<String> manualLottoNumber;

    public LottoMake(int autoLottoCount, List<String> manualLottoNumber) {
        this.autoLottoCount = autoLottoCount;
        this.manualLottoNumber = manualLottoNumber;
    }

    public List<Lotto> makeAutoLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i=0; i < this.autoLottoCount; i++) {
            lottos.add(new Lotto(new LottoNumbers(new LottoNumber())));
        }

        return lottos;
    }

    public List<Lotto> makeManualLottos() {
        List<Lotto> lottos = new ArrayList<>();

        for (String numbers : this.manualLottoNumber) {
            lottos.add(new Lotto(new LottoNumbers(NumberSplitUtils.splitWinNumberString(numbers))));
        }

        return lottos;
    }
}
