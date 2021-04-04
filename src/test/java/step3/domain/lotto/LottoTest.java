package step3.domain.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.exception.LottoSizeMissMatchException;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    private Set<LottoNumber> lottoNumbers;
    private Set<LottoNumber> comparedLottoNumber;

    @BeforeEach
    void beforeEach() {
        lottoNumbers = IntStream.range(1, 7)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toSet());

        comparedLottoNumber = IntStream.range(6, 12)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toSet());

    }

    @DisplayName("Lotto 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        Set<LottoNumber> inputValue = lottoNumbers;

        // when
        Lotto lotto = Lotto.of(inputValue);

        // then
        assertThat(lotto).isNotNull();
    }

    @DisplayName("Lotto 인스턴스 문자열로 생성 여부 테스트")
    @Test
    void 생성_문자열() {
        // given
        Set<LottoNumber> inputValue = lottoNumbers;
        String stringInputValue = "1, 2, 3, 4, 5, 6";

        // when
        Lotto expected = Lotto.of(inputValue);
        Lotto actual = Lotto.of(stringInputValue);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("Lotto 인스턴스 자릿수 검증 여부 테스트")
    @Test
    void 검증_자릿수() {
        // given
        Set<LottoNumber> sizeMissLottoNumbers = IntStream.range(1, 6)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toSet());

        // when and then
        assertThatThrownBy(() -> Lotto.of(sizeMissLottoNumbers))
                .isInstanceOf(LottoSizeMissMatchException.class)
                .hasMessageContaining("로또 숫자가 맞지 않습니다.");

    }

    @DisplayName("Lotto 인스턴스가 특정 숫자를 포함하는지 검증 여부 테스트")
    @Test
    void 비교_포함한숫자() {
        // given
        Set<LottoNumber> inputValue = lottoNumbers;

        // when
        Lotto lotto = Lotto.of(inputValue);
        boolean actual = lotto.isIncludeLottoNumber(LottoNumber.valueOf(1));

        // then
        assertThat(actual).isTrue();
    }

    @DisplayName("Lotto 인스턴스가 특정 숫자를 몇개 포함하는지 검증 여부 테스트")
    @Test
    void 비교_포함한숫자_갯수() {
        // given
        Set<LottoNumber> standardValue = lottoNumbers;
        Set<LottoNumber> targetValue = comparedLottoNumber;
        int expected = 1;

        // when
        Lotto standardLotto = Lotto.of(standardValue);
        Lotto targetLotto = Lotto.of(targetValue);

        int actual = standardLotto.getCountOfMatch(targetLotto);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("Lotto 인스턴스가 소유한 값 반환 여부 테스트")
    @Test
    void 반환() {
        // given
        Set<LottoNumber> expected = lottoNumbers;

        // when
        Lotto lotto = Lotto.of(expected);
        Set<LottoNumber> actual = lotto.getLottoNumbers();

        // then
        assertThat(actual).isEqualTo(expected);
    }

}