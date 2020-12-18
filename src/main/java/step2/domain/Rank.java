package step2.domain;

import step2.domain.dto.LottoResultDto;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.*;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

    private long countOfMatch;
    private int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public long getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank getRank(LottoResultDto lottoResultDto) {
        return rebuildRanksForBonusNumber(lottoResultDto).stream()
                .filter(rank -> rank.getCountOfMatch() == lottoResultDto.getCountOfMatch())
                .findFirst()
                .orElse(MISS); // Optional 이용
    }

    private static List<Rank> rebuildRanksForBonusNumber(LottoResultDto lottoResultDto) {
        List<Rank> ranks = new ArrayList<>(asList(Rank.values()));

        // 보너스 숫자 여부로 순위를 재가공 한다
       if (lottoResultDto.isIncludedBonusNumber()) {
            ranks.remove(THIRD); // 보너스 숫자를 가졌으면, 번호 5개일치 상황때 2등이 된다
            return ranks;
        }
        ranks.remove(SECOND); // 보너스 숫자를 안 가졌으면, 번호 5개일치 상황때 3등이 된다
        return ranks;
    }
}
