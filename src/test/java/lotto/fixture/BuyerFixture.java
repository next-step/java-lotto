package lotto.fixture;

import lotto.model.dto.LottoNumber;

import java.util.List;

public class BuyerFixture {
    public static final int LOTTOES_BUY_COUNT_FIXTURE = 14;
    //8, 21, 23, 41, 42, 43
    public static final List<List<LottoNumber>> LOTTOES_FIXTURE = List.of(
            List.of(new LottoNumber(8), new LottoNumber(21), new LottoNumber(23), new LottoNumber(41), new LottoNumber(42), new LottoNumber(43)),//111111-1
            List.of(new LottoNumber(3), new LottoNumber(5), new LottoNumber(11), new LottoNumber(16), new LottoNumber(32), new LottoNumber(38)),//
            List.of(new LottoNumber(7), new LottoNumber(11), new LottoNumber(16), new LottoNumber(35), new LottoNumber(36), new LottoNumber(44)),//
            List.of(new LottoNumber(1), new LottoNumber(8), new LottoNumber(11), new LottoNumber(31), new LottoNumber(41), new LottoNumber(42)),//111-4
            List.of(new LottoNumber(13), new LottoNumber(14), new LottoNumber(16), new LottoNumber(38), new LottoNumber(42), new LottoNumber(45)),//1
            List.of(new LottoNumber(7), new LottoNumber(11), new LottoNumber(30), new LottoNumber(40), new LottoNumber(42), new LottoNumber(43)),//11
            List.of(new LottoNumber(2), new LottoNumber(13), new LottoNumber(22), new LottoNumber(32), new LottoNumber(38), new LottoNumber(45)),//
            List.of(new LottoNumber(23), new LottoNumber(25), new LottoNumber(33), new LottoNumber(36), new LottoNumber(39), new LottoNumber(41)),//11
            List.of(new LottoNumber(1), new LottoNumber(3), new LottoNumber(5), new LottoNumber(14), new LottoNumber(22), new LottoNumber(45)),//
            List.of(new LottoNumber(5), new LottoNumber(9), new LottoNumber(38), new LottoNumber(41), new LottoNumber(43), new LottoNumber(44)),//11
            List.of(new LottoNumber(2), new LottoNumber(8), new LottoNumber(9), new LottoNumber(18), new LottoNumber(19), new LottoNumber(21)),//11
            List.of(new LottoNumber(13), new LottoNumber(14), new LottoNumber(18), new LottoNumber(21), new LottoNumber(23), new LottoNumber(35)),//11
            List.of(new LottoNumber(17), new LottoNumber(21), new LottoNumber(29), new LottoNumber(37), new LottoNumber(42), new LottoNumber(45)),//11
            List.of(new LottoNumber(3), new LottoNumber(8), new LottoNumber(27), new LottoNumber(30), new LottoNumber(35), new LottoNumber(44))//1
    );
}
