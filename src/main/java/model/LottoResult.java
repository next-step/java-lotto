package model;

import java.util.List;

public class LottoResult {
    private static final int LOTTO_PRICE = 1000;
    private static final int FIRST_PLACE_MATCH = 6;
    private static final int SECOND_PLACE_MATCH = 5;
    private static final int THIRD_PLACE_MATCH = 4;
    private static final int FOURTH_PLACE_MATCH = 3;

    private static final int FIRST_PLACE_PRIZE = 2000000000;
    private static final int SECOND_PLACE_PRIZE = 1500000;
    private static final int THIRD_PLACE_PRIZE = 50000;
    private static final int FOURTH_PLACE_PRIZE = 5000;
    private static final int FIFTH_PLACE_PRIZE = 0;

    private int firstPlace = 0;
    private int secondPlace = 0;
    private int thirdPlace = 0;
    private int fourthPlace = 0;
    private int fifthPlace = 0;
    private final List<Integer> lottoNumbers;

    public LottoResult(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public void addGame(LottoGame lottoGame) {
        int count = lottoGame.getMatchNumber(lottoNumbers);

        switch (count) {
            case FIRST_PLACE_MATCH:
                firstPlace++;
                break;
            case SECOND_PLACE_MATCH:
                secondPlace++;
                break;
            case THIRD_PLACE_MATCH:
                thirdPlace++;
                break;
            case FOURTH_PLACE_MATCH:
                fourthPlace++;
                break;
            default:
                fifthPlace++;
                break;
        }
    }

    public List<String> getStatStrings() {
        return List.of(
                String.format("%d개 일치 (%d원)- %d개", FOURTH_PLACE_MATCH, FOURTH_PLACE_PRIZE, fourthPlace),
                String.format("%d개 일치 (%d원)- %d개", THIRD_PLACE_MATCH, THIRD_PLACE_PRIZE, thirdPlace),
                String.format("%d개 일치 (%d원)- %d개", SECOND_PLACE_MATCH, SECOND_PLACE_PRIZE, secondPlace),
                String.format("%d개 일치 (%d원)- %d개", FIRST_PLACE_MATCH, FIRST_PLACE_PRIZE, firstPlace),
                getYieldString()
        );
    }

    private String getYieldString() {
        int totalPrize = firstPlace * FIRST_PLACE_PRIZE + secondPlace * SECOND_PLACE_PRIZE + thirdPlace * THIRD_PLACE_PRIZE + fourthPlace * FOURTH_PLACE_PRIZE ;
        double yieldRatio = (double) totalPrize / ((firstPlace + secondPlace + thirdPlace + fourthPlace + fifthPlace) * LOTTO_PRICE);
        String result = "총 수익률은 " + yieldRatio + "입니다.";

        if (yieldRatio == 1) {
            return result + "(기준이 1이기 때문에 결과적으로 본전이라는 의미임)";
        }
        if (yieldRatio > 1) {
            return result + "(기준이 1이기 때문에 결과적으로 이득이라는 의미임)";
        }
        return result + "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    }



}
