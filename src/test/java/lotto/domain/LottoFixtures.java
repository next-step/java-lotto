package lotto.domain;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoCreator;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.winning.WinningNumbers;

public class LottoFixtures {

    public static final List<LottoNumber> OVERSIZE_LOTTO_NUMBER = Arrays.asList(
        new LottoNumber(1),
        new LottoNumber(2),
        new LottoNumber(3),
        new LottoNumber(4),
        new LottoNumber(5),
        new LottoNumber(6),
        new LottoNumber(7)
    );

    public static final List<LottoNumber> DUPLICATED_LOTTO_NUMBER = Arrays.asList(
        new LottoNumber(1),
        new LottoNumber(2),
        new LottoNumber(3),
        new LottoNumber(4),
        new LottoNumber(4),
        new LottoNumber(4)
    );

    public static final List<LottoNumber> NORMAL_LOTTO_NUMBER = Arrays.asList(
        new LottoNumber(1),
        new LottoNumber(2),
        new LottoNumber(3),
        new LottoNumber(4),
        new LottoNumber(5),
        new LottoNumber(6)
    );

    public static final WinningNumbers WINNING_NUMBERS_NO_REWARD = new WinningNumbers(
        Arrays.asList("5", "10", "15", "20", "25", "30"),
        "35"
    );

    public static final WinningNumbers WINNING_NUMBERS_THREE_MATCHING = new WinningNumbers(
        Arrays.asList("1", "2", "3", "20", "25", "30"),
        "35"
    );

    public static final WinningNumbers WINNING_NUMBERS_FOUR_MATCHING = new WinningNumbers(
        Arrays.asList("1", "2", "3", "4", "25", "30"),
        "35"
    );

    public static final WinningNumbers WINNING_NUMBERS_FOUR_MATCHING_NOT_BONUS = new WinningNumbers(
       Arrays.asList("1", "2", "3", "4", "25", "35"),
        "35"
    );

    public static final WinningNumbers WINNING_NUMBERS_FIVE_MATCHING = new WinningNumbers(
        Arrays.asList("1", "2", "3", "4", "5", "30"),
        "35"
    );

    public static final WinningNumbers WINNING_NUMBERS_FIVE_MATCHING_BONUS = new WinningNumbers(
        Arrays.asList("1", "2", "3", "4", "5", "30"),
        "6"
    );

    public static final WinningNumbers WINNING_NUMBERS_SIX_MATCHING = new WinningNumbers(
        Arrays.asList("1", "2", "3", "4", "5", "6"),
        "35"
    );

    public static final LottoCreator FIXED_LOTTO_CREATOR = new LottoCreator() {
        @Override
        public Lotto createLotto() {
            return new Lotto(NORMAL_LOTTO_NUMBER);
        }
    };
}
