package edu.nextstep.step4.domain;

import edu.nextstep.step4.enums.Rank;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-lotto
 * create date  : 2019-06-28 15:55
 */
public class WinInfo {

    private Map<Lotto, Rank> winInfo;

    public WinInfo(Map<Lotto, Rank> winInfo) {
        this.winInfo = winInfo;
    }

    public Rank getRank(Lotto lotto) {
        return this.winInfo.get(lotto);
    }

    public boolean isRank(Lotto lotto, Rank rank) {
        return this.winInfo.get(lotto).equals(rank);
    }

    public Stream<Lotto> keySet() {
        return this.winInfo.keySet().stream();
    }

    public Stream<Rank> values() {
        return this.winInfo.values().stream();
    }

    protected Map<Lotto, Rank> getWinInfo() {
        return Collections.unmodifiableMap(this.winInfo);
    }
}
