package lotto.model;


import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

    private AutoLottoNumbers autoLottoNumbers;
    private ManualLottoNumbers manualLottoNumbers;

    public LottoTicket(ManualLottoNumbers manualLottoNumbers, AutoLottoNumbers autoLottoNumbers) {
        this.manualLottoNumbers = manualLottoNumbers;
        this.autoLottoNumbers = autoLottoNumbers;
    }

    public List<LottoNumbers> getLottoTicketInfo() {
        List<LottoNumbers> totalLottoNumbers = new ArrayList<>();
        if (manualLottoNumbers != null && manualLottoNumbers.getManualLottoNumbers().size() > 0) {
            totalLottoNumbers.addAll(manualLottoNumbers.getManualLottoNumbers());
        }
        totalLottoNumbers.addAll(autoLottoNumbers.getAutoLottoNumbers());
        return totalLottoNumbers;
    }
}
