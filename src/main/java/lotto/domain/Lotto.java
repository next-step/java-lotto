package lotto.domain;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final String LOTTO_NUMBERS_SEPARATOR = ",";
    private final List<Number> lotto;

    Lotto() {
        this.lotto = generateLotto();
    }

    Lotto(String lottoNumber) {
        List<Integer> lottoNumbers = Arrays.stream(lottoNumber.split(LOTTO_NUMBERS_SEPARATOR))
                .map(number -> Integer.parseInt(number.trim()))
                .collect(Collectors.toList());

        this.lotto = getNumbers(lottoNumbers);
    }

    private List<Number> generateLotto() {
        List<Integer> allLottoNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            allLottoNumbers.add(i);
        }
        Collections.shuffle(allLottoNumbers);

        return getNumbers(allLottoNumbers.subList(0, 6));
    }

    private List<Number> getNumbers(List<Integer> allLottoNumbers) {
        List<Number> resultRottoNumbers = new ArrayList<>();

        for (int resultRottoNumber : allLottoNumbers) {
            resultRottoNumbers.add(new Number(resultRottoNumber));
        }
        Collections.sort(resultRottoNumbers);
        return resultRottoNumbers;
    }

    public int getNumberOfMatch(Lotto winnerLotto) {
        int count = 0;
        
        for (Number winnerNumber : winnerLotto.getLotto()) {
            count = getNumberOfMatch(count, winnerNumber);
        }
        return count;
    }

    private int getNumberOfMatch(int count, Number winnerNumber) {
        for (Number number : lotto) {
            if (number.compareTo(winnerNumber) == 0) {
                count++;
            }
        }
        return count;
    }

    private List<Number> getLotto() {
        return lotto;
    }

    public String getLottoToString() {
        return lotto.stream().map(number -> String.valueOf(number.getNumber()))
                .collect(Collectors.joining(","));
    }
}
