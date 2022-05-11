package lotto.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
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
                assertThat(Rank.valueOf(matchOfCount, true)).isEqualTo(Rank.MISS);
                assertThat(Rank.valueOf(matchOfCount, false)).isEqualTo(Rank.MISS);
            }
        }

        @Nested
        class _5개가_아닌_숫자가_주어질경우 {

            @ParameterizedTest
            @EnumSource(
                    value = Rank.class,
                    names = {"SECOND", "THIRD"},
                    mode = EnumSource.Mode.EXCLUDE
            )
            void 본인의_rank를_리턴한다(Rank rank) {
                assertThat(Rank.valueOf(rank, true)).isEqualTo(rank);
                assertThat(Rank.valueOf(rank, false)).isEqualTo(rank);
            }
        }
    }

    @Nested
    class isSecond_메서드는 {

        @Nested
        class second_rank가_주어진경우 {

            @Test
            void true를_리턴한다() {
                Rank rank = Rank.SECOND;

                boolean actual = rank.isSecond();

                assertThat(actual).isTrue();
            }
        }

        @Nested
        class second가아닌_rank가_주어진경우 {

            @ParameterizedTest
            @EnumSource(
                    value = Rank.class,
                    mode = EnumSource.Mode.EXCLUDE,
                    names = "SECOND"
            )
            void false를_리턴한다(Rank rank) {
                boolean actual = rank.isSecond();

                assertThat(actual).isFalse();
            }
        }
    }

    @Nested
    class isMiss_메서드는 {

        @Nested
        class miss_rank가_주어진경우 {

            @Test
            void true를_리턴한다() {
                Rank rank = Rank.MISS;

                boolean actual = rank.isMiss();

                assertThat(actual).isTrue();
            }
        }

        @Nested
        class miss가아닌_rank가_주어진경우 {

            @ParameterizedTest
            @EnumSource(
                    value = Rank.class,
                    mode = EnumSource.Mode.EXCLUDE,
                    names = "MISS"
            )
            void false를_리턴한다(Rank rank) {
                boolean actual = rank.isMiss();

                assertThat(actual).isFalse();
            }
        }
    }
}
