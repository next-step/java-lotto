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

    public void bonusNumber(int bonusNumber) {
        this.bonusNumber =  bonusNumber;
    }

    public Map<Integer, Integer> getBonusNumber() {
        return bonusMap;
    }

    public double earningsRate(int price) {
        int total = map.get(3) * 5000;
        total += map.get(3) * 5000;
        total += map.get(4) * 50000;
        total += map.get(5) * 1500000;
        total += map.get(6) * 2000000000;
        System.out.println(total);
        return Math.floor((double) total / price * 100.0) / 100.0;
    }
}
