package com.techmoa.lotto.service;

import java.util.Random;

public class LottoTicket {

    public static final int MAX_NUMBER = 45;
    public static final int DIGIT = 6;

    private static int[] lottoNumber = new int[DIGIT];
    private Random lottoRandom = new Random();

    public void makeLottoNumber() {
        for(int i= 0; i< DIGIT; i++) {
            lottoNumber[i] = makeRandomNumber();
        }
    }

    private int makeRandomNumber() {
        return lottoRandom.nextInt(MAX_NUMBER);
    }

    public int[] getLottoNumber() {
        return lottoNumber;
    }

}
