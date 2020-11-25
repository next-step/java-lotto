package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Generator {

    private static final int LOTTO_NUMBER_BOUND = 60;

    private final List<Integer> lottoNumbers;

    public Generator(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Generator newGenerator() {
        List<Integer> lottoNumbers = new ArrayList();
        for (int i = 1; i <= LOTTO_NUMBER_BOUND ; i++) {
            lottoNumbers.add(i);
        }
        return new Generator(lottoNumbers);
    }

    public LottoTicket generateLottoTicket() {
        Collections.shuffle(lottoNumbers);
        List<Integer> numbers = lottoNumbers.stream().limit(6).collect(Collectors.toList());
        return new LottoTicket(numbers);
    }
}
