package lottogame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {
    private LottoNumber lotto;

    @Test
    void 로또번호_유효성체크_로또번호_갯수_많을때() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    lotto = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
                }).withMessage("로또 번호의 입력이 잘못되었습니다. 다시 프로그램을 실행해주세요.");
    }

    @Test
    void 로또번호_유효성체크_로또번호_갯수_적을때() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    lotto = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5));
                }).withMessage("로또 번호의 입력이 잘못되었습니다. 다시 프로그램을 실행해주세요.");;
    }

    @Test
    void 로또번호_유효성_체크_번호범위_넘을때() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    lotto = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 50));
                }).withMessage("입력한 로또 숫자가 잘못되었습니다. 프로그램을 종료합니다.");
    }

    @Test
    void 로또번호_유효성_체크_입력내용이_없을때() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    lotto = new LottoNumber(Arrays.asList());
                }).withMessage("로또 번호의 입력이 잘못되었습니다. 다시 프로그램을 실행해주세요.");
    }

    @Test
    void 로또번호_유효성_체크_입력내용이_음수일때() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    lotto = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, -7));
                }).withMessage("입력한 로또 숫자가 잘못되었습니다. 프로그램을 종료합니다.");
    }
}