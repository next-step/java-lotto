package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_START_NO = 1;
    private static final int LOTTO_END_NO = 45;
    private static final int SPLIT_START_NO = 0;
    private static final int SPLIT_END_NO = 6;
    private static final int DIVISION_NO = 1000;

    private List<Integer> lottoNumbers;
    private List<Object[]> lottos;

    public LottoMachine() {
        this.lottoNumbers = new ArrayList<>();
        for (int number = LOTTO_START_NO; number <= LOTTO_END_NO; number++) {
            lottoNumbers.add(number);
        }
    }

    public Object[] getLotto() {
        shuffleNumber();
        return toArray(sort(splitSixNumber()));
    }

    private Object[] toArray(List<Integer> lotto) {
        return lotto.toArray();
    }

    private List<Integer> sort(List<Integer> lotto) {
        Collections.sort(lotto);
        return lotto;
    }

    private List<Integer> splitSixNumber() {
        return this.lottoNumbers.subList(SPLIT_START_NO, SPLIT_END_NO);
    }

    private void shuffleNumber() {
        Collections.shuffle(this.lottoNumbers);
    }

    public List<Object[]>  buy(int fee) {
        final int buyCount = validAndFindCount(fee);
        this.lottos = new ArrayList<>();
        for (int i = 0; i < buyCount; i++) {
            Object[] lotto = getLotto();
            this.lottos.add(lotto);
        }
        return this.lottos;
    }

    private int validAndFindCount(int fee) {
        valid(fee);
        return findBuyCount(fee);
    }

    private int findBuyCount(int fee) {
        return fee/DIVISION_NO;
    }

    private void valid(int fee) {
        if (fee/DIVISION_NO < 0) {
            throw new IllegalArgumentException("잘못된 금액을 입력하였습니다.");
        }
    }

}
