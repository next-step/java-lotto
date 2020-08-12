package lotto.domain.core;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNoTest {
    @DisplayName("로또번호는 1~45까지 숫자 이외에는 예외 발생함")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 100})
    void lottoNo_unexpectedRange(int lottoNo) {
        assertThatIllegalArgumentException()
            .isThrownBy(()->LottoNo.valueOf(lottoNo))
            .withMessage(LottoNo.ERROR_MESSAGE_UNEXPECTED_RANGE_NUMBER);
    }

    @DisplayName("로또번호는 1~45 숫자로 단일 객체임")
    @RepeatedTest(45)
    void lottoNo_singleton(RepetitionInfo repetitionInfo) {
        assertThat(LottoNo.valueOf(repetitionInfo.getCurrentRepetition()))
            .isSameAs(LottoNo.valueOf(repetitionInfo.getCurrentRepetition()))
        ;
    }

    @DisplayName("로또번호가 shuffle된 후에 로또번호 저장소가 다른지 확인")
    @Test
    void lottoNo_shuffleDiffList() {
        List<LottoNo> oldShuffleLottoNos = LottoNo.shuffle();
        List<LottoNo> newShuffleLottoNos = LottoNo.shuffle();
        assertThat(oldShuffleLottoNos).isNotSameAs(newShuffleLottoNos);
    }

    @DisplayName("로또번호가 shuffle된 후에 로또번호가 단일 객체를 유지하는 지 확인")
    @Test
    void lottoNo_shuffleAfterSameLottoInst() {
        LottoNo lottoNo = LottoNo.shuffle().get(0);
        assertThat(lottoNo).isSameAs(LottoNo.valueOf(lottoNo.getLottoNo()));
    }
}
