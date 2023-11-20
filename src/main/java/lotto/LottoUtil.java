package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoUtil {
    private static final int PRICE_PER_LOTTO = 1000;
    private static final int LOTTO_NUMBER_BOUNDARY = 45;

    public static int returnLottoCount(int money) {
        return money / PRICE_PER_LOTTO;
    }

    public static List<Integer> generateLottoNumber(){
        List<Integer> numberList = new ArrayList<>();
        for (int i = 1; i <= LOTTO_NUMBER_BOUNDARY; i++) {
            numberList.add(i);
        }

        Collections.shuffle(numberList);

        return numberList;
    }

    public static String[] splitString(String string){
        return string.split(",");
    }
}
