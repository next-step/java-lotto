package lotto_auto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketTest {

    @DisplayName("로또 번호가 null 이 아닌지 테스트")
    public void lottoTicketNumberIsNotNullTest() {
        LottoTicket lottoTicket = new LottoTicket();
        List<Integer> export = lottoTicket.export();
        assertThat(export).isNotNull();
    }

    @DisplayName("생성한 로또 번호가 6개인지 테스트")
    @Test
    public void lottoTicketNumberCountTest() {
        LottoTicket lottoTicket = new LottoTicket();
        assertThat(lottoTicket.getNumberCount()).isEqualTo(6);
        assertThat(lottoTicket.export().size()).isEqualTo(6);
    }

    @DisplayName("로또 번호를 자동 생성 할때 생성한 번호가 1 이상 44이하인지 테스트")
    @RepeatedTest(100)
    public void lottoNumberRangeTest() {
        LottoTicket lottoTicket = new LottoTicket();
        List<Integer> export = lottoTicket.export();
        assertAll(
                () -> assertThat(export.get(0)).isLessThan(45),
                () -> assertThat(export.get(0)).isGreaterThan(0),
                () -> assertThat(export.get(1)).isLessThan(45),
                () -> assertThat(export.get(1)).isGreaterThan(0),
                () -> assertThat(export.get(2)).isLessThan(45),
                () -> assertThat(export.get(2)).isGreaterThan(0),
                () -> assertThat(export.get(3)).isLessThan(45),
                () -> assertThat(export.get(3)).isGreaterThan(0),
                () -> assertThat(export.get(4)).isLessThan(45),
                () -> assertThat(export.get(4)).isGreaterThan(0),
                () -> assertThat(export.get(5)).isLessThan(45),
                () -> assertThat(export.get(5)).isGreaterThan(0)
        );
    }

    @DisplayName("로또 번호를 수동으로 입력 했을때 예외 발생 테스트 - 6개 미만")
    @Test
    public void lottoNumberCountTest() {
        List<Integer> lottoNumber = new ArrayList<>();
        lottoNumber.add(10);
        lottoNumber.add(2);
        lottoNumber.add(3);
        lottoNumber.add(4);
        lottoNumber.add(1);
        assertThatThrownBy(
                () -> new LottoTicket(lottoNumber)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호를 수동으로 입력 했을때 예외 발생 테스트 - 숫자 범위 테스트")
    @Test
    public void lottoNumberCountRangeTest() {
        List<Integer> lottoNumber = new ArrayList<>();
        lottoNumber.add(-1);
        lottoNumber.add(46);
        lottoNumber.add(3);
        lottoNumber.add(4);
        lottoNumber.add(1);
        lottoNumber.add(2);
        assertThatThrownBy(
                () -> new LottoTicket(lottoNumber)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호를 수동으로 입력 했을때 예외 발생 테스트 - 중복 테스트")
    @Test
    public void lottoNumberDuplicateTest() {
        List<Integer> lottoNumber = new ArrayList<>();
        lottoNumber.add(1);
        lottoNumber.add(1);
        lottoNumber.add(2);
        lottoNumber.add(3);
        lottoNumber.add(4);
        lottoNumber.add(5);
        assertThatThrownBy(
                () -> new LottoTicket(lottoNumber)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정답 수 반환 테스트")
    @Test
    public void matchNumberCountTest(){
        List<Integer> lottoNumber = new ArrayList<>();
        lottoNumber.add(1);
        lottoNumber.add(2);
        lottoNumber.add(3);
        lottoNumber.add(4);
        lottoNumber.add(5);
        lottoNumber.add(6);
        LottoTicket lottoTicket = new LottoTicket(lottoNumber);

        List<Integer> winningNumber = new ArrayList<>();
        lottoNumber.add(4);
        lottoNumber.add(5);
        lottoNumber.add(6);
        lottoNumber.add(7);
        lottoNumber.add(8);
        lottoNumber.add(9);
        LottoTicket winningTicket = new LottoTicket(winningNumber);

        assertThat(lottoTicket.matchNumberCount(winningTicket)).isEqualTo(3);
    }


}
