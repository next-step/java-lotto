package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberGenerator {
    private static final List<LottoNumber> candidates = new ArrayList<>();

    static {
        for (int i = LottoNumber.MIN; i <= LottoNumber.MAX; i++) {
            candidates.add(LottoNumber.of(i));
        }
    }

    public List<LottoNumber> shuffle() {
        List<LottoNumber> copy = new ArrayList<>(candidates);
        Collections.shuffle(copy);
        return copy.subList(0, LottoTicket.NUMBER_LENGTH)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
