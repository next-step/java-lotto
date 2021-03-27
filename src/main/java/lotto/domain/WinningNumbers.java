package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WinningNumbers {
    int[] winNumbers;
    int bonusNumber;
    Map<Integer, Integer> map;
    Map<Integer, Integer> bonusMap;

    public WinningNumbers(String[] winNumbers) {
        this(Stream.of(winNumbers).mapToInt(Integer::parseInt).toArray());
    }

    public WinningNumbers(int[] winNumbers) {
        map = new HashMap<>();
        bonusMap = new HashMap<>();
        map.put(3, 0);
        map.put(4, 0);
        map.put(5, 0);
        map.put(6, 0);
        bonusMap.putAll(map);
        this.winNumbers = winNumbers;
    }

    public Map<Integer, Integer> getWinNumbers(Lotto lotto) {
        return this.getWinNumbers(lotto.lotto());
    }

    public Map<Integer, Integer> getWinNumbers(List<LottoNumbers> lottoNumbers) {
        choose(lottoNumbers);
        return map;
    }

    private void choose(List<LottoNumbers> lottoNumbers) {
        for (LottoNumbers lottoNumber : lottoNumbers) {
            count(lottoNumber);
        }
    }

    private void count(LottoNumbers lottoNumber) {
        int correct = 0;
        for (int win : winNumbers) {
            if (lottoNumber.contains(win)) {
                correct++;
            }
        }
        if (lottoNumber.contains(bonusNumber)) {
            correct++;
            bonusMap.put(correct, map.getOrDefault(correct, 0) + 1);
        }
        map.put(correct, map.getOrDefault(correct, 0) + 1);
    }

    public void addBonusNumbers(int[] bonusNumbers) {
        this.winNumbers = IntStream.concat(IntStream.of(this.winNumbers), IntStream.of(bonusNumbers)).toArray();
    }

    public void addBonusNumbers(String[] bonusNumbers) {
        this.winNumbers = IntStream.concat(
                IntStream.of(this.winNumbers),
                IntStream.of(
                        Stream.of(bonusNumbers)
                                .mapToInt(Integer::parseInt)
                                .toArray())
        ).toArray();
    }

    public void bonusNumber(int bonusNumber) {
        this.bonusNumber =  bonusNumber;
    }

    public Map<Integer, Integer> getBonusNumber() {
        return bonusMap;
    }
}
