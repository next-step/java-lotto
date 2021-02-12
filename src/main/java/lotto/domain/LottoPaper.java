package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoPaper {
    public static final String REGEX = ", ";
    private final List<List<LottoNumber>> manualLottoNumbers;
    private final int numberOfAllLottoTicket;
    private final int numberOfManualLottoTicket;

    public LottoPaper(List<String> manualLottoNumbers, int numberOfAllLottoTicket, int numberOfManualLottoTicket) {
       this.manualLottoNumbers = new ArrayList<>();
       convertManualLottoNumbers(manualLottoNumbers);
       this.numberOfAllLottoTicket = numberOfAllLottoTicket;
       this.numberOfManualLottoTicket = numberOfManualLottoTicket;
    }

    private void convertManualLottoNumbers(List<String> manualLottoNumbers) {
        for (String manualLottoNumber : manualLottoNumbers) {
            this.manualLottoNumbers.add(getCommonLottoNumbers(manualLottoNumber));
        }
    }

    public static List<LottoNumber> getCommonLottoNumbers(String winningLottoNumber) {
        return Arrays.stream(winningLottoNumber.split(REGEX))
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public List<List<LottoNumber>> getManualLottoNumbers() {
        return manualLottoNumbers;
    }

    public int getNumberOfAllLottoTicket() {
        return numberOfAllLottoTicket;
    }

    public int getNumberOfManualLottoTicket() {
        return numberOfManualLottoTicket;
    }
}
