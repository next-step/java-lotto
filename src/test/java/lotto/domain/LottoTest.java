package lotto.domain;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    private List<LottoNumber> LOTTO_NUMS = Arrays.asList(new LottoNumber[]{LottoNumber.of(1), LottoNumber.of(3), LottoNumber.of(17), LottoNumber.of(24), LottoNumber.of(35), LottoNumber.of(44)});

    private static final Pattern LOTTO_PATTERN = Pattern.compile("[(.),(.),(.),(.),(.),(.)]");

    @Test
    @DisplayName("로또 세트 생성 테스트")
    public void createLotto(){
        Lotto lotto = new Lotto(LOTTO_NUMS);
        assertThat(isValidLottoPattern(lotto.toString())).isTrue();
    }

    @Test
    @DisplayName("로또 세트 생성시 중복 오류 테스트")
    public void createLottoException(){
        List<LottoNumber> duplicatedLottoNums = Arrays.asList(new LottoNumber[]{LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(2), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)});

        assertThatIllegalArgumentException().isThrownBy(()-> new Lotto(duplicatedLottoNums));
    }

    private boolean isValidLottoPattern(String input){
        return LOTTO_PATTERN.matcher(input).find();
    }
}
