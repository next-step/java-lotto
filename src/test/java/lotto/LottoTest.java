package lotto;

import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;
import lotto.model.RewardStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {

    @DisplayName("로또 생성 테스트")
    @Test
    void LOTTO_NUMBER_COUNT() {
        List<String> manuaLottoNumbers = new ArrayList<>();

        Lotto lott = new Lotto(5, manuaLottoNumbers);

        assertThat(lott.getAutoLotto()).isEqualTo(5);
        assertThat(lott.getManualLotto()).isEqualTo(0);
    }

    @DisplayName("로또 수동 생성 테스트")
    @Test
    void LOTTO_MANUAL_NUMBER_COUNT() {
        List<String> manuaLottoNumbers = new ArrayList<>();
        manuaLottoNumbers.add("1,2,3,4,5,6");
        manuaLottoNumbers.add("16,18,29,30,31,32");

        Lotto lott = new Lotto(0, manuaLottoNumbers);
        assertThat(lott.getAutoLotto()).isEqualTo(0);
        assertThat(lott.getManualLotto()).isEqualTo(2);
    }

    @DisplayName("로또 수동 생성 오류 테스트")
    @Test
    void LOTTO_MANUAL_NUMBER_EXCEPTION() {
        List<String> manuaLottoNumbers = new ArrayList<>();
        manuaLottoNumbers.add("16,18,29,30,31,32,33");
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(0, manuaLottoNumbers);
        });
    }

    @DisplayName("로또 당첨 테스트")
    @Test
    void USER_WINNER_NUMBER() {
        List<String> manuaLottoNumbers = new ArrayList<>();
        Lotto lotto = new Lotto(5, manuaLottoNumbers);
        LottoNumbers lottoNumbers = lotto.getAutoLottoNumbers();

        String[] winnerExpected = lottoNumbers.getLottoNumbers().get(0).getLottoNumber()
                                    .stream().map(n -> n.toString())
                                    .collect(Collectors.toList())
                                    .toArray(String[]::new);

        assertThat(lotto.getAutoRewardLotto(winnerExpected, 0).get(0))
                   .isEqualTo(new RewardStatus(6, false));
    }

    @DisplayName("로또 보너스 2등 테스트")
    @Test
    void USER_WINNER_WITH_BONUS_NUMBER() {
        List<String> manuaLottoNumbers = new ArrayList<>();
        Lotto lotto = new Lotto(1, manuaLottoNumbers);
        LottoNumbers lottoNumbers = lotto.getAutoLottoNumbers();

        String[] winnerExpected = lottoNumbers.getLottoNumbers().get(0).getLottoNumber()
                .stream().map(n -> n.toString())
                .collect(Collectors.toList())
                .toArray(String[]::new);
        int bonus = Integer.parseInt(winnerExpected[0]);
        winnerExpected[0] = "0";

        assertThat(lotto.getAutoRewardLotto(winnerExpected, bonus).get(0))
                    .isEqualTo(new RewardStatus(5, true));
    }






}
