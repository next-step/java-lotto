package step2.vo;

import step2.service.LottoRank;

import java.util.List;

public class CountOfWinnersFixture {

    public static CountOfWinners _3개_일치_4장() {
        return new CountOfWinners(List.of(LottoRank.FIFTH, LottoRank.FIFTH, LottoRank.FIFTH, LottoRank.FIFTH));
    }

    public static CountOfWinners _4개_일치_4장() {
        return new CountOfWinners(List.of(LottoRank.FOURTH, LottoRank.FOURTH, LottoRank.FOURTH, LottoRank.FOURTH));
    }

    public static CountOfWinners _3개_일치_1장_4개_일치_1장() {
        return new CountOfWinners(List.of(LottoRank.FIFTH, LottoRank.FOURTH));
    }
}
