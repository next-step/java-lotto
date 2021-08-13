package lotto.model;


import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

    private AutoLottoNumbers autoLottoNumbers;
    private ManualLottoNumbers manualLottoNumbers;

    public LottoTicket(ManualLottoNumbers manualLottoNumbers, int autoCount) {
        this.manualLottoNumbers = manualLottoNumbers;
        generateAutoLottoNumbers(autoCount);
    }

    private void generateAutoLottoNumbers(int autoCount) {
        autoLottoNumbers = new AutoLottoNumbers(autoCount);
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
