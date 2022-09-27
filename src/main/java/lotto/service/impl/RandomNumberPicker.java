package lotto.service.impl;

import lotto.service.LottoNumberPicker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class RandomNumberPicker implements LottoNumberPicker {

    private final Random random = new Random();


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