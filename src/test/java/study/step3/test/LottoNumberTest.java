package study.step3.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import study.step3.domain.LottoNumber;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @ParameterizedTest
    @DisplayName("로또 번호는 1부터 45 사이의 숫자인지 테스트")
    @ValueSource(ints = {-1, 46, 0, 100})
    public void lottoNumberInvalid(int inputNumber){
        assertThatThrownBy(()-> LottoNumber.cacheNumber(inputNumber)
                ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("로또 번호 빈 값 입력시 예외처리 테스트")
    @NullAndEmptySource
    public void lottoNumberNullTest(String inputNull){
        assertThatThrownBy(()-> new LottoNumber(inputNull)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 볼 유효성 검사 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:3", "10,20,30,33,34,45:10", "1,3,5,6,7,43:5"}, delimiter = ':')
    void BonusBallInvalidTest(String lottonumbersString, int bonusball){
        String [] lottoNumberSplit = lottonumbersString.split(",");
        List<LottoNumber> lottoNumbers = Stream.of(lottoNumberSplit)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        assertThatThrownBy(()-> LottoNumber.cacheNumber(bonusball).validateDuplicationBonusBall(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);


    }

    @DisplayName("보너스 볼 일치 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:3", "10,20,30,33,34,45:10", "1,3,5,6,7,43:5"}, delimiter = ':')
    void BonusBallMatchTest(String lottonumbersString, int bonusball){
        String [] lottoNumberSplit = lottonumbersString.split(",");
        Set<LottoNumber> lottoNumbers = Stream.of(lottoNumberSplit)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());

        assertThat(LottoNumber.cacheNumber(bonusball).isMatch(lottoNumbers))
                .isTrue();
    }
}
