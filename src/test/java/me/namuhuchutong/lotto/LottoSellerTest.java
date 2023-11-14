package me.namuhuchutong.lotto;

import static me.namuhuchutong.lotto.domain.LottoWinnings.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import me.namuhuchutong.lotto.domain.LottoSeller;
import me.namuhuchutong.lotto.domain.Number;
import me.namuhuchutong.lotto.domain.generator.NumberGenerator;
import me.namuhuchutong.lotto.dto.LottoResult;
import me.namuhuchutong.lotto.dto.UserInputInformation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoSellerTest {
    
    @DisplayName("로또를 구입할 수 없는 금액일 경우 예외가 발생한다.")
    @Test
    void throw_exception_when_can_not_buy_lotto() {
        //given
        int givenAmount = 999;
        String[] manual = {"a, 1, 2, 3, 4"};
        String givenNumbers = "1, 2, 3, 4, 5, 6";
        int bonusNumber = 7;
        LottoSeller lottoSeller = new LottoSeller(() -> null);
        UserInputInformation information = new UserInputInformation(givenAmount, manual, givenNumbers, bonusNumber);

        //when, then
        assertThatThrownBy(() -> lottoSeller.sellLotto(information))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("보너스 로또에 당첨된 경우 보너스 금액을 수령받는다.")
    @Test
    void if_5_numbers_and_bonus_number_matched_get_winnings() {
        //given
        int amount = 1000;
        String[] manual = {"a, 1, 2, 3, 4"};
        String givenNumber = "1, 2, 3, 4, 5, 6";
        int bonusNumber = 7;
        UserInputInformation information = new UserInputInformation(amount, manual, givenNumber, bonusNumber);
        LottoSeller lottoSeller = new LottoSeller(new TestGenerator());

        //when
        LottoResult lottoResult = lottoSeller.sellLotto(information);

        //then
        assertThat(lottoResult.getWinnings(3)).isEqualTo(BONUS.getWinnings());
    }

    @DisplayName("5개 일치와 5+보너스 일치는 구별되어야 한다.")
    @Test
    void five_matches_is_not_same_as_five_and_bonus_matches() {
        //given
        int amount = 2000;
        String[] manual = {"a, 1, 2, 3, 4"};
        String givenNumber = "1, 2, 3, 4, 5, 6";
        int bonusNumber = 7;
        UserInputInformation information = new UserInputInformation(amount, manual, givenNumber, bonusNumber);
        LottoSeller lottoSeller = new LottoSeller(new TestGenerator());
        long expected = FIVE.getWinnings() + BONUS.getWinnings();

        //when
        LottoResult lottoResult = lottoSeller.sellLotto(information);

        //then
        assertThat(lottoResult.getWinnings(THREE.getCount())).isEqualTo(expected);
    }
    
    static class TestGenerator implements NumberGenerator {

        private int count = 0;

        @Override
        public List<Number> createNumbers() {
            return List.of(
                    new Number(1 + count),
                    new Number(2 + count),
                    new Number(3 + count),
                    new Number(4 + count),
                    new Number(5 + count),
                    new Number(7 + count++)
            );
        }
    }
}
