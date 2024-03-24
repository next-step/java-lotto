package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    private final List<LottoNumbers> numbers;

    private LottoTicket(List<LottoNumbers> lottoNumbers) {
        this.numbers = lottoNumbers;
    }

    public static LottoTicket from(List<LottoNumbers> lottoNumbers) {
        return new LottoTicket(lottoNumbers);
    }

    public static LottoTicket from(List<LottoNumbers> autoLottoNumbers, List<LottoNumbers> manualLottoNumbers) {
        List<LottoNumbers> finalLottoNumbers = new ArrayList<>();
        finalLottoNumbers.addAll(autoLottoNumbers);
        finalLottoNumbers.addAll(manualLottoNumbers);
        return new LottoTicket(finalLottoNumbers);
    }

    public int size() {
        return numbers.size();
    }

    public LottoResult computeLottoResult(WinningNumber winningNumber) {
        LottoResult lottoResult = new LottoResult(numbers.size());
        for (LottoNumbers lottoNumbers : numbers) {
            int containsCount = winningNumber.containsCount(lottoNumbers);
            lottoResult.addCorrectLottoCount(containsCount, winningNumber.isContainBonusNumber(lottoNumbers));
        }
        return lottoResult;
    }

    public List<String> getLottoTicketToString() {
        return numbers
                .stream()
                .map(LottoNumbers::toString)
                .collect(Collectors.toList());
    }
}
