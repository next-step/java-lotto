/*
 * 로또 자동 생성 전략을 나타내는 클래스
 * */
package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class AutoLottoStrategy implements LottoStrategy {

    public List<Integer> lottoNumbers = new ArrayList<>();

    public AutoLottoStrategy() {
        for (int i = LOTTO_START_NUM; i < LOTTO_BOUND; i++) {
            lottoNumbers.add(i);
        }
    }

    @Override
    public List<Integer> makeLotto() {
        Collections.shuffle(lottoNumbers, new Random());
        return new ArrayList<>(lottoNumbers.subList(0, LOTTO_SIZE));
    }
}
