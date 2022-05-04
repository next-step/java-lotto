package lotto.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Nested
    class valueOf_메서드는 {

        @Nested
        class _5개의_일치하는_숫자가_주어질경우 {
            private static final int matchOfCount = 5;

            @Nested
            class 보너스가_일치하는_경우 {
                private static final boolean matchBonus = true;

                @Test
                void _2등을_리턴한다() {
                    final Rank rank = Rank.valueOf(matchOfCount, matchBonus);

                    assertThat(rank).isEqualTo(Rank.SECOND);
                }
            }

            @Nested
            class 보너스가_일치하지_않는경우 {
                private static final boolean matchBonuse = false;

                @Test
                void _3등을_리턴한다() {
                    final Rank rank = Rank.valueOf(matchOfCount, matchBonuse);

                    assertThat(rank).isEqualTo(Rank.THIRD);
                }
            }
        }

        @Nested
        class _3개_미만의_일치하는_숫자가_주어질경우 {

            @ParameterizedTest
            @ValueSource(ints = {0, 1, 2})
            void _MISS를_리턴한다(int matchOfCount) {
                final Rank rank = Rank.valueOf(matchOfCount);

                assertThat(rank).isEqualTo(Rank.MISS);
            }
        }
    }
}
