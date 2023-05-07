package lotto.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoNumber {

    private final Random random = new Random();
    private final int MAX_LOTTO_NUMBER = 45;
    private final int MIN_LOTTO_NUMBER = 1;

    private List<Integer> lottoNumber;

    public LottoNumber() {
        this.lottoNumber = createLottoNumber();
    }

    public List<Integer> createLottoNumber() {
        return Stream.generate(() -> random.nextInt(MAX_LOTTO_NUMBER) + MIN_LOTTO_NUMBER)
                .limit(6)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "lottoNumber=" + lottoNumber +
                '}';
    }
}
