package step2.vo;

import java.util.List;

public class CountOfWinnersFixture {

    public static CountOfWinners _3개_일치_4장() {
        return new CountOfWinners(List.of(3, 3, 3, 3));
    }

    public static CountOfWinners _4개_일치_4장() {
        return new CountOfWinners(List.of(4, 4, 4, 4));
    }

    public static CountOfWinners _3개_일치_1장_4개_일치_1장() {
        return new CountOfWinners(List.of(3, 4));
    }
}
