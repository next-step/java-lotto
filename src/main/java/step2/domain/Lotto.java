package step2.domain;

import java.util.*;

public class Lotto {
    private static final int LOTTO_START_NUM = 1;
    private static final int LOTTO_END_NUM = 45;
    private static final int SELECT_NUMBER = 6;
    private int price = 1000;
    private Set<Integer> lottoList = new HashSet<>();

    public Lotto() {
        getLottoNumberList();
    }

    public int getPrice() {
        return price;
    }

    public Set getLottoList() {
        return lottoList;
    }

    public void getLottoNumberList() {
        for (int i = LOTTO_START_NUM; i <= LOTTO_END_NUM; i++) {
            lottoList.add(i);
        }
        this.lottoList = lottoList;
    }

    public List<Integer> extractLottoNumber() {
        List lottoList = new ArrayList(this.lottoList);
        List<Integer> lottoNumberList = lottoList;
        Collections.shuffle(lottoNumberList);
        List<Integer> randomNumberList = new ArrayList<>(lottoNumberList.subList(0, SELECT_NUMBER));
        Collections.sort(randomNumberList);
        return randomNumberList;
    }
}
