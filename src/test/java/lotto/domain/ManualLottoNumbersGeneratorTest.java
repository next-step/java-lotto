package lotto.domain;

import lotto.model.request.ReqManualLotto;
import lotto.service.gernerator.ManualLottoNumbersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ManualLottoNumbersGeneratorTest {

    private final ManualLottoNumbersGenerator manualLottoNumbersGenerator = new ManualLottoNumbersGenerator();

    @Test
    @DisplayName("6개의 로또번호 수동 생성 테스트 - 단일")
    void manualSingleLottoNumber() {


        LottoNumbers lottoNumbers = manualLottoNumbersGenerator.generateLottoNumbers(new ReqManualLotto(List.of("1, 2, 3, 4, 5, 6")));

        assertThat(lottoNumbers).isNotNull();
    }


    @ParameterizedTest
    @MethodSource("lottoNumberNotSize6")
    @DisplayName("로또번호가 6개가 되지 않으면 예외를 던진다 - 단일")
    void throwNotSize_six_LottNumberSize(List<String> lottoNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> manualLottoNumbersGenerator.generateLottoNumbers(new ReqManualLotto(lottoNumber)))
                .withMessage("로또 번호는 6개 입력 해주셔야해요 :(");

    }

    static Stream<List<String>> lottoNumberNotSize6() {
        return Stream.of(
                List.of("1, 2, 3, 4, 5"),
                List.of("1, 2, 3, 4, 5, 6, 5, 7")
        );
    }

    @ParameterizedTest
    @MethodSource("duplicateLottoNumber")
    @DisplayName("중복된 로또번호가 존재하면 예외를 던진다 - 단일")
    void throwDuplicateLottoNumber(List<String> lottoNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> manualLottoNumbersGenerator.generateLottoNumbers(new ReqManualLotto(lottoNumber)))
                .withMessage("중복된 로또번호가 존재해요 :(");

    }

    static Stream<List<String>> duplicateLottoNumber() {
        return Stream.of(
                List.of("1, 2, 3, 4, 5, 5"),
                List.of("1, 2, 3, 4, 7, 7")
        );
    }


    @Test
    @DisplayName("6개의 로또번호 수동 생성 테스트 - 벌크")
    void manualBulkLottoNumber() {

        List<String> requestLottoNumberList = List.of(
                "1, 2, 3, 4, 5, 6"
                , "5, 6, 7, 8, 9, 10"
        );

        List<LottoNumbers> lottoNumbers = manualLottoNumbersGenerator.bulkGenerateLottoNumbers(new ReqManualLotto(requestLottoNumberList));

        assertThat(lottoNumbers).hasSize(2);
    }


    @ParameterizedTest
    @MethodSource("lottoBulkNumberNotSize6")
    @DisplayName("로또번호가 6개가 되지 않으면 예외를 던진다 - 벌크")
    void throw_bulk_NotSize_six_LottNumberSize(List<String> lottoNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> manualLottoNumbersGenerator.bulkGenerateLottoNumbers(new ReqManualLotto(lottoNumber)))
                .withMessage("로또 번호는 6개 입력 해주셔야해요 :(");

    }

    static Stream<List<String>> lottoBulkNumberNotSize6() {
        return Stream.of(
                List.of("1, 2, 3, 4, 5","4, 5, 6, 7, 8"),
                List.of("1, 2, 3, 4, 5, 6, 5, 7","1,2,3,4,5")
        );
    }

    @ParameterizedTest
    @MethodSource("bulkDuplicateLottoNumber")
    @DisplayName("중복된 로또번호가 존재하면 예외를 던진다 - 벌크")
    void throw_bulk_DuplicateLottoNumber(List<String> lottoNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> manualLottoNumbersGenerator.generateLottoNumbers(new ReqManualLotto(lottoNumber)))
                .withMessage("중복된 로또번호가 존재해요 :(");

    }

    static Stream<List<String>> bulkDuplicateLottoNumber() {
        return Stream.of(
                List.of("1, 2, 3, 4, 5, 8","1, 2, 5, 5, 5, 5"),
                List.of("1, 2, 3, 4, 5, 7","1, 2, 3, 4, 4, 6")
        );
    }



}