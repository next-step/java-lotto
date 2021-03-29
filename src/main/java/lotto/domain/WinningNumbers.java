package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WinningNumbers {
    public static final int SECOND_COUNT = 5;
    int[] winNumbers;
    int bonusNumber;
    Map<Integer, Integer> map;

    public WinningNumbers(String[] winNumbers) {
        this(Stream.of(winNumbers).mapToInt(Integer::parseInt).toArray());
    }

    public WinningNumbers(int[] winNumbers) {
        map = new HashMap<>();
        map.put(1, 0); //1등 - 6개일치
        map.put(2, 0); //2등 - 5개일치 + 보너스
        map.put(3, 0); //3등 - 5개일치
        map.put(4, 0); //4등 - 4개일치
        map.put(5, 0); //5등 - 3개일치
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
        if (lottoNumber.contains(bonusNumber) && correct == SECOND_COUNT) {
            map.put(correct, 1);
        }
        map.put(correct, map.getOrDefault(correct, 0) + 1);
    }

    public void bonusNumber(int bonusNumber) {
        this.bonusNumber =  bonusNumber;
    }

    public double earningsRate(int price) {
        int total = map.get(3) * 5000;
        total += map.get(4) * 50000;
        total += map.get(5) * 1500000;
        total += map.get(6) * 2000000000;
        System.out.println(total);
        return Math.floor((double) total / price * 100.0) / 100.0;
    }
}
