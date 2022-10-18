package lotto.domain;

import lotto.exception.EmptyIssuedLottoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static lotto.domain.LottoNumber.lottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoMachineTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    public void initialMachine() {
        this.lottoMachine = new LottoMachine();
    }

    @Test
    @DisplayName("자동으로 발급된 로또의 수를 검증한다.")
    void automaticIssue() {
        lottoMachine.automaticIssue(lottoNumbers(), 10);
        assertThat(lottoMachine.lottoTickets()).hasSize(10);
    }

    @Test
    @DisplayName("수동으로 발급된 로또의 수를 검증한다.")
    void manualIssue() {
        lottoMachine.manualIssue(new ArrayList<>(Collections.singleton("1,7,13,18,22,43".split(","))));
        assertThat(lottoMachine.lottoTickets()).hasSize(1);
    }

    @Test
    @DisplayName("발급된 자동 로또와 수동 로또의 수를 조회한다.")
    void getLottoTickets() {
        lottoMachine.automaticIssue(lottoNumbers(), 15);
        lottoMachine.manualIssue(new ArrayList<>(Collections.singleton("1,7,13,18,22,43".split(","))));
        assertThat(lottoMachine.lottoTickets()).hasSize(16);
    }

    @Test
    @DisplayName("발급된 로또가 없으면 예외가 발생한다.")
    void unissuedLottoException() {
        assertThatThrownBy(() -> lottoMachine.lottoTickets())
                .isExactlyInstanceOf(EmptyIssuedLottoException.class);
    }
}
