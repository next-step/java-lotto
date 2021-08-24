package com.techmoa.lotto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoTicket {

    public static final int MAX_NUMBER = 45;

    private static List<Integer> lottoNumber = null;
    private Random lottoRandom = new Random();

    public void makeLottoNumber() {
        List<Integer> numberCards = new ArrayList<>();
        for(int i= 1; i<= MAX_NUMBER; i++)
            numberCards.add(i);
        Collections.shuffle(numberCards);
        lottoNumber = numberCards.subList(0,5);
        Collections.sort(lottoNumber);
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }

}
