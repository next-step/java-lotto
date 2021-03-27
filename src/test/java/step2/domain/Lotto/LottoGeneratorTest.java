package step2.domain.Lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.strategy.LottoShuffleStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    private List<LottoNumber> testSortLottoNumbers;
    private List<LottoNumber> reverseAndSortLottoNumbers;
    private LottoGenerateCount lottoGenerateCount;

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

        lottoGenerateCount = LottoGenerateCount.newInstance(1000);
    }

    @DisplayName("LottoNumbersGenerator 인스턴스 생성 테스트")
    @Test
    void 생성() {
        // when
        LottoGenerator lottoGenerator = LottoGenerator.newInstance(lottoGenerateCount, lottoNumbers -> {
        });

        // then
        assertThat(lottoGenerator).isNotNull();
    }

    @DisplayName("LottoNumbersGenerator 인스턴스가 Lotto 인스턴스를 생성하고 반환하는지 테스트")
    @Test
    void 반환_Lotto() {
        // given
        LottoGenerator lottoGenerator = LottoGenerator.newInstance(lottoGenerateCount, lottoNumbers -> {
        });

        // when
        Lotto lotto = lottoGenerator.generateLotto();

        // then
        assertThat(lotto).isNotNull();
    }

    @DisplayName("LottoNumbersGenerator 인스턴스가 LottoShuffleStrategy 대로 정렬 셔플을 진행하는지 테스트")
    @Test
    void 반환_Lotto_셔플() {
        // given
        LottoShuffleStrategy lottoShuffleStrategy = lottoNumbers
                -> Collections.sort(lottoNumbers);

        LottoGenerator lottoGenerator = LottoGenerator.newInstance(lottoGenerateCount, lottoShuffleStrategy);

        // when
        Lotto actual = lottoGenerator.generateLotto();
        Lotto expected = Lotto.newInstance(testSortLottoNumbers);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("LottoNumbersGenerator 인스턴스가 LottoShuffleStrategy 대로 역순 셔플을 진행하는지 테스트")
    @Test
    void 반환_Lotto_역순() {
        // given
        LottoShuffleStrategy lottoShuffleStrategy = lottoNumbers
                -> Collections.reverse(lottoNumbers);

        LottoGenerator lottoGenerator = LottoGenerator.newInstance(lottoGenerateCount, lottoShuffleStrategy);

        // when
        Lotto actual = lottoGenerator.generateLotto();
        Lotto expected = Lotto.newInstance(reverseAndSortLottoNumbers);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("LottoNumbersGenerator 인스턴스가 다음에 로또를 생성할 수 있는지 여부를 테스트")
    @Test
    void 반환_다음_로또_생성_카운트() {
        // given
        LottoShuffleStrategy lottoShuffleStrategy = lottoNumbers
                -> Collections.reverse(lottoNumbers);


        // when
        LottoGenerator lottoGenerator = LottoGenerator.newInstance(lottoGenerateCount, lottoShuffleStrategy);
        boolean actual = lottoGenerator.hasNext();

        // then
        assertThat(actual).isTrue();
    }

    @DisplayName("LottoNumbersGenerator 인스턴스가 로또를 생성한 카운트 증가 테스트")
    @Test
    void 반환_다음_카운트로_이동() {
        // given
        LottoShuffleStrategy lottoShuffleStrategy = lottoNumbers
                -> Collections.reverse(lottoNumbers);

        // when
        LottoGenerator lottoGenerator = LottoGenerator.newInstance(lottoGenerateCount, lottoShuffleStrategy);
        lottoGenerator.next();
        boolean actual = lottoGenerator.hasNext();

        // then
        assertThat(actual).isFalse();
    }

}