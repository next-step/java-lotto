package lotto.domain;

import lotto.domain.strategy.WinningStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;
    private List<LottoNumber> values;

    public Lotto() {
        this.values = new ArrayList<>();
        Random random = new Random();
        while (values.size() < LOTTO_SIZE) {
            LottoNumber lottoNumber = new LottoNumber(lottoRange(random));

            if (!values.contains(lottoNumber)) {
                values.add(lottoNumber);
            }
        }
    }

    public Lotto(String values) {

        this.values = Arrays.stream(values.split(", "))
                .mapToInt(Integer::parseInt)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());


        if (this.values.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
        }
    }

    private int lottoRange(Random random) {
        return random.nextInt(LOTTO_MAX_NUMBER) + LOTTO_MIN_NUMBER;
    }

    public String findLotto() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < values.size(); i++) {
            stringBuilder.append(values.get(i).findNumber());
            if (i != LOTTO_SIZE - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void test(Lotto lotto, WinningStrategy strategy) {
        strategy.matches(lotto, this);
    }

    public long calculateMatchCount(Lotto winningNumbers) {

        return values.stream()
                .filter(winningNumbers.values::contains)
                .count();
    }
}
