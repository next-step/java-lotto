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

    private final static int SUBSTR_POINT_ZERO = 1;
    private final static int SUBSTR_POINT_NONEZERO = 2;

    private static Integer[] resultOfMatch;
    private static List<Integer> resultOfMatchConvertList;
    private static Map<Integer, Integer> countOfWinner;
    private static int lottoPrice;
    private static double revenue;

    public static void getNumberOfMatch(ArrayList<LottoNumber> lottoNumber, int[] prvLottoNumber, int price) {
        lottoPrice = price;
        resultOfMatch = new Integer[lottoNumber.size()];

        for (int i = 0; i < lottoNumber.size(); i++) {
            resultOfMatch[i] = lottoNumber.get(i).comparePrvNumber(prvLottoNumber);
        }
        calTotalPrize();
    }

    private static void calTotalPrize() {
        resultOfMatchConvertList = Arrays.asList(resultOfMatch);

        double total = (getCountFirstWinner() * FIRST_WINNING_PRIZE) + (getCountSecondWinner() * SECOND_WINNING_PRIZE)
                + (getCountThirdWinner() * THIRD_WINNING_PRIZE) + (getCountForthWinner() * FORTH_WINNING_PRIZE);


        revenue = total / lottoPrice;
        ResultView.printResult(getPercentOfRevenue(), makeListOfWinner());

    }

    private static Double getPercentOfRevenue() {
        String[] result = String.valueOf(revenue).split("\\.");
        String percent = null;
        if (result[1].length() == SUBSTR_POINT_ZERO)
            percent = result[0] + "." + result[1].substring(0, SUBSTR_POINT_ZERO);
        if (result[1].length() > SUBSTR_POINT_ZERO)
            percent = result[0] + "." + result[1].substring(0, SUBSTR_POINT_NONEZERO);
        return Double.parseDouble(percent);

    }

    private static Map<Integer, Integer> makeListOfWinner() {
        countOfWinner = new HashMap<>();
        countOfWinner.put(FIRST_WINNING_PRIZE, (int) getCountFirstWinner());
        countOfWinner.put(SECOND_WINNING_PRIZE, (int) getCountSecondWinner());
        countOfWinner.put(THIRD_WINNING_PRIZE, (int) getCountThirdWinner());
        countOfWinner.put(FORTH_WINNING_PRIZE, (int) getCountForthWinner());
        return countOfWinner;
    }

    private static long getCountFirstWinner() {
        return resultOfMatchConvertList.stream().filter(x -> x.equals(FIRST_WINNING_POINT)).count();
    }

    private static long getCountSecondWinner() {
        return resultOfMatchConvertList.stream().filter(x -> x.equals(SECOND_WINNING_POINT)).count();
    }

    private static long getCountThirdWinner() {
        return resultOfMatchConvertList.stream().filter(x -> x.equals(THIRD_WINNING_POINT)).count();
    }

    private static long getCountForthWinner() {
        return resultOfMatchConvertList.stream().filter(x -> x.equals(FORTH_WINNING_POINT)).count();
    }

    public static String judgeResult() {
        if (revenue > 0)
            return "이익";
        if (revenue < 0)
            return "손해";
        return null;
    }
}
