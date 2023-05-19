package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final String LOTTO_NUMBERS_SEPARATOR = ",";
    private static final int LOTTO_SIZE = 6;
    private static List<Number> allLottoNumbers = new ArrayList<>();

    private final List<Number> lotto;

    static {
        for (int i = Number.LOTTO_NUMBER_LOWER_BOUND; i <= Number.LOTTO_NUMBER_UPPER_BOUND; i++) {
            allLottoNumbers.add(Number.from(i));
        }
    }

    private Lotto(List<Number> numbers) {
        this.lotto = numbers;
    }

    static Lotto createAutoLotto() {
        Collections.shuffle(allLottoNumbers);
        return new Lotto(allLottoNumbers.stream().limit(LOTTO_SIZE).sorted().collect(Collectors.toList()));
    }

    static Lotto createManualLotto(String lottoNumber) {
        return new Lotto(Arrays.stream(lottoNumber.split(LOTTO_NUMBERS_SEPARATOR))
                .map(number -> Number.from(number.trim())).sorted()
                .collect(Collectors.toList()));
    }

    public int getNumberOfMatch(Lotto winnerLotto) {
        return (int) winnerLotto.getLotto().stream()
                .filter(winnerNumber -> isMatchNumber(winnerNumber))
                .count();
    }

    public boolean isMatchNumber(Number winnerNumber) {
        return lotto.stream().anyMatch(number -> number == winnerNumber);
    }

    private List<Number> getLotto() {
        return lotto;
    }

    public String getLottoToString() {
        return lotto.stream().map(number -> String.valueOf(number.getNumber()))
                .collect(Collectors.joining(","));
    }
}
