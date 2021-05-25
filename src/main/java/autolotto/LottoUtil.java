package autolotto;

public class LottoUtil {
    static final public int LOTTO_PRICE = 1000;

    static public int getLottoBuyingCount(int money) {
        return Math.round(money / LOTTO_PRICE);
    }

    static public int[] convertWinNumberStringToIntArray(String winNumber) {
        String[] splitString = winNumber.split(",");
        int[] winNumberArray = new int[splitString.length];
        for (int i = 0; i < splitString.length; i++) {
            winNumberArray[i] = Integer.parseInt(splitString[i]);
        }
        return winNumberArray;
    }
}
