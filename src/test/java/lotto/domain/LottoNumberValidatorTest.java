package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class LottoNumberValidatorTest {

    @Test
    @DisplayName("isInvalidLottoNumberBound 호출 시 모든 숫자가 로또 숫자 범위를 벗어나면 True")
    void isInvalidLottoNumberBound() {
        assertAll(
                assertThat(LottoNumberValidator.isInvalidLottoNumberBound(List.of(1, 2, 3, 4, 5, 45)))::isFalse,
                assertThat(LottoNumberValidator.isInvalidLottoNumberBound(List.of(0, 2, 3, 4, 5, 45)))::isTrue,
                assertThat(LottoNumberValidator.isInvalidLottoNumberBound(List.of(1, 2, 3, 4, 5, 46)))::isTrue
        );
    }

    @Test
    @DisplayName("inInvalidLottoNumberSize 호출 시 리스트의 개수가 LOTTO_NUMBER_SIZE와 다르면 True")
    void inInvalidLottoNumberSize() {
        assertAll(
                assertThat(LottoNumberValidator.inInvalidLottoNumberSize(List.of(1, 2, 3, 4, 5, 45)))::isFalse,
                assertThat(LottoNumberValidator.inInvalidLottoNumberSize(List.of(0, 2, 3, 4, 5, 6, 45)))::isTrue,
                assertThat(LottoNumberValidator.inInvalidLottoNumberSize(List.of(1, 2, 3, 4, 5)))::isTrue
        );
    }
}
