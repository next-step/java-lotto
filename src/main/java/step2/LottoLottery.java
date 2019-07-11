package step2;

import com.sun.corba.se.impl.orbutil.ObjectUtility;

import java.util.*;

public class LottoLottery {

    static final int FIRST = 2_000_000_000;
    static final int SECOND = 1_500_000;
    static final int THIRD = 50_000;
    static final int FOURTH = 5_000;

    private Map<Integer, Integer> statisticResult = new HashMap<>();

    public List<Integer> lotteryStatics(Set<ArrayList<Integer>> purchasedLottos, int[] winningNumbers) {
        List<Integer> resultMatching = new ArrayList<>();
        for (ArrayList<Integer> purchasedLotto : purchasedLottos) {
            resultMatching.add(matchWinningNumbers(purchasedLotto, winningNumbers));
        }
        return resultMatching;
    }

    private int matchWinningNumbers(ArrayList<Integer> purchasedLotto, int[] winningNumbers) {
        int matchCount = 0;

        for (int winningNumber : winningNumbers) {
            matchCount += matchEachNumber(purchasedLotto, winningNumber);
        }
        return matchCount;
    }

    private int matchEachNumber(ArrayList<Integer> purchasedLotto, int winningNumbers) {
        if (purchasedLotto.contains(winningNumbers)) {
            return 1;
        }
        return 0;
    }

    // 통계를 내기위해...Map에 N개 일치하는(Key) 로또가 몇장인지 (Value) 저장
    public Map<Integer, Integer> giveStatistic(List<Integer> resultMatching) {
        generateBasicStatistic();
        for (int i = 1; i < Lotto.WINNING_NUMBERS_LENGTH + 1; i++) {
            summaryMatching(resultMatching, i);
        }
        return statisticResult;
    }

    // Map 초기화 (당첨된 번호의 개수를 key 값으로 설정)
    private void generateBasicStatistic() {
        for (int i = 1; i < Lotto.WINNING_NUMBERS_LENGTH + 1; i++) {
            statisticResult.put(i, 0);
        }
    }

    // map의 key값을 contains하는지 확인
    // resultMatching 은 구매로또가 당첨번호와 얼마나 숫자 일치하는지 저장해놓은 List
    private void summaryMatching(List<Integer> resultMatching, int matchCount) {
        if (resultMatching.contains(matchCount)) {
            completeStatistic(resultMatching, matchCount);
        }
    }

    // N개 일치하는 로또가 몇장인지 저장 (Map에 put)
    private void completeStatistic(List<Integer> resultMatching, int matchCount) {
        int test = 0;
        for (int matchingNumber : resultMatching) {
            if (matchingNumber == matchCount) {
                test += 1;
                statisticResult.put(matchCount, test);
            }
        }
    }

    public double calculationOfYield(int lottoCount, Map<Integer, Integer> result) {
        int spandCash = lottoCount * Lotto.LOTTO_PRICE;
        // 수익률 = 상금/ 구매금액 * 100
        // 수익률 = 상금/ spandCash  * 100

        for (int i = 1; i < Lotto.WINNING_NUMBERS_LENGTH + 1; i++) {
            removeUnavailableValue(result, i);
        }
        if (!result.isEmpty()) {
            return (totalWard(result) / spandCash * 100) / 100;
        }
        return 0;
    }

    private void removeUnavailableValue(Map<Integer, Integer> result, int key) {
        // 1. 수익률 계산에 유효한 값은 map의 key가 3인 것부터 유효하므로 삭제
        if (key < 3) {
            result.remove(key);
        }
        // 2. 1. 수익률 계산에 유효한 값은 value가 0 초과인 것이므로 삭제
        if (result.remove(key, 0)) {
            result.remove(key);
        }
    }

    private double totalWard(Map<Integer, Integer> result) {
        double totalWard = 0;
        if (!Objects.isNull(result.get(3)) && result.get(3) != 0) {
            totalWard += result.get(3).doubleValue() * FOURTH;
        }
        if (!Objects.isNull(result.get(4)) && result.get(4) != 0) {
            totalWard += result.get(4).doubleValue() * THIRD;
        }
        if (!Objects.isNull(result.get(5)) && result.get(5) != 0) {
            totalWard += result.get(5).doubleValue() * SECOND;
        }
        if (!Objects.isNull(result.get(6)) && result.get(6) != 0) {
            totalWard += result.get(6).doubleValue() * FIRST;
        }

        return totalWard;
    }
}

