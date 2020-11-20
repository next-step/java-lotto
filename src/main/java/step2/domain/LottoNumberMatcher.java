package step2.domain;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LottoNumberMatcher {
    private static final int TWO_DECIMAL_PLACES = 2;
    private static final String TWO_DECIMAL_FORMAT = "0.##";
    private static final int DEFAULT_COUNT_NUMBER = 0;
    private static final int MIN_MATCH_NUMBER = 3;
    private static final int FOURTH_PRIZE = 5000;
    private static final int FOUR_MATCH_NUMBER = 4;
    private static final int THIRD_PRIZE = 50000;
    private static final int FIVE_MATCH_NUMBER = 5;
    private static final int SECOND_PRIZE = 1500000;
    private static final int MAX_MATCH_NUMBER = 6;
    private static final int FIRST_PRIZE = 2000000000;
    private static final int INIT_SUM = 0;

    static HashMap<Integer, Integer> hashMap = new HashMap<>();

    private static void initHashMap() {
        for (int i = MIN_MATCH_NUMBER; i <= MAX_MATCH_NUMBER; i++) {
            hashMap.put(i, DEFAULT_COUNT_NUMBER);
        }
    }

    public static HashMap<Integer, Integer> getNumberMatch(String[] winningLottoNumbers, List<List<Integer>> lottoNumbers) {
        initHashMap();

        for (List<Integer> eachMyLottoNumber : lottoNumbers) {
            long countTest = Arrays.stream(winningLottoNumbers)
                    .map(Integer::valueOf)
                    .filter(eachMyLottoNumber::contains)
                    .count();

            setNumberMatch((int) countTest);
        }
        return hashMap;
    }

    private static void setNumberMatch(int count) {
        Integer value = hashMap.getOrDefault(count, DEFAULT_COUNT_NUMBER);
        hashMap.put(count, ++value);
    }

    public static String getLottoRateOfReturn(int money) {
        int prizeMoney = sumOfTotalPrizeMoney();
        double lottoRateOfReturn = (double) prizeMoney / money;
        DecimalFormat decimalFormat = new DecimalFormat(TWO_DECIMAL_FORMAT);
        BigDecimal bigDecimal = new BigDecimal(lottoRateOfReturn);
        bigDecimal = bigDecimal.setScale(TWO_DECIMAL_PLACES, BigDecimal.ROUND_DOWN);
        return decimalFormat.format(bigDecimal);
    }

    static HashMap<Integer, Integer> getEachPrizeMoney() {
        HashMap<Integer, Integer> allPrizeMoney = new HashMap<>();
        allPrizeMoney.put(FOURTH_PRIZE, hashMap.get(MIN_MATCH_NUMBER));
        allPrizeMoney.put(THIRD_PRIZE, hashMap.get(FOUR_MATCH_NUMBER));
        allPrizeMoney.put(SECOND_PRIZE, hashMap.get(FIVE_MATCH_NUMBER));
        allPrizeMoney.put(FIRST_PRIZE, hashMap.get(MAX_MATCH_NUMBER));
        return allPrizeMoney;
    }

    static int sumOfTotalPrizeMoney() {
        int sum = INIT_SUM;
        for (Integer prizeMoney : getEachPrizeMoney().keySet()) {
            Integer countPrize = getEachPrizeMoney().get(prizeMoney);
            sum += countPrize * prizeMoney;
        }
        return sum;
    }
}
