package lotto;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Lotto {
    private static final int LOTTO_MAX_COUNT = 46;
    private static final int LOTTO_NUMBER = 6;
    private List<Integer> numbers;
    private Set<LottoNo> lotto2;

    public Lotto(Set<LottoNo> lotto) {
        this.lotto2 = lotto;
    }

    public void generateLottoNumber() {

        shuffleNumbers();
        lotto2 = changeType(sortNumbers(pickSixNumbers()));
    }

    public Set<LottoNo> changeType(List<Integer> lottoNumber) {
        Set<LottoNo> lotto = new HashSet<>();
        for (Integer number : lottoNumber) {
            lotto.add(LottoNo.of(number));
        }
        return lotto;
    }

    public List<Integer> pickSixNumbers() {
        return numbers.subList(0, LOTTO_NUMBER);
    }

    public void shuffleNumbers() {
        numbers = IntStream.range(1, LOTTO_MAX_COUNT).boxed().collect(Collectors.toList());
        Collections.shuffle(numbers);
    }

    public List<Integer> sortNumbers(List<Integer> numbers) {

        Collections.sort(numbers);
        return numbers;

    }

    public boolean isContains(LottoNo num) {
        return this.lotto2.contains(num);
    }

    public String toString(String delimeter) {
        String result = "";
        for (LottoNo no : this.lotto2) {
            result += no.toString() + delimeter;
        }
        return result.substring(0, result.length() - delimeter.length());

    }

}
