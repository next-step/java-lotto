package my.project.lotto.domain;

import my.project.lotto.dto.LottoNumber;
import my.project.lotto.dto.Lottos;
import my.project.lotto.dto.Ranks;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created : 2020-11-30 오후 3:04
 * Developer : Seo
 */
public class WinningLotto {
    private final Ranks ranks;

    public WinningLotto(Lottos lottos, Lotto lastWinningLotto, LottoNumber bonusNumber) {
        this.ranks = new Ranks(new ArrayList<>());
        for (Lotto lotto : lottos.getLottos()) {
            ranks.add(Rank.rank(lotto.count(lastWinningLotto), lotto.contains(bonusNumber)));
        }
    }

    public int countFifthRanks() {
        return (int) ranks.getRanks().stream()
                .filter(rank -> rank.equals(Rank.FIFTH)).count();
    }

    public int countFourthRanks() {
        return (int) ranks.getRanks().stream()
                .filter(rank -> rank.equals(Rank.FOURTH)).count();
    }

    public int countThirdRanks() {
        return (int) ranks.getRanks().stream()
                .filter(rank -> rank.equals(Rank.THIRD)).count();
    }

    public int countSecondRanks() {
        return (int) ranks.getRanks().stream()
                .filter(rank -> rank.equals(Rank.SECOND)).count();
    }

    public int countFirstRanks() {
        return (int) ranks.getRanks().stream()
                .filter(rank -> rank.equals(Rank.FIRST)).count();
    }

    public String profit() {
        DecimalFormat format = new DecimalFormat("#.##");
        return format.format((double) ((Rank.FIRST.getPrize() * countFirstRanks())
                + (Rank.SECOND.getPrize() * countSecondRanks())
                + (Rank.THIRD.getPrize() * countThirdRanks())
                + (Rank.FOURTH.getPrize() * countFourthRanks())
                + (Rank.FIFTH.getPrize() * countFifthRanks()))
                / (ranks.size() * Money.PRICE));
    }
}
