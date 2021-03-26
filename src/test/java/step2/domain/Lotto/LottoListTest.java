package step2.domain.Lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoListTest {

    private List<Lotto> testLottoList;

    @BeforeEach
    void setUp() {
        testLottoList = new ArrayList<>();

        List<LottoNumber> testLottoNumbers = IntStream
                .range(1,6)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());

        testLottoList.add(Lotto.newInstance(testLottoNumbers));
    }

    @DisplayName("LottoList 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {

        // when
        LottoList lottoList = LottoList.newInstance(testLottoList);

        // then
        assertThat(lottoList).isNotNull();
    }

}