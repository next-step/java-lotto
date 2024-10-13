package lotto.fixture;

import lotto.model.dto.LottoNumber;

import java.util.List;

import static lotto.model.dto.LottoNumber.of;

public class LottoFixture {
    public static final List<LottoNumber> LOTTO_NUMBERS = List.of(
            of(6), of(9),
            of(17), of(28),
            of(39), of(45));
    public static final List<LottoNumber> UNORDERED_LOTTO_NUMBERS = List.of(
            of(39), of(17),
            of(6), of(9),
            of(28), of(45));
    public static final List<LottoNumber> DUPLICATED_LOTTO_NUMBERS = List.of(
            of(6), of(6),
            of(9), of(17),
            of(28), of(39));
    public static final List<LottoNumber> NOT_SIZE_6_LOTTO_NUMBERS = List.of(
            of(6), of(17),
            of(28), of(39));
    public static final List<LottoNumber> WINNING_LOTTO_NUMBERS = List.of(
            of(1), of(2),
            of(3), of(4),
            of(5), of(6));
    public static final List<LottoNumber> NONE_RANKED_LOTTO_NUMBERS = List.of(
            of(7), of(8),
            of(9), of(10),
            of(11), of(12));
    public static final List<LottoNumber> FOURTH_LOTTO_NUMBERS = List.of(
            of(1), of(2),
            of(3), of(7),
            of(8), of(9));
    public static final List<LottoNumber> THIRD_LOTTO_NUMBERS = List.of(
            of(1), of(2),
            of(3), of(4),
            of(8), of(9));
    public static final List<LottoNumber> SECOND_LOTTO_NUMBERS = List.of(
            of(1), of(2),
            of(3), of(4),
            of(5), of(9));
    public static final List<LottoNumber> FIRST_LOTTO_NUMBERS = List.of(
            of(1), of(2),
            of(3), of(4),
            of(5), of(6));
}
