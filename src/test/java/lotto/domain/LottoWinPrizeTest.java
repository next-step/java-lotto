package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoWinPrizeTest {

    @ParameterizedTest
    @CsvSource(value = {"3,true,MATCH_3", "3,false,MATCH_3", "4,true,MATCH_4", "4,false,MATCH_4"
            , "5,true,MATCH_5_BONUS", "5,false,MATCH_5", "6,true,MATCH_6", "6,false,MATCH_6"})
    @DisplayName("주어진 당첨번호와 일치하는 숫자에 맞는 당첨케이스를 리턴하는지 테스트")
    void getLottoWinPrize(String inputCount, String inputBonus, String expected) {
        // given
        LottoWinResult lottoWinResult = new LottoWinResult();
        
        // when
        Optional<LottoWinPrize> lottoWinPrizeOptional
                = LottoWinPrize.getLottoWinPrize(Integer.parseInt(inputCount)
                        , Boolean.parseBoolean(inputBonus));
        
        // then
        lottoWinPrizeOptional.ifPresent(lottoWinPrize -> {
            assertThat(lottoWinPrize.name()).isEqualTo(expected);
        });;

    }
}