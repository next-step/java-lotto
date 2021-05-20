package lottoauto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
    private static final int LOTTO_TICKET_PRICE = 1000;
    private static final int LOTTO_NUMBER_START = 1;
    private static final int LOTTO_NUMBER_END = 45;
    private static final int ZERO = 0;
    private static final int LOTTO_NUMBER_SIZE = 6;

    public int price() {
        return LOTTO_TICKET_PRICE;
    }

    public List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumberList = IntStream.rangeClosed(LOTTO_NUMBER_START, LOTTO_NUMBER_END)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(lottoNumberList);

        return lottoNumberList.subList(ZERO,LOTTO_NUMBER_SIZE);
    }
}
