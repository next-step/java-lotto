package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int LOTTO_START_NUM = 1;
    private static final int LOTTO_END_NUM = 45;
    private static final int SELECT_NUMBER = 6;
    private static int price = 1000;
    private static List<Integer> lottoList;

    public static int getPrice() {
        return price;
    }

    public static void setPrice(int price) {
        Lotto.price = price;
    }

    public static List<Integer> getLottoList() {
        return lottoList;
    }

    public static void setLottoList(List<Integer> lottoList) {
        Lotto.lottoList = lottoList;
    }

    public static List<Integer> getLottoNumberList() {
        List<Integer> lottoList = new ArrayList<Integer>();
        for (int i = LOTTO_START_NUM; i <= LOTTO_END_NUM; i++) {
            lottoList.add(i);
        }
        return lottoList;
    }

    public static List<Integer> extractLottoNumber() {
        List<Integer> lottoNumberList = getLottoNumberList();
        Collections.shuffle(lottoNumberList);
        List<Integer> randomNumberList = lottoNumberList.subList(0, SELECT_NUMBER);
        Collections.sort(randomNumberList);
        return randomNumberList;
    }
}
