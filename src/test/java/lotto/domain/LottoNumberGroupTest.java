package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberGroupTest {

    private final LottoNumberGroup lottoNumberGroup = new LottoNumberGroup();

    @Test
    @DisplayName("6개의 로또번호 자동 생성 테스트")
    void aggregateLottoNumber() {

        assertThat(lottoNumberGroup.aggregateNonDuplicateLottoNumber().getLottoNumberGroupSize()).isEqualTo(6);
    }

    @Test
    @DisplayName("6개의 로또번호 수동 생성 테스트")
    void manualLottoNumber() {

        List<Integer> given = List.of(1, 2, 3, 4, 5, 6);

        List<LottoNumber> result = new ArrayList<>();

        for (Integer givenIndex : given) {
            result.add(LottoNumber.provideLottoNumber(givenIndex));
        }

        assertThat(lottoNumberGroup.initializedManualLottoNumber(given)).isEqualTo(new LottoNumberGroup(result));
    }


    @ParameterizedTest
    @MethodSource("lottoNumberNotSize6")
    @DisplayName("로또번호가 6개가 되지 않으면 예외를 던진다")
    void throwNotSize_six_LottNumberSize(List<Integer> lottoNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> lottoNumberGroup.initializedManualLottoNumber(lottoNumber))
                .withMessage("로또 번호는 6개 입력 해주셔야해요 :(");

    }

    static Stream<List<Integer>> lottoNumberNotSize6() {
        return Stream.of(
                List.of(1, 2, 3, 4, 5),
                List.of(1, 2, 3, 4, 5, 6, 5, 7)
        );
    }

    @ParameterizedTest
    @MethodSource("duplicateLottoNumber")
    @DisplayName("중복된 로또번호가 존재하면 예외를 던진다")
    void throwDuplicateLottoNumber(List<Integer> lottoNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> lottoNumberGroup.initializedManualLottoNumber(lottoNumber))
                .withMessage("중복된 로또번호가 존재해요 :(");

    }

    static Stream<List<Integer>> duplicateLottoNumber() {
        return Stream.of(
                List.of(1, 2, 3, 4, 5, 5),
                List.of(1, 2, 3, 4, 7, 7)
        );
    }


    @Test
    @DisplayName("당첨된 로또 번호 개수 확인 테스트")
    void findMatchingLottNumber() {
        List<Integer> winningNumberGroup = List.of(1, 2, 3, 4, 5, 6);
        LottoNumberGroup winingLotto = lottoNumberGroup.initializedManualLottoNumber(winningNumberGroup);

        List<Integer> requestLottoNumberGroup = List.of(1, 2, 3, 11, 12, 15);
        LottoNumberGroup request = lottoNumberGroup.initializedManualLottoNumber(requestLottoNumberGroup);

        assertThat(request.countMatchingLottNumber(winingLotto)).isEqualTo(3);

    }

}