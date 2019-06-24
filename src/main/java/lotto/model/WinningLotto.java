package lotto.model;

import java.util.Arrays;
import java.util.Objects;

public class WinningLotto {
    private final Lotto lotto;
    private final Number number;

    public WinningLotto(Lotto lotto, Number number) {
        this.lotto = lotto;
        this.number = number;
    }

    public static WinningLotto generate(Lotto lotto, Number number) {
        return new WinningLotto(lotto, number);
    }

    public Prize getResultOf(Lotto lotto) {
        int count = this.lotto.getMatchCount(lotto);
        boolean existBonus = (lotto.hasBonus(number));

        return Arrays.stream(Prize.values())
                .filter(prize -> {
                    if(Prize.SECOND == prize) {
                        return prize.getMatchCount() == count && existBonus;
                    }
                    return prize.getMatchCount() == count;
                })
                .findFirst()
                .orElse(Prize.NONE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(lotto, that.lotto) &&
                Objects.equals(number, that.number);
    }


    @Override
    public int hashCode() {
        return Objects.hash(lotto, number);
    }

    @Override
    public String toString() {
        return "WinningLotto{" +
                "lotto=" + lotto +
                ", number=" + number +
                '}';
    }
}
