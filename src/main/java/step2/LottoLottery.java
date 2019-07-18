package step2;

import java.util.*;

public class LottoLottery {

    static final int MATCHING_LIMIT = 3;
    private static final int MAKE_FLOAT = 100;

    private static Map<Integer, Integer> statisticResult = new HashMap<>();

    public List<Integer> lotteryStatics(Set<List<Integer>> purchasedLottos, int[] winningNumbers) {
        List<Integer> resultMatching = new ArrayList<>();
        for (List<Integer> purchasedLotto : purchasedLottos) {
            resultMatching.add(matchWinningNumbers(purchasedLotto, winningNumbers));
        }
        return resultMatching;
    }

    private int matchWinningNumbers(List<Integer> purchasedLotto, int[] winningNumbers) {
        return (int) Arrays.stream(winningNumbers)
                .filter(purchasedLotto::contains)
                .count();
    }

    // 통계를 내기위해 Map에 N개 일치하는(Key) 로또가 몇장인지 (Value) 저장
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
            int resultMatchCount = completeStatistic(resultMatching, matchCount);
            statisticResult.put(matchCount, resultMatchCount);
        }
    }

    // N개 일치하는 로또가 몇장인지 저장 (Map에 put)
    private int completeStatistic(List<Integer> resultMatching, int matchCount) {
        return (int) Arrays.stream(resultMatching.toArray())
                .filter(matchingNumber -> matchingNumber.equals(matchCount))
                .count();
    }

    public double calculationOfYield(int lottoCount, Map<Integer, Integer> result) {
        int spandCash = lottoCount * Lotto.LOTTO_PRICE;
        // 수익률 = 상금/ 구매금액 * 100
        // 수익률 = 상금/ spandCash  * 100

        for (int i = 1; i < Lotto.WINNING_NUMBERS_LENGTH + 1; i++) {
            removeUnavailableValue(result, i);
        }
        if (!result.isEmpty()) {
            return (totalPrize(result) / spandCash * MAKE_FLOAT) / MAKE_FLOAT;
        }
        return 0;
    }

    public static void removeUnavailableValue(Map<Integer, Integer> result, int key) {
        // 1. 수익률 계산에 유효한 값은 map의 key가 3인 것부터 유효하므로 삭제
        if (key < MATCHING_LIMIT) {
            result.remove(key);
        }
        // 2. 1. 수익률 계산에 유효한 값은 value가 0 초과인 것이므로 삭제
        if (result.remove(key, 0)) {
            result.remove(key);
        }
    }

    public static double totalPrize(Map<Integer, Integer> result) {
        double totalWard = 0;
        for (int i = MATCHING_LIMIT; i < Lotto.WINNING_NUMBERS_LENGTH + 1; i++) {
            totalWard += calculateTotalPrize(result, i);
        }
        return totalWard;
    }

    private static double calculateTotalPrize( Map<Integer, Integer> result, int num ){
        double calculateResult = 0;
        if (!Objects.isNull(result.get(num)) && result.get(num) != 0) {
            calculateResult += result.get(num).doubleValue() * Prize.findByCountOfMatch(num).getWinningMoney();
        }
        return calculateResult;
    }
}