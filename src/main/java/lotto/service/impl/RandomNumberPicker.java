package lotto.service.impl;

import lotto.service.LottoNumberPicker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by P-161 at : 2022-09-27
 *
 * 여기에 RandomNumberPicker 클래스에 대한 설명을 기술해주세요
 *
 * @author P-161
 * @version 1.0
 * @since 1.0
 */
public class RandomNumberPicker implements LottoNumberPicker {

    private final Random random = new Random();
    private final int MAX_BOUND_NUM = 100;

    private Integer pickOne() {
        return random.nextInt(MAX_BOUND_NUM);
    }

    @Override
    public List<Integer> pick() {
        List<Integer> lottoNum = new ArrayList<>();
        for (int i = 0 ; i < LOTTO_LENGTH ; i++){
            lottoNum.add(pickOne());
        }
        return lottoNum;
    }
}