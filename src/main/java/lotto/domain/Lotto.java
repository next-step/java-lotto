package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    private static final String DELIMITER = ", ";
    private static final String OPEN_BRACKET = "[";
    private static final String CLOSE_BRACKET = "]";
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final List<LottoNumber> INITIALIZED_LOTTO = initLottos();
    private final List<LottoNumber> values;

    public Lotto() {
        this.values = new ArrayList<>();
        Random random = new Random();
        while (values.size() < LOTTO_SIZE) {
            LottoNumber lottoNumber = INITIALIZED_LOTTO.get(lottoRange(random));

            if (!values.contains(lottoNumber)) {
                values.add(lottoNumber);
            }
        }
    }

    public Lotto(String values) {

        Set<LottoNumber> lottoNumbers = Arrays.stream(values.split(", "))
                .mapToInt(Integer::parseInt)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toSet());

        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
        }

        this.values = new ArrayList<>(lottoNumbers);
    }

    private int lottoRange(Random random) {
        return random.nextInt(LOTTO_MAX_NUMBER) + LOTTO_MIN_NUMBER;
    }

    public String findLotto() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(OPEN_BRACKET);
        for (int i = 0; i < values.size(); i++) {
            stringBuilder.append(values.get(i).findNumber());
            if (i != LOTTO_SIZE - 1) {
                stringBuilder.append(DELIMITER);
            }
        }
        stringBuilder.append(CLOSE_BRACKET);
        return stringBuilder.toString();
    }

    public long calculateMatchCount(Lotto winningNumbers) {

        return values.stream()
                .filter(winningNumbers.values::contains)
                .count();
    }

    private static List<LottoNumber> initLottos() {
        List<LottoNumber> lottos = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            lottos.add(new LottoNumber(i));
        }

        return lottos;
    }
}
