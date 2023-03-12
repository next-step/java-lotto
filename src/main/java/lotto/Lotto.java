package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int LOTTO_LIMIT = 45;
    private static final int LOTTO_TICKET_LENGTH = 6;
    private static final int LOTTO_TICKET_MIN = 0;
    private final int[] lottoNumbers;

    public Lotto() {
        lottoNumbers = IntStream.rangeClosed(1, LOTTO_LIMIT).toArray();
    }

    public int[] getLottoNumber() {
        return lottoNumbers;
    }

    public LottoTicket getLottoTicket3() {
        List<Integer> lotto = getLottoTicket2();
        return new LottoTicket(lotto.toString());
    }
    public List<Integer> getLottoTicket2() {
        List<Integer> shuffleNumber =  Arrays.stream(lottoNumbers).boxed().collect(Collectors.toList());
        Collections.shuffle(Arrays.asList(shuffleNumber));
        return shuffleNumber.subList(LOTTO_TICKET_MIN, LOTTO_TICKET_LENGTH);
    }


}