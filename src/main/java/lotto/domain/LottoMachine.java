package lotto.domain;

import lotto.constant.LottoConstant;
import lotto.constant.Prize;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoMachine {

    private final int cashAmount;
    private final List<Integer> balls = new ArrayList<>();

    private LottoMachine(int cashAmount) {
        this.cashAmount = cashAmount;
        for (int i = LottoConstant.LOTTO_START_NUMBER; i <= LottoConstant.LOTTO_END_NUMBER; i++) {
            balls.add(i);
        }
    }

    public static LottoMachine of(int cashAmount) {
        validateCashAmount(cashAmount);
        return new LottoMachine(cashAmount);
    }

    private static void validateCashAmount(int cashAmount) {
        if (cashAmount < LottoConstant.LOTTO_PRICE) {
            throw new IllegalArgumentException("로또 구입 금액은 최소 " + LottoConstant.LOTTO_PRICE + "원 이상이어야 합니다.");
        }
    }

    public List<Integer> getBalls() {
        return Collections.unmodifiableList(balls);
    }

    public List<Lotto> createAutomatically() {
        List<Lotto> lottoList = new ArrayList<>();
        int purchaseCount = calculatePurchaseCount();
        for (int i = 0; i < purchaseCount; i++) {
            Collections.shuffle(balls);
            Set<Integer> lottoBalls = new HashSet<>(getBalls().subList(0, LottoConstant.LOTTO_SIZE));
            lottoList.add(new Lotto(lottoBalls));
        }
        return lottoList;
    }

    public Lotto createManually(Set<Integer> numbers) {
        return new Lotto(numbers);
    }

    public int calculatePurchaseCount() {
        return cashAmount / LottoConstant.LOTTO_PRICE;
    }

    public EnumMap<Prize, Integer> checkLottoPrize(List<Lotto> lottoList, Set<Integer> winningNumbers) {
        EnumMap<Prize, Integer> countMap = new EnumMap<>(Prize.class);
        for (Lotto lotto : lottoList) {
            int count = match(lotto, winningNumbers);
            Prize prize = Prize.valueOf(count);
            if (prize != null) {
                countMap.put(prize, countMap.getOrDefault(prize, 0) + 1);
            }
        }
        return countMap;

    }

    private int match(Lotto lotto, Set<Integer> winningNumbers) {
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
