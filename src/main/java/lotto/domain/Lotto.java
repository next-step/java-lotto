package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final String LOTTO_NUMBERS_SEPARATOR = ",";
    private final List<Number> lotto;

    Lotto() {
        this.lotto = generateAutoLotto();
    }

    Lotto(String lottoNumber) {
        this.lotto = Arrays.stream(lottoNumber.split(LOTTO_NUMBERS_SEPARATOR))
                .map(number -> new Number(number.trim())).sorted()
                .collect(Collectors.toList());
    }

    private List<Number> generateAutoLotto() {
        List<Number> allLottoNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            allLottoNumbers.add(new Number(i));
        }
        Collections.shuffle(allLottoNumbers);

        List<Number> autoNumbers = allLottoNumbers.subList(0, 6);
        Collections.sort(autoNumbers);
        return autoNumbers;
    }

    public int getNumberOfMatch(Lotto winnerLotto) {
        return (int) winnerLotto.getLotto().stream()
                .filter(winnerNumber -> isMatchNumber(winnerNumber))
                .count();
    }

    public boolean isMatchNumber(Number winnerNumber) {
        return lotto.stream().anyMatch(number -> number.compareTo(winnerNumber) == 0);
    }

    private List<Number> getLotto() {
        return lotto;
    }

    public String getLottoToString() {
        return lotto.stream().map(number -> String.valueOf(number.getNumber()))
                .collect(Collectors.joining(","));
    }
}
