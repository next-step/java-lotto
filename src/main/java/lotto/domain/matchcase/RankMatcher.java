package lotto.domain.matchcase;

import lotto.domain.Rank;

public class RankMatcher {

    public static void gradeMatcher(int matchCount, boolean bonusBall) {
        Case lottoCase = null;
        firstCase(matchCount, lottoCase);
        secondAndThirdCase(matchCount, bonusBall, lottoCase);
        forthCase(matchCount, lottoCase);
        fifthCase(matchCount, lottoCase);
    }

    private static boolean firstCase(int matchCount, Case lottoCase) {
        if (matchCount == Rank.FIRST.getMatchCount()) {
            lottoCase = new First();
            lottoCase.addMatchCount();
            return true;
        }
        return false;
    }

    private static boolean secondAndThirdCase(int matchCount, boolean bonusBall, Case lottoCase) {
        if (matchCount == Rank.THIRD.getMatchCount()) {
            checkBonusBall(lottoCase, bonusBall);
            return true;
        }
        return false;
    }

    private static boolean forthCase(int matchCount, Case lottoCase) {
        if (matchCount == Rank.FORTH.getMatchCount()) {
            lottoCase = new Forth();
            lottoCase.addMatchCount();
            return true;
        }
        return false;
    }

    private static void fifthCase(int matchCount, Case lottoCase) {
        if (matchCount == Rank.FIFTH.getMatchCount()) {
            lottoCase = new Fifth();
            lottoCase.addMatchCount();
        }
    }

    private static void checkBonusBall(Case lottoCase, boolean bonusBall) {
        if (bonusBall) {
            lottoCase = new Second();
            lottoCase.addMatchCount();
            return;
        }
        lottoCase = new Third();
        lottoCase.addMatchCount();
    }

}
