package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {


    @DisplayName("로또 인스턴스 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:3:5:7", "2:3:5:8"}, delimiter = ':')
    public void createLottoInstanceTest(int sequence, int element2, int element3, int element4) {

        //Given & When
        Lotto lotto = new Lotto(sequence, new LottoMachine() {
            @Override
            public Set<Integer> createLottoNumber() {
                return new LinkedHashSet<>(Arrays.asList(element2, element3, element4));
            }
        });

        //Then
        assertThat(lotto.getLottoPickNumber()).contains(element2, element3, element4);
    }

    @DisplayName("로또 인스턴스 equals 동일 성공 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:1:1", "6:6:6"}, delimiter = ':')
    public void lottoInstanceEqualsSuccessTest(Integer sequence, Integer sequence2, Integer sequence3) {
        //Given & When
        Lotto lotto = new Lotto(sequence, new LottoAutoMachine());
        Lotto lotto2 = new Lotto(sequence2, new LottoAutoMachine());
        Lotto lotto3 = new Lotto(sequence3, new LottoAutoMachine());

        //Then
        assertThat(lotto).isEqualTo(lotto2).isEqualTo(lotto3);
    }

    @DisplayName("로또 인스턴스 equals 실패 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:2:3", "6:3:5"}, delimiter = ':')
    public void lottoInstanceEqualsFailTest(Integer sequence, Integer sequence2, Integer sequence3) {
        //Given & When
        Lotto lotto = new Lotto(sequence, new LottoAutoMachine());
        Lotto lotto2 = new Lotto(sequence2, new LottoAutoMachine());
        Lotto lotto3 = new Lotto(sequence3, new LottoAutoMachine());

        //Then
        assertThat(lotto).isNotEqualTo(lotto2).isNotEqualTo(lotto3);
    }

    @DisplayName("matchPrizeNumber 메서드 테스트")
    @ParameterizedTest
    @MethodSource("createLottoNumber")
    public void matchPrizeNumberTest(LinkedHashSet<Integer> expected) {
        //Given
        Lotto lotto = new Lotto(1, new LottoMachine() {
            @Override
            public Set<Integer> createLottoNumber() {
                return expected;
            }
        });

        //When
        PrizeInformation prizeInformation = lotto.matchPrizeNumber(new PrizeLotto(new LinkedHashSet<>(Arrays.asList(1, 3, 5, 6, 7, 8))));

        //That
        assertThat(prizeInformation).isEqualTo(PrizeInformation.findByPrizePrice(prizeInformation.getMatchNumberCount()));

    }

    static Stream<Arguments> createLottoNumber() {
        return Stream.of(
                Arguments.of(new LinkedHashSet<>(Arrays.asList(1, 3, 5))),
                Arguments.of(new LinkedHashSet<>(Arrays.asList(2, 3, 5, 6))),
                Arguments.of(new LinkedHashSet<>(Arrays.asList(2, 3, 5, 6, 8))),
                Arguments.of(new LinkedHashSet<>(Arrays.asList(2, 3, 5, 6, 8, 12)))
        );
    }
}