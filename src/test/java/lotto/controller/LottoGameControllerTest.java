package lotto.controller;

import lotto.domain.LottoErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoGameControllerTest {

    private LottoGameController lottoGameController;

    @BeforeEach
    void setUp(){
        this.lottoGameController = new LottoGameController();
    }

    @DisplayName("지난 당첨 번호 유효성 검증")
    @ParameterizedTest
    @ValueSource(strings = {"3%4%6%7%8%9", "q,w,e,r,t,y", "1,2,3", "1,2,3,4,5,66"})
    void illegalLastWinningNumberExceptionTest(String input){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lottoGameController.splitLastWinningNumbers(input);
        }).withMessageContaining(LottoErrorMessage.ILLEGAL_WINNING_NUMBER.getErrorMessage());
    }

    @DisplayName("보너스 번호 유효성 검증")
    @ParameterizedTest
    @ValueSource(strings = {"46", "test", "1,2,3"})
    void illegalBonusNumberExceptionTest(String input){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lottoGameController.validateBonusNumber(input);
        }).withMessageContaining(LottoErrorMessage.ILLEGAL_BONUS_NUMBER.getErrorMessage());
    }

}

