package step2.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    private List<Integer> numbers = new ArrayList<>();
    private Map<Integer, Boolean> lottoNumbers = new HashMap<>();

    public Lotto() {
        setUpNumber();
        for (int i = 0; i < 6; i++) {
            lottoNumbers.put(numbers.get(i), true);
        }
    }

    public Lotto(List<Integer> input) {
        for (int i = 0; i < 6; i++) {
            lottoNumbers.put(input.get(i), true);
        }
    }

    public Lotto(String[] input) {
        this(Arrays.stream(input).map(Integer::parseInt).collect(Collectors.toList()));
    }

    public Lotto(String input) {
        this(input.split(", "));
    }

    public Lotto(int one, int two, int three, int four, int five, int six) {
        this(Arrays.asList(one, two, three, four, five, six));
    }


    private void setUpNumber() {
        for (int i = 1; i < 46; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
    }


    public int matchCount(WinningLotto lotto) {
        int count = 0;
        Map<Integer, Boolean> map = lotto.getLottoNumbers();

        for (Integer key : map.keySet()) {
            count += isContainKey(key);
        }
        return count;
    }

    public boolean matchBonus(WinningLotto lotto) {
        int bonusNumber = lotto.getBonusNumber();
        return matchCount(lotto) == 5 && isContainKey(bonusNumber) == 1;
    }

    private int isContainKey(Integer key) {
        if (lottoNumbers.containsKey(key)) {
            return 1;
        }
        return 0;
    }


    public Map<Integer, Boolean> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return "" + lottoNumbers.keySet() + "";
    }
}
