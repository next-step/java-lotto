package edu.nextstep.lottoauto.domain;

public enum Prize {
    FIRST(6, 200_000_000),
    SECOND(5, 15_000_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000);


    Prize(int countOfMatch, int winningPrize) {

    }
}
