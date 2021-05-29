package lottoauto;

import java.util.ArrayList;
import java.util.List;

public class RequestedManualLottoNumbers {
    private final List<String> requestedManualLottoNumbers;

    public RequestedManualLottoNumbers(List<String> requestedManualLottoNumbers) {
        this.requestedManualLottoNumbers = requestedManualLottoNumbers;
    }

    public boolean isOver(int totalLottoCount) {
        return totalLottoCount < requestedManualLottoNumbers.size();
    }

    public List<LottoTicket> generateManualLottoTickets() {
        List<LottoTicket> result = new ArrayList<>();

        for (String manualLottoNumber: requestedManualLottoNumbers) {
            LottoGenerateStrategy manualStrategy = new ManualStrategy(manualLottoNumber);
            result.add(new LottoTicket(manualStrategy));
        }

        return result;
    }

    public int calcRemainingLottoCount(int totalLottoCount) {
        return totalLottoCount - requestedManualLottoNumbers.size();
    }
}
