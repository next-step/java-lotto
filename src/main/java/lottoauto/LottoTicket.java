package lottoauto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
    private static final int LOTTO_TICKET_PRICE = 1000;

    private final LottoNumbers lottoNumbers;

    public LottoTicket() {
        this.lottoNumbers = new LottoNumbers();
    }

    public int price() {
        return LOTTO_TICKET_PRICE;
    }
}
