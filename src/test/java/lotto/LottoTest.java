package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {
    
    @Test
    @DisplayName("당첨 번호 입력")
    public void winnerNumber() throws Exception {
        //given
        String winnerNumbers = "1,2,3,4,5,6";
        
        //when
        SbsHappyDreamLottoLive lottoLive = new SbsHappyDreamLottoLive(winnerNumbers);
        
        //then
        lottoLive.isWinnerNumbersValid();
    }
}
