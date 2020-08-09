package lotto.domain.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    static final class LottoNo {
        public static final String ERROR_MESSAGE_UNEXPECTED_RANGE_NUMBER = "로또번호는 1 ~ 45까지의 숫자 입니다.";
        public static final int START_LOTTO_NO = 1;
        public static final int END_LOTTO_NO = 45;
        private static final Set<LottoNo> cached;
        static {
            final Set<LottoNo> lottoNos = IntStream.rangeClosed(START_LOTTO_NO, END_LOTTO_NO)
                                                      .mapToObj(LottoNo::new)
                                                      .collect(Collectors.toCollection(LinkedHashSet::new))
                ;
            cached = Collections.unmodifiableSet(lottoNos);
        }
        private final int lottoNo;

        private LottoNo(int lottoNo) {
            this.lottoNo = lottoNo;
        }

        static LottoNo valueOf(final int lottoNo) {
            return cached.stream()
                         .filter(l -> l.lottoNo == lottoNo)
                         .findAny()
                         .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE_UNEXPECTED_RANGE_NUMBER))
                ;
        }

        static List<LottoNo> shuffle(){
            final List<LottoNo> lottoNoList = new ArrayList<>(cached);
            Collections.shuffle(lottoNoList);

            return Collections.unmodifiableList(lottoNoList);
        }

        int getLottoNo() {
            return lottoNo;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            LottoNo lottoNo1 = (LottoNo) o;
            return lottoNo == lottoNo1.lottoNo;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(lottoNo);
        }

        @Override
        public String toString() {
            return Integer.toString(lottoNo);
        }
    }
}
