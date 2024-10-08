package step2.domain;

import step2.constant.Prize;

import java.util.*;
import java.util.stream.Collectors;

public class LottoMachine {

    private static final List<Integer> balls = new ArrayList<>();
    private static final LottoMachine INSTANCE = new LottoMachine();
    private static final int LOTTO_SIZE = 6;

    private LottoMachine() {
        for (int i = 1; i <= 45; i++) {
            balls.add(i);
        }
    }

    public static LottoMachine getInstance() {
        return INSTANCE;
    }

    public List<Lotto> create(int purchaseCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            Collections.shuffle(balls);
            List<Integer> lottoBalls = new ArrayList<>(balls.subList(0, LOTTO_SIZE));
            lottoList.add(new Lotto(lottoBalls));
        }
        return lottoList;
    }

    public int match(Lotto lotto, Set<Integer> winningNumbers) {
        return lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .collect(Collectors.toList()).size();
    }

    public String calculateProfitRate(Map<Integer, Integer> countMap, int cashAmount) {
        int sum = Arrays.stream(Prize.values())
                .mapToInt(p -> p.getPrizeMoney() * countMap.getOrDefault(p.getMatchCount(), 0))
                .sum();
        return String.format("%.2f", (double) sum / cashAmount);
    }

}
