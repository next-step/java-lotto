package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfitTest {

    @BeforeEach
    void setUp(){
        List<Lotto> lottoList = new ArrayList<>();
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 9, 10, 11);
        Lotto lotto = new Lotto(lottoNumbers);
        lottoList.add(lotto);
        int[] winnerLottoNumbers = {1,2,3,4,5,6};
        new LottoWinner(winnerLottoNumbers);
        LottoGameService.setLottoBuyAmt(14000);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:이득이", "0.35:손해"}, delimiter = ':')
    public void profitToStringTest(double profitRate, String resultString) {
        assertThat(PrintView.profitToString(profitRate)).isEqualTo(resultString);

    }

}
