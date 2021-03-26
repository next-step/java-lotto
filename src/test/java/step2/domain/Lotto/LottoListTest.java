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

    @DisplayName("LottoList 인스턴스가 쇼유한 값을 반환하는지에 대한 테스트")
    @Test
    void 반환() {

        // when
        LottoList lottoList = LottoList.newInstance(testLottoList);
        List<Lotto> actual = lottoList.getLottoList();

        // then
        assertThat(actual).isEqualTo(testLottoList);
    }

    @DisplayName("LottoList 인스턴스가 쇼유한 값을 기준으로 비교를 반환하는지 테스트")
    @Test
    void 비교() {

        // when
        LottoList actualLottoList = LottoList.newInstance(testLottoList);
        LottoList expectedLottoList = LottoList.newInstance(testLottoList);

        // then
        assertThat(actualLottoList).isEqualTo(expectedLottoList);
    }

}