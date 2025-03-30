package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketGenerator {
    private static final List<LottoNumber> candidates = new ArrayList<>();

    static {
        for (int i = LottoNumber.MIN; i <= LottoNumber.MAX; i++) {
            candidates.add(LottoNumber.of(i));
        }
    }

    public static LottoTicket auto() {
        List<LottoNumber> copy = new ArrayList<>(candidates);
        Collections.shuffle(copy);
        return new LottoTicket(copy.subList(0, LottoTicket.NUMBER_LENGTH));
    }

    public static LottoTicket manual(int[] numbers) {
        List<LottoNumber> lottoNumbers = Arrays.stream(numbers)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
        return new LottoTicket(lottoNumbers);
    }
}
