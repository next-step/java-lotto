package domain;

import view.ResultView;

import java.util.*;

public class LottoResult {
    public final static int FIRST_WINNING_PRIZE = 2000000000;
    public final static int SECOND_WINNING_PRIZE = 1500000;
    public final static int THIRD_WINNING_PRIZE = 50000;
    public final static int FORTH_WINNING_PRIZE = 5000;

    public final static int FIRST_WINNING_POINT = 6;
    public final static int SECOND_WINNING_POINT = 5;
    public final static int THIRD_WINNING_POINT = 4;
    public final static int FORTH_WINNING_POINT = 3;

    private final static int SUBSTR_POINT_ONE = 1;
    private final static int SUBSTR_POINT_TWO = 2;

    private static Integer[] resultOfMatch;
    private static List<Integer> resultOfMatchConvertList;
    private static Map<Integer, Integer> countOfWinner;
    private static int lottoPrice;
    private static double revenue;

    // 로또 자동 생성 번호와 지난 당첨 번호를 비교하여 당첨 번호 갯수 확인
    public static void getNumberOfMatch(ArrayList<LottoNumber> lottoNumber, int[] prvLottoNumber, int price) {
        lottoPrice = price;
        resultOfMatch = new Integer[lottoNumber.size()];

        for (int i = 0; i < lottoNumber.size(); i++) {
            resultOfMatch[i] = lottoNumber.get(i).comparePrvNumber(prvLottoNumber);
        }
        calTotalPrize();
    }

    // 당첨번호 갯수에 따라서 당첨금 계산
    private static void calTotalPrize() {
        resultOfMatchConvertList = Arrays.asList(resultOfMatch); //당첨 번호 갯수에 따라서 몇등인지 확인하기 위하여  Array -> List 로 변환

        double total = (getCountFirstWinner() * FIRST_WINNING_PRIZE) + (getCountSecondWinner() * SECOND_WINNING_PRIZE)
                + (getCountThirdWinner() * THIRD_WINNING_PRIZE) + (getCountForthWinner() * FORTH_WINNING_PRIZE);


        revenue = total / lottoPrice;
        ResultView.printResult(getPercentOfRevenue(), makeListOfWinner());

    }

    // 계산된 수익율을 퍼센티지로 표현 (소수 2자리까지/ 단, 소수 한자리 일경우 한자리만 표현되도록 )
    private static Double getPercentOfRevenue() {
        String[] result = String.valueOf(revenue).split("\\.");
        String percent = null;
        if (result[1].length() == SUBSTR_POINT_ONE)
            percent = result[0] + "." + result[1].substring(0, SUBSTR_POINT_ONE);
        if (result[1].length() > SUBSTR_POINT_ONE)
            percent = result[0] + "." + result[1].substring(0, SUBSTR_POINT_TWO);
        return Double.parseDouble(percent);

    }

    // hashmap 활용하여 등수별 count 수를 저장 (출력용)
    private static Map<Integer, Integer> makeListOfWinner() {
        countOfWinner = new HashMap<>();
        countOfWinner.put(FIRST_WINNING_PRIZE, (int) getCountFirstWinner());
        countOfWinner.put(SECOND_WINNING_PRIZE, (int) getCountSecondWinner());
        countOfWinner.put(THIRD_WINNING_PRIZE, (int) getCountThirdWinner());
        countOfWinner.put(FORTH_WINNING_PRIZE, (int) getCountForthWinner());
        return countOfWinner;
    }

    // 1등 count 확인 (stream 활용)
    private static long getCountFirstWinner() {
        return resultOfMatchConvertList.stream().filter(x -> x.equals(FIRST_WINNING_POINT)).count();
    }

    // 2등 count 확인
    private static long getCountSecondWinner() {
        return resultOfMatchConvertList.stream().filter(x -> x.equals(SECOND_WINNING_POINT)).count();
    }

    // 3등 count 확인
    private static long getCountThirdWinner() {
        return resultOfMatchConvertList.stream().filter(x -> x.equals(THIRD_WINNING_POINT)).count();
    }

    // 4등 count 확인
    private static long getCountForthWinner() {
        return resultOfMatchConvertList.stream().filter(x -> x.equals(FORTH_WINNING_POINT)).count();
    }

    // 수익율이 이익인지 손해인지 판단 (출력용)
    public static String judgeResult() {
        if (revenue > 1)
            return "이익";
        if (revenue == 1)
            return "본전치기";
        return "손해";
    }
}
