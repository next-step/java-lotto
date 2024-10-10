package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoValidatorTest {
    
    @DisplayName("숫자만 입력했는지 확인한다")
    @Test
    void onlyInputInt(){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoValidator.validate("a, b, c, 11, 12, 13"))
                .withMessage("숫자만 입력 가능합니다");
    }
    
    @DisplayName("로또는 6개의 숫자만 입력되어야 한다")
    @Test
    void limitCount(){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoValidator.validate("1, 2, 3"))
                .withMessage("로또 번호를 6개 입력하세요");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoValidator.validate(List.of(1, 2, 3, 4, 5, 6, 7)))
                .withMessage("로또 번호를 6개 입력하세요");
    }

    @DisplayName("로또는 1-45범위 내에서 입력되어야 한다")
    @Test
    void limitRange(){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoValidator.validate("100, 101, 3, 4, 5, 6"))
                .withMessage("1-45범위 내의 로또 번호를 입력하세요");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoValidator.validate(List.of(100, 101, 3, 4, 5, 6)))
                .withMessage("1-45범위 내의 로또 번호를 입력하세요");
    }

    @DisplayName("로또는 중복된 번호가 없어야 한다")
    @Test
    void checkDuplicateNumber(){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoValidator.validate("1, 1, 1, 3, 4, 5"))
                .withMessage("로또번호가 중복됐습니다");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoValidator.validate(List.of(1, 1, 1, 3, 4, 5)))
                .withMessage("로또번호가 중복됐습니다");
    }

}
