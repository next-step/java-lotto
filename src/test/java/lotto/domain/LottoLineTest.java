package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoLineTest {

    @DisplayName("일치하는 로또번호의 갯수(rank)를 알수 있다.")
    @Test
    void getRank(){
        List<LottoNum> lottoNumList = IntStream
            .range(1,7).mapToObj(value -> new LottoNum(value)).collect(Collectors.toList());

        LottoNums lottoNums = new LottoNums(lottoNumList);
        LottoLine lottoLine = new LottoLine(lottoNums);

        assertThat(lottoLine.getRank(lottoNums)).isEqualTo(Rank.FIRST);
    }

}
