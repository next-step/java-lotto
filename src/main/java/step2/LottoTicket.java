package step2;

import java.util.Arrays;
import java.util.List;

public class LottoTicket {
    private final List<Integer> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public long findMatchCount(String[] winningNumbers) {
        return Arrays.stream(winningNumbers)
                     .filter(number -> lottoNumbers.contains(Integer.parseInt(number)))
                     .count();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
