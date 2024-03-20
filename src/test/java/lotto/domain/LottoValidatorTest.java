package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class LottoValidatorTest {

    @Test
    @DisplayName("isInvalidLottoNumberBound 호출 시 모든 숫자가 로또 숫자 범위를 벗어나면 true")
    void isInvalidLottoNumberBound() {
        assertAll(
                assertThat(LottoValidator.isInvalidLottoNumberBound(List.of(1, 2, 3, 4, 5, 45)))::isFalse,
                assertThat(LottoValidator.isInvalidLottoNumberBound(List.of(0, 2, 3, 4, 5, 45)))::isTrue,
                assertThat(LottoValidator.isInvalidLottoNumberBound(List.of(1, 2, 3, 4, 5, 46)))::isTrue
        );
    }

    @Test
    @DisplayName("inInvalidLottoNumberSize 호출 시 리스트의 개수가 LOTTO_NUMBER_SIZE와 다르면 true")
    void inInvalidLottoNumberSize() {
        assertAll(
                assertThat(LottoValidator.isInvalidLottoNumberSize(List.of(1, 2, 3, 4, 5, 45)))::isFalse,
                assertThat(LottoValidator.isInvalidLottoNumberSize(List.of(0, 2, 3, 4, 5, 6, 45)))::isTrue,
                assertThat(LottoValidator.isInvalidLottoNumberSize(List.of(1, 2, 3, 4, 5)))::isTrue
        );
    }

    @Test
    @DisplayName("isLottoNumberDuplicate 호출 시 파라미터 리스트의 숫자가 하나라도 겹치면 true")
    void isLottoNumberDuplicate() {
        assertAll(
                assertThat(LottoValidator.isLottoNumberDuplicate(List.of(1, 1, 3, 4, 5, 45)))::isTrue,
                assertThat(LottoValidator.isLottoNumberDuplicate(List.of(1, 2, 3, 4, 5, 6)))::isFalse
        );
    }
}
