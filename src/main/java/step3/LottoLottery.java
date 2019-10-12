package step3;


import java.util.*;

public class LottoLottery {

    static final int MATCHING_LIMIT = 3;
    static int BONUS_WINNING_COUNT = 0;

    public static Map<Integer, Integer> statisticResult = new HashMap<>();
    public static List<Integer> bonusWinningIndex = new ArrayList<>();

    /**
     * matchWinningNumbers 에서는 당첨번호 중 몇 개가 일치하는지 카운팅한다.
     * bonusLotto에 보너스 번호 당첨 대상 로또를 저장한다.
     */
    public static int matchWinningNumbers(Lotto purchasedLotto, List<Integer> winningNumbers) {
        final int count = (int) winningNumbers.stream()
                .filter(purchasedLotto.lotto::contains)
                .count();
        return count;
    }

    // Map 초기화 (당첨된 번호의 개수를 key 값으로 설정)
    public static void generateBasicStatistic() {
        for (int i = 1; i < LottoGenerator.WINNING_NUMBERS_LENGTH + 1; i++) {
            statisticResult.put(i, 0);
        }
    }

    // map의 key값을 contains하는지 확인
    // resultMatching 은 구매로또가 당첨번호와 얼마나 숫자 일치하는지 저장해놓은 List
    public static void summaryMatching(List<Integer> resultMatching, int matchCount) {
        if (resultMatching.contains(matchCount)) {
            int resultMatchCount = completeStatistic(resultMatching, matchCount);
            statisticResult.put(matchCount, resultMatchCount);
        }
    }

    // N개 일치하는 로또가 몇장인지 저장 (Map에 put)
    private static int completeStatistic(List<Integer> resultMatching, int matchCount) {
        return (int) Arrays.stream(resultMatching.toArray())
                .filter(matchingNumber -> matchingNumber.equals(matchCount))
                .count();
    }

    public double calculationOfYield(int lottoCount, Map<Integer, Integer> result) {
        int spandCash = lottoCount * Lotto.LOTTO_PRICE;
        // 수익률 = (상금 - 구매금액) / 구매금액  = (totalWard - spandCash) / spandCash
        for (int i = 1; i < LottoGenerator.WINNING_NUMBERS_LENGTH + 1; i++) {
            removeUnavailableValue(result, i);
        }
        if (!result.isEmpty()) {
            double totalWard = totalPrize(result);
            double earningRate = Math.abs(totalWard - spandCash);
            return  earningRate / spandCash;
//            return  1 - (earningRate / spandCash);
//            return  1 - (Math.abs(totalWard - spandCash) / spandCash);
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
        for (int i = MATCHING_LIMIT; i < LottoGenerator.WINNING_NUMBERS_LENGTH + 1; i++) {
            totalWard += calculateTotalPrize(result, i);
        }
        return totalWard;
    }

    private static double calculateTotalPrize(Map<Integer, Integer> result, int num) {
        double calculateResult = 0;
        if (!Objects.isNull(result.get(num)) && result.get(num) != 0) {
            calculateResult += result.get(num).doubleValue() * Prize.findByCountOfMatch(num).getWinningMoney();
        }
        return calculateResult;
    }

    public void checkBonusWinningChance(List<Integer> resultMatching) {
        for (int i = 0; i < resultMatching.size(); i++) {
            inputBonusWinningIndex(resultMatching, i);
        }
    }

    private void inputBonusWinningIndex(List<Integer> resultMatching, int index) {
        if (resultMatching.get(index) == 5) {
            bonusWinningIndex.add(index);
        }
    }

    public void pickOutBonusWinningLotto(Set<Lotto> purchasedLottos) {
        int indexCount = 0;
        for (Lotto purchasedLotto : purchasedLottos) {
            purchasedLottoCompareBonusNumber(purchasedLotto.lotto, indexCount);
            indexCount++;
        }
    }

    private void purchasedLottoCompareBonusNumber(List<Integer> purchasedLotto, int indexCount) {
        if (bonusWinningIndex.contains(indexCount)) {
            // 5개일치 로또가 보너스 번호도 일치하는지 확인
            BONUS_WINNING_COUNT = purchasedLotto.contains(Lotto.LOTTO_BONUS_NUMBER) ? BONUS_WINNING_COUNT + 1 : BONUS_WINNING_COUNT;
        }
    }
}