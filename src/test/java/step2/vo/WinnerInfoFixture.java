package step2.vo;

import java.util.List;

public class WinnerInfoFixture {

    public static WinnerInfo _3개_일치_4장() {
        return new WinnerInfo(List.of(3, 3, 3, 3));
    }

    public static WinnerInfo _4개_일치_4장() {
        return new WinnerInfo(List.of(4, 4, 4, 4));
    }

    public static WinnerInfo _3개_일치_1장_4개_일치_1장() {
        return new WinnerInfo(List.of(3, 4));
    }
}
