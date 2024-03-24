package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    public boolean containsExactly(LottoNumbers... lottoNumbers) {
        return Arrays.stream(lottoNumbers)
                .allMatch(numbers::contains);
    }

    public LottoTicket combine(LottoTicket lottoTicket) {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        lottoNumbers.addAll(this.numbers);
        lottoNumbers.addAll(lottoTicket.numbers);
        return LottoTicket.from(lottoNumbers);
    }
}
