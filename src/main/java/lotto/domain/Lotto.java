package lotto.domain;

import lotto.utile.CollectionsNumber;

import java.util.ArrayList;
import java.util.Arrays;

public class Lotto {
    int[] lottoNumber;
    private final int ALL_LOTTO_NUMBER_COUNT = 45;
    private final int PICK_LOTTO_NUMBER_COUNT = 6;

    public Lotto() {
        this.lottoNumber = createLottoNumber();
    }

    public Lotto(int[] lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    private int[] createLottoNumber() {
        return sortLotto(shuffleLotto());
    }

    private int[] shuffleLotto() {
        int[] allLottoNumbers = new int[ALL_LOTTO_NUMBER_COUNT];
        for (int i = 0; i < allLottoNumbers.length; i++) {
            allLottoNumbers[i] = i + 1;
        }
        return CollectionsNumber.shuffleNumber(allLottoNumbers);
    }

    private int[] sortLotto(int[] allLottoNumbers) {
        int[] pickLottoNumbers = new int[PICK_LOTTO_NUMBER_COUNT];
        for (int i = 0; i < pickLottoNumbers.length; i++) {
            pickLottoNumbers[i] = allLottoNumbers[i];
        }

        CollectionsNumber.sortArrayNumber(pickLottoNumbers);
        return pickLottoNumbers;
    }

    public int[] getLottoNumber() {
        return lottoNumber;
    }

    public int getNumberOfMatchesInLotto(int[] winnerNumbers) {
        int[] lottoNumber = this.lottoNumber;
        Integer[] integerWinnerNumber = CollectionsNumber.convertIntToInteger(winnerNumbers);
        ArrayList<Integer> arrWinnerNumber = new ArrayList<>(Arrays.asList(integerWinnerNumber));
        int matchesCount = 0;
        for (int i = 0; i < lottoNumber.length; i++) {
            matchesCount += isMatchesNumber(arrWinnerNumber, lottoNumber[i]);
        }
        return  matchesCount;
    }

    private static int isMatchesNumber(ArrayList<Integer> arrWinnerNumber, int lottoNumber) {
        if(arrWinnerNumber.contains(lottoNumber)){
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(lottoNumber);
    }
}
