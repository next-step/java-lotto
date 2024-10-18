package lotto.model;

import lotto.model.dto.LottoNumber;
import lotto.model.enums.Ranking;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static lotto.model.Lotto.LOTTO_NUMBERS_NOT_ALLOWED_DUPLICATED;
import static lotto.model.Lotto.LOTTO_NUMBERS_SIZE_ALLOWED_ONLY_6;
import static lotto.model.dto.LottoNumber.of;
import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    public static final String DELIMITER = ",";

    @Test
    void 로또번호목록과_보너스번호를_저장한다() {
        assertThatNoException().isThrownBy(() -> {
            Lotto lotto = new Lotto(
                    () -> Arrays.asList(of(6), of(9), of(17), of(28), of(39), of(45))
            );
        });
    }

    @Test
    void 로또는_로또번호순서와_상관없이_정렬된_값과_같다() {
        List<LottoNumber> actual = new Lotto(
                        () -> Arrays.asList(of(39), of(17), of(6), of(9), of(28), of(45))
                )
                .numbers();
        List<LottoNumber> expected = Arrays.asList(of(6), of(9), of(17), of(28), of(39), of(45));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 로또번호는_중복되면_오류() {
        assertThatThrownBy(() -> {
            Lotto duplicatedLotto = new Lotto(
                    () -> Arrays.asList(of(6), of(6), of(17), of(28), of(39), of(45))
            );
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBERS_NOT_ALLOWED_DUPLICATED);
    }

    @Test
    void 로또번호목록은_반드시_6개가_저장되어야_한다() {
        assertThatThrownBy(() -> {
            Lotto lottoNumbersSizeIsNotSix = new Lotto(
                    () -> Arrays.asList(of(6), of(17), of(28), of(39))
            );
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBERS_SIZE_ALLOWED_ONLY_6);
    }

    @ParameterizedTest(name = "로또_등수_없음({0})")
    @ValueSource(strings = {
            "7,8,9,10,11,12,13",//NOTE: 0개
            "1,8,9,10,11,12,13",// NOTE: 1개
            "1,2,9,10,11,12,13"//NOTE: 2개
    })
    void 로또_등수_없음(String numberStrings) {
        int[] numbers = convertStringToNumbers(numberStrings);
        Lotto buy = new Lotto(
                () -> Arrays.asList(of(numbers[0]), of(numbers[1]), of(numbers[2]), of(numbers[3]), of(numbers[4]), of(numbers[5]))
        );

        Lotto winningLotto = new Lotto(
                () -> Arrays.asList(of(1), of(2), of(3), of(4), of(5), of(6))
        );
        LottoNumber bonusNumber = of(numbers[6]);
        Winning winning = Winning.of(winningLotto, bonusNumber);

        Ranking actual = buy.compare(winning);
        Ranking expected = Ranking.NONE;

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "로또5등({0})")
    @ValueSource(strings = {
            "1,2,3,7,8,9,13",
            "1,2,3,7,8,13,13"
    })
    void 로또5등(String numberStrings) {
        int[] numbers = convertStringToNumbers(numberStrings);
        Lotto buy = new Lotto(
                () -> Arrays.asList(of(numbers[0]), of(numbers[1]), of(numbers[2]), of(numbers[3]), of(numbers[4]), of(numbers[5]))
        );
        Lotto winningLotto = new Lotto(
                () -> Arrays.asList(of(1), of(2), of(3), of(4), of(5), of(6))
        );
        LottoNumber bonusNumber = of(numbers[6]);
        Winning winning = Winning.of(winningLotto, bonusNumber);

        Ranking actual = buy.compare(winning);
        Ranking expected = Ranking.FIFTH;

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "로또4등({0})")
    @ValueSource(strings = {
            "1,2,3,4,8,9,13",
            "1,2,3,4,8,13,13"
    })
    void 로또4등(String numberStrings) {
        int[] numbers = convertStringToNumbers(numberStrings);
        Lotto buy = new Lotto(
                () -> Arrays.asList(of(numbers[0]), of(numbers[1]), of(numbers[2]), of(numbers[3]), of(numbers[4]), of(numbers[5]))
        );
        Lotto winningLotto = new Lotto(
                () -> Arrays.asList(of(1), of(2), of(3), of(4), of(5), of(6))
        );
        LottoNumber bonusNumber = of(numbers[6]);
        Winning winning = Winning.of(winningLotto, bonusNumber);

        Ranking actual = buy.compare(winning);
        Ranking expected = Ranking.FOURTH;

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "로또3등({0})")
    @ValueSource(strings = {
            "1,2,3,4,5,9,13",
            "1,2,3,4,5,12,13"
    })
    void 로또3등(String numberStrings) {
        int[] numbers = convertStringToNumbers(numberStrings);
        Lotto buy = new Lotto(
                () -> Arrays.asList(of(numbers[0]), of(numbers[1]), of(numbers[2]), of(numbers[3]), of(numbers[4]), of(numbers[5]))
        );
        Lotto winningLotto = new Lotto(
                () -> Arrays.asList(of(1), of(2), of(3), of(4), of(5), of(6))
        );
        LottoNumber bonusNumber = of(numbers[6]);
        Winning winning = Winning.of(winningLotto, bonusNumber);

        Ranking actual = buy.compare(winning);
        Ranking expected = Ranking.THIRD;

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "로또2등({0})")
    @ValueSource(strings = {
            "1,2,3,4,5,13,13",
            "1,2,3,4,5,12,12"
    })
    void 로또2등(String numberStrings) {
        int[] numbers = convertStringToNumbers(numberStrings);
        Lotto buy = new Lotto(
                () -> Arrays.asList(of(numbers[0]), of(numbers[1]), of(numbers[2]), of(numbers[3]), of(numbers[4]), of(numbers[5]))
        );
        Lotto winningLotto = new Lotto(
                () -> Arrays.asList(of(1), of(2), of(3), of(4), of(5), of(6))
        );
        LottoNumber bonusNumber = of(numbers[6]);
        Winning winning = Winning.of(winningLotto, bonusNumber);

        Ranking actual = buy.compare(winning);
        Ranking expected = Ranking.SECOND;

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "로또1등({0})")
    @ValueSource(strings = {
            "1,2,3,4,5,6,13"
    })
    void 로또1등(String numberStrings) {
        int[] numbers = convertStringToNumbers(numberStrings);
        Lotto buy = new Lotto(
                () -> Arrays.asList(of(numbers[0]), of(numbers[1]), of(numbers[2]), of(numbers[3]), of(numbers[4]), of(numbers[5]))
        );
        Lotto winningLotto = new Lotto(
                () -> Arrays.asList(of(1), of(2), of(3), of(4), of(5), of(6))
        );
        LottoNumber bonusNumber = of(numbers[6]);
        Winning winning = Winning.of(winningLotto, bonusNumber);

        Ranking actual = buy.compare(winning);
        Ranking expected = Ranking.FIRST;

        assertThat(actual).isEqualTo(expected);
    }


    private static int[] convertStringToNumbers(String numberStrings) {
        return Arrays.stream(numberStrings.split(DELIMITER)).mapToInt(Integer::parseInt).toArray();
    }

}