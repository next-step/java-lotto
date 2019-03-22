package lotto.enums;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BonusNumberMatchOptionTest {
    @Test
    public void NOT_보너스_넘버가_겹치면_안됨() {
        // given
        // when
        boolean shouldBeFalse = BonusNumberMatchOption.NOT.bonusNumberMatchCheck(true);
        boolean shouldBeTrue = BonusNumberMatchOption.NOT.bonusNumberMatchCheck(false);

        // then
        assertThat(shouldBeFalse).isFalse();
        assertThat(shouldBeTrue).isTrue();
    }

    @Test
    public void MUST_보너스_넘버가_겹쳐야됨() {
        // given
        // when
        boolean shouldBeTrue = BonusNumberMatchOption.MUST.bonusNumberMatchCheck(true);
        boolean shouldBeFalse = BonusNumberMatchOption.MUST.bonusNumberMatchCheck(false);

        // then
        assertThat(shouldBeFalse).isFalse();
        assertThat(shouldBeTrue).isTrue();
    }

    @Test
    public void OPTIONAL_보너스_넘버가_겹치지_않아도됨() {
        // given
        // when
        boolean shouldBeTrue1 = BonusNumberMatchOption.OPTIONAL.bonusNumberMatchCheck(true);
        boolean shouldBeTrue2 = BonusNumberMatchOption.OPTIONAL.bonusNumberMatchCheck(false);

        // then
        assertThat(shouldBeTrue1).isTrue();
        assertThat(shouldBeTrue2).isTrue();
    }
}
