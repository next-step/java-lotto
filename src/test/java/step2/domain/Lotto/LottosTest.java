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

class LottosTest {

    private List<Lotto> lottoList;

    @BeforeEach
    void setUp() {
        lottoList = new ArrayList<>();

        List<LottoNumber> testNumbers = IntStream
                .range(1,6)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());

        lottoList.add(Lotto.newInstance(testNumbers));
    }



    @DisplayName("Lottos 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {

        // when
        Lottos lottos = Lottos.newInstance(lottoList);

        // then
        assertThat(lottos).isNotNull();
    }
}