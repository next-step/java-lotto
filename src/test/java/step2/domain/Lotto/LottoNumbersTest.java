package step2.domain.Lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumbersTest {

    private List<LottoNumber> lottoNumberList;

    @BeforeEach
    void setUp(){
        lottoNumberList =  IntStream.range(1, 7)
                    .mapToObj(LottoNumber::valueOf)
                    .collect(Collectors.toList());
    }

    @DisplayName("LottoNumbers 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {

        // when
        LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberList);

        // then
        assertThat(lottoNumbers).isNotNull();
    }
}