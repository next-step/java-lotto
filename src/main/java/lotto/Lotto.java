package lotto;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//로또 한줄 구하는 객체
public class Lotto {
    private static final int LOTTO_MAX_COUNT = 45;
    private static final int LOTTO_NUMBER = 6;
    private List<LottoNo> numbers;
    private List<LottoNo> lotto;

    public Lotto() {
        numbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_MAX_COUNT; i++) {
            numbers.add(new LottoNo(i + 1));
        }
    }

    public Lotto(LottoNo[] oneTicket) {
        lotto = Arrays.asList(oneTicket);
    }

    public void generateLottoNumber() {
        shuffleNumbers();
        lotto = sortNumbers(pickSixNumbers());
    }

    public List<LottoNo> pickSixNumbers() {
        return numbers.subList(0, LOTTO_NUMBER);
    }

    public void shuffleNumbers() {
        Collections.shuffle(numbers);
    }

    public List<LottoNo> sortNumbers(List<LottoNo> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

    public boolean isContains(LottoNo num) {
        for (LottoNo no : this.lotto) {
            if (no.compareTo(num) == 0) {
                return true;
            }
        }
        return false;
    }

    public String toString(String delimeter) {
        String result = "";
        for (LottoNo no : this.lotto) {
            result += no.getNumber() + delimeter;
        }
        return result.substring(0, result.length() - delimeter.length());

    }

}
