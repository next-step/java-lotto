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

//    private int firstPlace = 0;
//    private int secondPlace = 0;
//    private int thirdPlace = 0;
//    private int fourthPlace = 0;
//    private int fifthPlace = 0;
//    private final List<Integer> lottoNumbers;

    public LottoResult(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public void addGame(Lotto lottoGame) {
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







}
