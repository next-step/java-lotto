package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoValidate {
    private static final int REFERENCE_PRICE = 1000;
    private static final int REMAINDER_VALUE = 10;

    private int count = 0;
    private int first = 0;
    private int second = 0;
    private int third = 0;
    private int forth = 0;

    public int priceValidation(int price) {
        if (price % REMAINDER_VALUE != 0) {
            throw new IllegalArgumentException("천원 단위로 입력해야 합니다.");
        }

        if (price < REFERENCE_PRICE) {
            throw new IllegalArgumentException("돈이 천원보다 작습니다.");
        }
        return lottoCount(price);
    }

    private int lottoCount(int price) {
        return (int) Math.floor(price / REFERENCE_PRICE);
    }

    public void correctCheck(Lotto lotto, List<Integer> correctNumbers) {
        count = 0;
        List<Integer> list = lotto.getLotto();
        for(int i = 0 ; i < correctNumbers.size(); i++) {
            getCorrectCount(list, correctNumbers, i);
        }
        addRank(count);
    }

    private void getCorrectCount(List<Integer> list, List<Integer> correctNumbers, int index) {
        if (list.contains(correctNumbers.get(index))) {
            count++;
        }
    }

    private void addRank(int checkCount) {
        switch (checkCount) {
            case 6:
                first++;
                break;
            case 5:
                second++;
                break;
            case 4:
                third++;
                break;
            case 3:
                forth++;
                break;
            default:
                break;
        }
    }

    public Map<String, Object> lotteryRewards() {
        Map<String, Object> map = new HashMap<>();
        map.put("first", first);
        map.put("second", second);
        map.put("third", third);
        map.put("forth", forth);
        return map;
    }
}
