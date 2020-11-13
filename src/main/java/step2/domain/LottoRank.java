package step2.domain;

import java.util.stream.Stream;

public enum LottoRank {

    FIRST(6 , 2_000_000_000 ),
    SECOND(4 , 1_500_000 ),
    THIRD(3 , 50_000 ),
    FORTH(2 , 5_000 ),
    MISS(0 , 0);

    private int match;
    private int price;

    LottoRank() { }

    public int matchLottoRank(int match){
        return Stream.of(MISS, FORTH , THIRD , SECOND, FIRST)
                .filter(ranking -> ranking.match == match)
                .findFirst()
                .orElseThrow(new );
    }
}
