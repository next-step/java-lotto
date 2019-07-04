package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoAllLineTest {

    private String LastWeekWinnerNumber;
    private String LastWeekBonusNumber;
    private List<LottoOneLine> lottos;

    @BeforeEach
    void setUp() {
        LastWeekWinnerNumber = "6,13,23,29,35,42";
        LastWeekBonusNumber = "3";
        lottos = new ArrayList <>();
    }

    @Test
    @DisplayName("총 수익룰 계산 기능 테스트")
    void lottoRateOfReturn() {
        String[][] testLottoSet = {
                {"6", "13", "23", "30", "36", "43"},
                {"1", "5", "7", "8", "9", "19"},
                {"22", "23", "34", "35", "36", "45"}
        };
        lottoConvert(testLottoSet);
        LottoAllLine lottoAllLine = new LottoAllLine(lottos, LastWeekWinnerNumber, LastWeekBonusNumber);
        assertThat(lottoAllLine.rateOfReturn(3000)).isEqualTo(1.66);
    }

    @Test
    @DisplayName("지정된 당첨금액에 맞는 당첨 게임 수 계산 테스트")
    void lottoSummaryWinnerCount() {
        String[][] testLottoSet = {
                {"6", "13", "23", "30", "36", "43"},
                {"1", "5", "7", "8", "9", "19"},
                {"1", "5", "7", "29", "35", "42"},
                {"6", "13", "23", "29", "36", "45"}
        };
        lottoConvert(testLottoSet);
        LottoAllLine lottoAllLine = new LottoAllLine(lottos, LastWeekWinnerNumber, LastWeekBonusNumber);
        assertThat(lottoAllLine.lottoSummaryWinnerCount(5000)).isEqualTo(2);
        assertThat(lottoAllLine.lottoSummaryWinnerCount(50000)).isEqualTo(1);
    }

    @Test
    @DisplayName("지정된 당첨금액에 맞는 당첨 게임 수 계산 테스트(보너스 포함)")
    void lottoSummaryWinnerCountBonus() {
        String[][] testLottoSet = {
                {"3", "6", "13", "23", "29", "35"},
                {"1", "5", "7", "29", "35", "42"},
                {"6", "13", "23", "29", "36", "45"}
        };
        lottoConvert(testLottoSet);
        LottoAllLine lottoAllLine = new LottoAllLine(lottos, LastWeekWinnerNumber, LastWeekBonusNumber);
        assertThat(lottoAllLine.lottoSummaryWinnerCount(50000)).isEqualTo(1);
        assertThat(lottoAllLine.lottoSummaryWinnerCount(30000000)).isEqualTo(1);
    }

    private void lottoConvert(String[][] testLottoSet){
        for (String[] tempLottos : testLottoSet) {
            List<String> lottonumbers = Arrays.asList(tempLottos);
            List<LottoNumber> lottoNumber = lottonumbers.stream()
                    .map(LottoNumber::new)
                    .collect(Collectors.toList());
            lottos.add(new LottoOneLine(lottoNumber));
        }
    }

}
