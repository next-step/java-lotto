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

    @DisplayName("지난 당첨 번호 view 유효성 검증")
    @ParameterizedTest
    @ValueSource(strings = {"3%4%6%7%8%9", "q,w,e,r,t,y"})
    void illegalLastWinningNumberExceptionTest(String input){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lottoGameController.parseLastWinningNumber(input);
        }).withMessageContaining(LottoErrorMessage.ILLEGAL_LOTTO_NUMBER.getErrorMessage());
    }

    @DisplayName("보너스 번호 view 유효성 검증")
    @ParameterizedTest
    @ValueSource(strings = {"test", "1,2,3"})
    void illegalBonusNumberExceptionTest(String input){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lottoGameController.parseBonusNumber(input);
        }).withMessageContaining(LottoErrorMessage.ILLEGAL_BONUS_NUMBER.getErrorMessage());
    }

}

