package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGroup {

    private final ManualLottoBundle manualLottoBundle;
    private final LottoBundle autoLottoBundle;
    private final LottoBundle groupBundle;

    public LottoGroup(ManualLottoBundle manualLottoBundle, LottoBundle autoLottoBundle) {
        this.manualLottoBundle = manualLottoBundle;
        this.autoLottoBundle = autoLottoBundle;
        this.groupBundle = sumBundles(manualLottoBundle, autoLottoBundle);
    }

    public LottoBundle getGroupBundle() {
        return groupBundle;
    }

    public List<Lotto> unfoldManual() {
        return manualLottoBundle.unfoldLottoBundle();
    }

    public List<Lotto> unfoldAuto() {
        return autoLottoBundle.unfoldLottoBundle();
    }

    private LottoBundle sumBundles(ManualLottoBundle manualLottoBundle, LottoBundle autoLottoBundle) {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.addAll(manualLottoBundle.unfoldLottoBundle());
        lottoList.addAll(autoLottoBundle.unfoldLottoBundle());

        return new LottoBundle(lottoList);
    }

}
