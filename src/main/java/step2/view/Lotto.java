package step2.view;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final int LOTTO_START_NUM = 1;
    private static final int LOTTO_END_NUM = 45;

    public static int getPrice() {
        return price;
    }

    public static void setPrice(int price) {
        Lotto.price = price;
    }

    private static int price = 1000;
    private static int selectNumber = 6;
    private static List<Integer> lottoList;

    public static List<Integer> getLottoList() {
        return lottoList;
    }

    public static void setLottoList(List<Integer> lottoList) {
        Lotto.lottoList = lottoList;
    }


    public static int getSelectNumber() {
        return selectNumber;
    }

    public static void setSelectNumber(int selectNumber) {
        Lotto.selectNumber = selectNumber;
    }


    public Lotto(int price) {
        this.price = price;
    }

    public Lotto() {
    }

    public List<Integer> getLottoNumberList() {
        List<Integer> lottoList = new ArrayList<Integer>();
        for (int i = LOTTO_START_NUM; i <= LOTTO_END_NUM; i++) {
            lottoList.add(i);
        }
        return lottoList;
    }
}
