package com.hskim.lotto.model;

import com.hskim.lotto.exception.LottoExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class BonusNumberTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        // given
        List<LottoNumber> winningLottoNumber = LottoNumber.convertToLottoNumberList(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7, winningLottoNumber);

        // when & then
        assertThat(bonusNumber).isEqualTo(new BonusNumber(7, winningLottoNumber));
    }

    @DisplayName("생성 실패 - 기존 로또번호와 중복된 보너스 번호 테스트")
    @Test
    void create_중복_실패() {
        // given
        List<LottoNumber> winningLottoNumber = LottoNumber.convertToLottoNumberList(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new BonusNumber(6, winningLottoNumber);
        }).withMessage(LottoExceptionMessage.DUPLICATED_BONUS_NUMBER.getMessage());
    }
}
