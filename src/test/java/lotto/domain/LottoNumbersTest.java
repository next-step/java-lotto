package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    private LottoNumbers lottoNumbers;

    @BeforeEach
    void setUp() {
        List<LottoNumber> lottoNumberBox = new ArrayList<>();
        lottoNumberBox.add(LottoNumberFactory.createAutoLottoNumbers());
        lottoNumberBox.add(LottoNumberFactory.createAutoLottoNumbers());
        lottoNumberBox.add(LottoNumberFactory.createManualLottoNumbers("1, 2, 3, 4, 5, 6"));
        lottoNumberBox.add(LottoNumberFactory.createManualLottoNumbers("7, 8, 9, 10, 11, 12"));

        this.lottoNumbers = LottoNumbers.newInstance(lottoNumberBox);
    }

    @DisplayName("로또 번호 리스트가 존재하지 않으면 생성할 수 없다.")
    @Test
    void canNotCreateLottoNumbersIfLottoNumbersIsNull() {
        assertThatThrownBy(() -> LottoNumbers.newInstance(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 존재하지 않으면 생성할 수 없다.")
    @Test
    void canNotCreateLottoNumbersIfLottoNumberIsNull() {
        assertThatThrownBy(() -> {
            List<LottoNumber> lottoNumbers = Arrays.asList(
                    LottoNumberFactory.createAutoLottoNumbers(),
                    null
            );
            LottoNumbers.newInstance(lottoNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 묶음 객체를 생성할 수 있다.")
    @Test
    void canCreateLottoNumbers() {
        LottoNumbers newInstance = LottoNumbers.newInstance();
        assertThat(newInstance).isInstanceOf(LottoNumbers.class);
        assertThat(newInstance.getCount()).isZero();

        assertThat(this.lottoNumbers).isInstanceOf(LottoNumbers.class);
        assertThat(this.lottoNumbers.getCount()).isEqualTo(4);
    }

    @DisplayName("로또 번호 묶음을 추가할 수 있다.")
    @Test
    void canAddAll() {
        int beforeCount = this.lottoNumbers.getCount();

        List<LottoNumber> addLottoNumbers = Arrays.asList(
                LottoNumberFactory.createAutoLottoNumbers(),
                LottoNumberFactory.createAutoLottoNumbers()
        );
        this.lottoNumbers.addAll(addLottoNumbers);

        assertThat(beforeCount + addLottoNumbers.size()).isEqualTo(this.lottoNumbers.getCount());
    }

    @DisplayName("로또 번호 개수를 얻을 수 있다.")
    @Test
    void canGetCount() {
        assertThat(this.lottoNumbers.getCount()).isEqualTo(4);
    }

    @DisplayName("생성 유형별 개수를 얻을 수 있다.")
    @Test
    void canGetCountByCreationType() {
        assertThat(this.lottoNumbers.getCountByCreationType(CreationType.MANUAL)).isEqualTo(2);
        assertThat(this.lottoNumbers.getCountByCreationType(CreationType.AUTO)).isEqualTo(2);
        assertThat(this.lottoNumbers.getCountByCreationType(CreationType.NONE)).isZero();
    }

    @DisplayName("List로 변환할 수 있다.")
    @Test
    void canGetToList() {
        List<LottoNumber> list = this.lottoNumbers.toList();
        assertThat(list).isInstanceOf(List.class);
    }

    @DisplayName("객체를 복사할 수 있다.")
    @Test
    void canGetClone() {
        LottoNumbers clone = this.lottoNumbers.clone();
        assertThat(this.lottoNumbers).isNotEqualTo(clone);
    }

    @DisplayName("로또 당첨 결과를 얻을 수 있다.")
    @Test
    void canCalculateMatchCount() {
        LottoNumber winLottoNumber = LottoNumber.newInstance(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.newInstance(7, winLottoNumber);
        LottoMatchResult lottoMatchResult = this.lottoNumbers.calculateMatchCount(winLottoNumber, bonusNumber);

        assertThat(lottoMatchResult).isInstanceOf(LottoMatchResult.class);
    }
}
