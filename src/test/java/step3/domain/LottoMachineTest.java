package step3.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {
    @DisplayName("로또 발행 테스트: 발행한 로또는 6개의 번호를 가지고 있는가?")
    @Test
    void LottoNumberTest1() {
        LottoMachine lottoMachine = new LottoMachine();
        ArrayList<Integer> lotto = lottoMachine.getRandomNumberLotto();
        assertThat(lotto.size()).isEqualTo(6);
    }

    @DisplayName("로또 발행 테스트: 발행한 로또는 유니크한 6개의 번호를 가지고 있는가?")
    @Test
    void LottoNumberTest2() {
        LottoMachine lottoMachine = new LottoMachine();
        ArrayList<Integer> lotto = lottoMachine.getRandomNumberLotto();
        HashSet<Integer> lottoSet = new HashSet<>(lotto);
        System.out.println(lotto);
        assertThat(lottoSet.size()).isEqualTo(6);
    }

    @DisplayName("로또 발행 테스트: 원하는 갯수 만큼 로또가 발행이 되었는가?")
    @Test
    void LottoIssueTest() {
        int numOfLotto = 6;
        LottoMachine lottoMachine = new LottoMachine();

        ArrayList<ArrayList<Integer>> issuedLottoList = lottoMachine.issue(numOfLotto);
        System.out.println(issuedLottoList);
        assertThat(issuedLottoList.size()).isEqualTo(numOfLotto);
    }
}