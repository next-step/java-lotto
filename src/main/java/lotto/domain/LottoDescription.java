package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum LottoDescription {
    NOMATCH(0, true, "NOMATCH", 0),
    MATCH3(3, false, "MATCH3", 5000),
    MATCH4(4, false, "MATCH4", 50000),
    MATCH5(5, false, "MATCH5", 150000),
    MATCHBONUS(5, true, "MATCHBONUS", 30000000),
    MATCH6(6, false, "MATCH6", 2000000000);

    private final int matchCount;
    private final boolean isBonusNumber;
    private final String hash;
    private final int winning;

    LottoDescription(int matchCount, boolean isBonusNumber, String hash, int winning) {
        this.matchCount = matchCount;
        this.isBonusNumber = isBonusNumber;
        this.hash = hash;
        this.winning = winning;
    }

    public static String findLottoHash(int matchCount, boolean isBonusNumber) {
        return Arrays.stream(values())
            .filter(lottoResult -> lottoResult.matchCount == matchCount)
            .filter(lottoResult -> lottoResult.isBonusNumber == isBonusNumber)
            .findAny()
            .orElse(NOMATCH)
            .hash;
    }

    public String getHash() {
        return hash;
    }

    public int getWinning() {
        return this.winning;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusNumber() {
        return isBonusNumber;
    }

    public static List<LottoDescription> toList() {
        return Arrays.asList(
            LottoDescription.MATCH3,
            LottoDescription.MATCH4,
            LottoDescription.MATCH5,
            LottoDescription.MATCHBONUS,
            LottoDescription.MATCH6
        );
    }
}
