package lotto;

public class LottoCommonUtil {
    private static final String delimiter= "_";


    public static int convertMoneyFromString(String string) {
        String tempMoney = "";
        String[] values = string.split(delimiter);
        for(String value : values) {
            tempMoney += value;
        }
        return Integer.parseInt(tempMoney);

    }

}