package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    public static List<Integer> generateLotto() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);

        List<Integer> lottoNumbers = numbers.subList(0, 6);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public static List<List<Integer>> generateLottos(int money) {
        List<List<Integer>> lottos = new ArrayList<>();
        for (int i = 0; i < money / 1000; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    public static int countMatches(List<Integer> lotto, List<Integer> winningNumbers) {
        int count = 0;
        for (Integer number : lotto) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }
}
