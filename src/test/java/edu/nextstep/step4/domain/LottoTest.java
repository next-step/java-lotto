package edu.nextstep.step4.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-lotto
 * create date  : 2019-06-24 23:24
 */
public class LottoTest {

    private List<Number> numbers;

    @BeforeEach
    void setUp() {
        numbers = new ArrayList<>(
                Arrays.asList(Number.of(1), Number.of(2), Number.of(3), Number.of(4), Number.of(5)));

    }

    @DisplayName("리스트 size가 6으로 전달받아 생성하기 - 예외상황")
    @Test
    void validSize() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Lotto exNumber = new Lotto(numbers);
        }).withMessageContaining("전달된 숫자가 6개가 아닙니다.");
    }

    @DisplayName("리스트에 중복된 숫자 제거하기")
    @Test
    void validDuplicate() {
        numbers.add(Number.of(5));
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Lotto exNumber = new Lotto(numbers);
        }).withMessageContaining("전달된 숫자가 6개가 아닙니다.");
    }

    @DisplayName("전달된 인자값(int type)을 보유하고 있는지 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void contains(int number) {
        numbers.add(Number.of(6));
        Lotto lottoNumber = new Lotto(numbers);
        assertThat(lottoNumber.contains(number)).isTrue();
    }

    @DisplayName("ExtractionNumber 객체데이터의 당첨된 카운트 반환는다.")
    @Test
    void contains() {
        numbers.add(Number.of(6));
        Lotto lottoNumber = new Lotto(numbers);

        List<Number> compareNumber = new ArrayList<>();

        compareNumber.add(Number.of(2));
        compareNumber.add(Number.of(4));
        compareNumber.add(Number.of(6));
        compareNumber.add(Number.of(8));
        compareNumber.add(Number.of(10));
        compareNumber.add(Number.of(12));
        Lotto exNumber = new Lotto(compareNumber);

        assertThat(lottoNumber.compareMatchNumberCount(exNumber)).isEqualTo(3);
    }

    @DisplayName("당첨번호 생성하는 기능")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void createLotteryNumber(int number) {
        Lotto lottoNumber = Lotto.createLotteryNumber("1,2,3,4,5,6");
        assertThat(lottoNumber.stream()
                .map(Number::getNumber)
                .collect(Collectors.toList()).contains(number)
        );
    }
}
