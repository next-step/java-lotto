package step2;

import java.util.ArrayList;
import java.util.List;

public class LotteryNumbers {
    private List<Integer> lottoNumberList;

    public LotteryNumbers() {
        lottoNumberList = new ArrayList<>();
    }

    public void addLottoNumber(int number) {
        lottoNumberList.add(number);
    }

    public List<Integer> getLottoNumberList() {
        return lottoNumberList;
    }
}
