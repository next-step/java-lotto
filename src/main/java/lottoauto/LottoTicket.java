package lottoauto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
    private final LottoNumbers lottoNumbers;

    public LottoTicket() {
        this.lottoNumbers = new LottoNumbers();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
