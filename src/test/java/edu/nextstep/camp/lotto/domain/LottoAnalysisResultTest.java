package edu.nextstep.camp.lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static edu.nextstep.camp.lotto.domain.LottoRank.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoAnalysisResultTest {

    private LottoAnalysisResult analysisResult;

    @BeforeEach
    void init(){
        analysisResult = new LottoAnalysisResult(List.of(SECOND, FOURTH, FOURTH, NONE, NONE, NONE));
    }

    @ParameterizedTest
    @CsvSource(delimiter = ':', value = { "SECOND:1", "FOURTH:2",  "FIRST:0",})
    void 로또_랭크_갯수(String rank, int expected){
        int count = analysisResult.countByLottoRank(LottoRank.valueOf(rank));

        assertThat(count).isEqualTo(expected);
    }

    @Test
    void 수익률(){
        String earningRate = analysisResult.earningRate();

        assertThat(earningRate).isEqualTo("5016.67");
    }
}
