package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;
    private List<LottoNumber> values;

    public Lotto() {
        values = new ArrayList<>();
        Random random = new Random();
        while (values.size() < LOTTO_SIZE) {
            LottoNumber lottoNumber = new LottoNumber(lottoRange(random));

            if (!values.contains(lottoNumber)) {
                values.add(lottoNumber);
            }
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
}
