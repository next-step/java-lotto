package lotto_step3.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    public static final int PRICE = 1_000;
    private static final int MAX_SIZE = 6;
    private static final String STRING_SPLITTER = ", ";

    private final Set<Integer> lotto;

    public Lotto(Set<Integer> lotto) {
        if (lotto.isEmpty() || lotto.size() > MAX_SIZE) {
            throw new IllegalArgumentException("유효하지 않은 로또입니다.");
        }
        LottoNumber.check(lotto);
        this.lotto = lotto;
    }

    public static Lotto from(List<Integer> numbers) {
        Set<Integer> newLotto = new HashSet<>();
        for (Integer number : numbers) {
            newLotto.add(number);
        }
        return new Lotto(newLotto);
    }

    public static Lotto from(String stringNumbers) {
        Set<Integer> newLotto = new HashSet<>();
        String[] numbers = stringNumbers.split(STRING_SPLITTER);
        for (String number : numbers) {
            newLotto.add(Integer.parseInt(number));
        }
        return new Lotto(newLotto);
    }

    public int matchCount(Lotto otherLotto) {
        return (int) lotto.stream().filter(number -> otherLotto.contains(number)).count();
    }

    public boolean contains(int number) {
        return lotto.contains(number);
    }

    @Override
    public String toString() {
        List<Integer> lottoList = lotto.stream().collect(Collectors.toList());
        Collections.sort(lottoList);
        return lottoList.toString();
    }
}
