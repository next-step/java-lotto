package lotto.domain;

import lotto.constant.Prize;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoMachine {

    private final int cashAmount;
    private final LottoNumbers balls;
    private ProfitRateStrategy profitRateStrategy;
    private static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_SIZE = 6;

    private LottoMachine(int cashAmount) {
        this.cashAmount = cashAmount;
        this.balls = new LottoNumbers();
        this.profitRateStrategy = new MissionProfitRateStrategy();
    }

    public void setProfitRateStrategy(ProfitRateStrategy profitRateStrategy) {
        this.profitRateStrategy = profitRateStrategy;
    }

    public static LottoMachine of(int cashAmount) {
        validateCashAmount(cashAmount);
        return new LottoMachine(cashAmount);
    }

    private static void validateCashAmount(int cashAmount) {
        if (cashAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또 구입 금액은 최소 " + LOTTO_PRICE + "원 이상이어야 합니다.");
        }
    }

    public List<Lotto> createAutomatically() {
        List<Lotto> lottoList = new ArrayList<>();
        int purchaseCount = calculatePurchaseCount();
        for (int i = 0; i < purchaseCount; i++) {
            balls.shuffle();
            Set<Integer> lottoBalls = new HashSet<>(balls.getNumbers().subList(0, LOTTO_SIZE));
            lottoList.add(new Lotto(lottoBalls));
        }
        return lottoList;
    }

    public Lotto createManually(Set<Integer> numbers) {
        return new Lotto(numbers);
    }

    public int calculatePurchaseCount() {
        return cashAmount / LOTTO_PRICE;
    }

    public EnumMap<Prize, Integer> checkLottoPrize(List<Lotto> lottoList, Set<Integer> winningNumbers, int bonusNumber) {
        EnumMap<Prize, Integer> countMap = new EnumMap<>(Prize.class);
        for (Lotto lotto : lottoList) {
            int count = match(lotto, winningNumbers);
            Prize prize = getPrize(bonusNumber, lotto, count);
            if (prize != null) {
                countMap.put(prize, countMap.getOrDefault(prize, 0) + 1);
            }
        }
        return countMap;
    }

    private Prize getPrize(int bonusNumber, Lotto lotto, int count) {
        Prize prize = Prize.valueOf(count);
        if (prize == Prize.THIRD && isBonusNumberMatch(lotto, bonusNumber)) {
            prize = Prize.SECOND;
        }
        return prize;
    }

    private int match(Lotto lotto, Set<Integer> winningNumbers) {
        return lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .collect(Collectors.toList()).size();
    }

    private boolean isBonusNumberMatch(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public String calculateProfitRate(EnumMap<Prize, Integer> countMap) {
        return profitRateStrategy.calculateProfitRate(countMap, cashAmount);
    }

    public static void validateLottoSize(Set<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_SIZE + "개여야 합니다.");
        }
    }

}
