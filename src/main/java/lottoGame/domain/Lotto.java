package lottoGame.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private Map<LottoNumber, Boolean> lottoNumbers = new HashMap<>();

    // 자동
    public Lotto() {
        List<LottoNumber> shuffledNumbers = LottoShuffle.shuffle();
        IntStream.range(0, 6).forEach(i -> lottoNumbers.put(shuffledNumbers.get(i), true));
    }

    // 수동
    public Lotto(List<Integer> input) {
        IntStream.range(0, 6).forEach(i -> lottoNumbers.put(LottoNumber.of(input.get(i)), true));
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


    public int matchCount(WinningLotto lotto) {
        int count = 0;
        Map<LottoNumber, Boolean> map = lotto.getLottoNumbers();

        for (LottoNumber key : map.keySet()) {
            count += isContainKey(key);
        }
        return count;
    }

    public boolean matchBonus(WinningLotto lotto) {
        LottoNumber bonusNumber = lotto.getBonusNumber();
        return matchCount(lotto) == 5 && isContainKey(bonusNumber) == 1;
    }

    private int isContainKey(LottoNumber key) {
        if (lottoNumbers.containsKey(key)) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        List<LottoNumber> keySet = new ArrayList<>(lottoNumbers.keySet());
        Collections.sort(keySet);
        return "" + keySet.toString() + "";
    }
}
