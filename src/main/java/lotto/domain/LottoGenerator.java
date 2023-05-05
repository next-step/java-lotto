package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoTicket.LOTTO_TICKET_SIZE;

public class LottoGenerator {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_TICKET_COUNT = 1;

    private static final List<LottoNumber> LOTTO_NUMBER_POOL = IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

    public static LottoTickets generateLottoTickets(int count) {
        validate(count);
        return new LottoTickets(IntStream.range(0, count)
                .mapToObj(i -> generateLottoNumbers())
                .collect(Collectors.toList()));
    }

    public static LottoTicket generateLottoNumbers() {
        List<LottoNumber> shuffledPool = new ArrayList<>(LOTTO_NUMBER_POOL);
        Collections.shuffle(shuffledPool);
        Set<LottoNumber> numbers = new TreeSet<>(shuffledPool.subList(0, LOTTO_TICKET_SIZE));
        return new LottoTicket(numbers);
    }

    private static void validate(int count) {
        if (count < MIN_LOTTO_TICKET_COUNT) {
            throw new IllegalArgumentException("로또 티켓은 " + MIN_LOTTO_TICKET_COUNT + "장 보다 적게 생성 할 수 없습니다");
        }
    }


}



