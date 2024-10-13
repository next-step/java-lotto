package lotto.fixture;

import lotto.model.dto.LottoNumber;

import java.util.List;

import static lotto.model.dto.LottoNumber.of;

public class BuyerFixture {
    public static final int LOTTOES_BUY_COUNT_FIXTURE = 14;
    //8, 21, 23, 41, 42, 43
    public static final List<LottoNumber> WINNING_LOTTOES_NUMBERS = List.of(
            of(8), of(21),
            of(23), of(41),
            of(42), of(43));
    public static final List<List<LottoNumber>> LOTTOES_NUMBERS = List.of(
            List.of(of(8), of(21), of(23), of(41), of(42), of(43)),//111111-1
            List.of(of(3), of(5), of(11), of(16), of(32), of(38)),//
            List.of(of(7), of(11), of(16), of(35), of(36), of(44)),//
            List.of(of(1), of(8), of(11), of(31), of(41), of(42)),//111-4
            List.of(of(13), of(14), of(16), of(38), of(42), of(45)),//1
            List.of(of(7), of(11), of(30), of(40), of(42), of(43)),//11
            List.of(of(2), of(13), of(22), of(32), of(38), of(45)),//
            List.of(of(23), of(25), of(33), of(36), of(39), of(41)),//11
            List.of(of(1), of(3), of(5), of(14), of(22), of(45)),//
            List.of(of(5), of(9), of(38), of(41), of(43), of(44)),//11
            List.of(of(2), of(8), of(9), of(18), of(19), of(21)),//11
            List.of(of(13), of(14), of(18), of(21), of(23), of(35)),//11
            List.of(of(17), of(21), of(29), of(37), of(42), of(45)),//11
            List.of(of(3), of(8), of(27), of(30), of(35), of(44))//1

    );
}
