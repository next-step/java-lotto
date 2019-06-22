package com.jaeyeonling.lotto.config;

public interface Env {

    /* Lotto Number */
    int MIN_LOTTO_NUMBER = 1;
    int MAX_LOTTO_NUMBER = 45;


    /* Lotto */
    int PRICE_OF_LOTTO = 1_000;
    int COUNT_OF_LOTTO_NUMBER_IN_LOTTO = 6;


    /* Lotto Prize */
    int JACKPOT_COUNT_OF_MATCH = 6;
    int JACKPOT_PRIZE_MONEY = 20_0000_0000;

    int SECOND_COUNT_OF_MATCH = 5;
    int SECOND_PRIZE_MONEY = 150_0000;

    int THIRD_COUNT_OF_MATCH = 4;
    int THIRD_PRIZE_MONEY = 50_000;

    int FOURTH_COUNT_OF_MATCH = 3;
    int FOURTH_PRIZE_MONEY = 5_000;

    int LOSE_COUNT_OF_MATCH = 0;
    int LOSE_PRIZE_MONEY = 0;

    /* Money */
    int MINIMUM_MONEY = 0;


    /* Report */
    int DEFAULT_MATCH_COUNT = 0;

}
