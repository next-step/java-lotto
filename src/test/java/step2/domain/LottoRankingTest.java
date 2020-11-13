package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LottoRankingTest {

    @DisplayName("로또 랭킹을 테스트 합니다.")
    @ParameterizedTest
    @MethodSource
    void createLottoRank( ){
        assertThat(new LottoRank().matchLottoRank());
    }

    private static Stream<Arguments> provideLottoRank(){
        return Stream.of(
                Arguments.of()
        );
    }

}
