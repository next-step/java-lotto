package step2.domain.generator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.lotto.Lotto;
import step2.domain.lotto.LottoNumber;
import step2.exception.LottoShuffleNullPointerException;
import step2.strategy.LottoShuffleStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGeneratorTest {

    private List<LottoNumber> testSortLottoNumbers;
    private List<LottoNumber> reverseAndSortLottoNumbers;

    @BeforeEach
    void setUp() {
        testSortLottoNumbers = IntStream
                .range(1, 7)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());

        reverseAndSortLottoNumbers = IntStream
                .range(40, 46)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());

    }

    @DisplayName("LottoNumbersGenerator 인스턴스 생성 테스트")
    @Test
    void 생성() {
        // when
        LottoGenerator lottoGenerator = LottoGenerator.from(lottoNumbers -> {});

        // then
        assertThat(lottoGenerator).isNotNull();
    }

    @DisplayName("LottoNumbersGenerator 인스턴스에 null 주입시 예외처리 테스트")
    @Test
    void 검증() {
        // when
        assertThatThrownBy(()-> {
            LottoGenerator.from(null);
        }).isInstanceOf(LottoShuffleNullPointerException.class)
                .hasMessageContaining("셔플 전략이 null 입니다.");
    }


}