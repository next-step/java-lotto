package lotto.domain;

import lotto.constant.LottoConstant;
import lotto.constant.Prize;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class LottoMachine {

    private final int cashAmount;
    private final List<Integer> balls = new ArrayList<>();

    public LottoMachine(int cashAmount) {
        if (cashAmount < LottoConstant.LOTTO_PRICE) {
            throw new IllegalArgumentException("로또 구입 금액은 최소 " + LottoConstant.LOTTO_PRICE + "원 이상이어야 합니다.");
        }
        this.cashAmount = cashAmount;
        for (int i = LottoConstant.LOTTO_START_NUMBER; i <= LottoConstant.LOTTO_END_NUMBER; i++) {
            balls.add(i);
        }
    }

    public List<Integer> getBalls() {
        return Collections.unmodifiableList(balls);
    }

    public abstract List<Lotto> create();

    public int calculatePurchaseCount() {
        return cashAmount / LottoConstant.LOTTO_PRICE;
    }

    public int match(Lotto lotto, Set<Integer> winningNumbers) {
        return lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .collect(Collectors.toList()).size();
    }

    public String calculateProfitRate(EnumMap<Prize, Integer> countMap, int decimalPlace) {
        int sum = Arrays.stream(Prize.values())
                .mapToInt(p -> p.getPrizeMoney() * countMap.getOrDefault(p, 0))
                .sum();

        double profitRate = (double) sum / cashAmount;

        String decimalPattern = "0." + "0".repeat(Math.max(0, decimalPlace));
        DecimalFormat decimalFormat = new DecimalFormat(decimalPattern);
        return decimalFormat.format(profitRate);
    }

}
