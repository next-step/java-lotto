package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LottoMachine {

    private static final ArrayList<Lotto> lottoSet = new ArrayList<>();
    private int userLottoCount = 0;

    private static final int LOTTO_COST = 1000;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_COUNT = 6;

    static { // 1~45 만들기

        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            lottoSet.add(new Lotto(i));
        }
    }

    private int calculateCount(int cost) {
        return cost / LOTTO_COST;
    }
    public ArrayList<LottoNumbers> createUserLottoNumbers(int cost) {
        this.userLottoCount = this.calculateCount(cost);

        ArrayList<LottoNumbers> userLottoNumbers = new ArrayList<>();

        for (int i = 0; i < this.userLottoCount; i++) {
            userLottoNumbers.add(createSingleLottoNumber());
        }
        return userLottoNumbers;
    }

    private static LottoNumbers createSingleLottoNumber() {
        // 새 lottoNumbers 만들기
        ArrayList<Lotto> newLottoNumbers = new ArrayList<>();

        Collections.shuffle(lottoSet);
        for (int i = 0 ; i < LOTTO_COUNT; i++) {
//            System.out.println("lottoSet = " + lottoSet.get(i).getNumber());
            newLottoNumbers.add(lottoSet.get(i));
        }

        newLottoNumbers.sort(Comparator.naturalOrder());

        return new LottoNumbers(newLottoNumbers);
    }

    public int count() {
        return this.userLottoCount;
    }
}
