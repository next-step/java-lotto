package lotto.utile;

public class Deduplicator {
    public static int checkDuplication(int[] arrLottoNumber, int randomNumber) {
        int returnDecreaseNumber = 0;
        for (int i = 0; i < arrLottoNumber.length; i++) {
            returnDecreaseNumber += compareNumber(arrLottoNumber[i], randomNumber);
        }

        if(returnDecreaseNumber < 0){
            return -1;
        }
        return 0;
    }

    private static int compareNumber(int lottoNumber, int randomNumber) {
        if (lottoNumber == randomNumber) {
            return -1;
        }
        return 0;
    }
}
