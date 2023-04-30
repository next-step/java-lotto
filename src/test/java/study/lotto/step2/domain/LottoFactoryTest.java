package study.lotto.step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


class LottoFactoryTest {
    private static final int START_SEQUENCE_NUMBER = 1;
    private static final int END_SEQUENCE_NUMBER = 6;

    @Test
    @DisplayName("1에서 6을 선택한 Lotto 객체 생성")
    void lotto() {
        // given
        LottoFactory lottoFactory = new LottoFactory(SequenceNumberSelector());

        // when
        Lotto lotto = lottoFactory.lotto();

        // then
        Assertions.assertThat(lotto).isEqualTo(new Lotto(sequenceNumber()));
    }

    private AutoNumberSelector SequenceNumberSelector() {
        return this::sequenceNumber;
    }

    private List<Integer> sequenceNumber() {
        return IntStream.rangeClosed(START_SEQUENCE_NUMBER, END_SEQUENCE_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }
}