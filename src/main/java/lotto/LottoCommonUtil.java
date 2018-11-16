package lotto;

public class LottoCommonUtil {
    private static final String DELIMETER_UNDER_BAR = "_";

    public static int convertMoneyFromString(String string) {
        String tempMoney = "";
        String[] values = string.split(DELIMETER_UNDER_BAR);
        for(String value : values) {
            tempMoney += value;
        }
        return Integer.parseInt(tempMoney);
    }

}