package rankingtwolotto.domain;

import rankingtwolotto.rankingexception.ExceptionCommand;
import rankingtwolotto.rankingexception.RankingValueException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoWinning {

    public static List<Integer> LottoResult(Lotto winningLotto, Lottos purchaseLottos, LottoNumber bonusBallNumber) {
        List<Integer> matchedLottoCnt = MatchLottos(winningLotto, purchaseLottos, bonusBallNumber);
        int totalAmount = 0;
        for (int i = 3; i < matchedLottoCnt.size(); i++) {
            LottoRanking lottoRanking = matchedLottoCnt.get(i) > 0 ? LottoRanking.rankingResult(i) : LottoRanking.rankingResult(0);
            totalAmount += lottoRanking.getCompensation();
        }
        matchedLottoCnt.add(matchedLottoCnt.size(), totalAmount);

        return matchedLottoCnt;
    }

    private static List<Integer> MatchLottos(Lotto winningLotto, Lottos purchaseLottos, LottoNumber bonusBallNumber) {
        List<Integer> matchingLottos;
        List<Integer> matchedLottoCnt = IntStream.of(new int[8]).boxed().collect(Collectors.toList());

        matchingLottos = winningLotto.getLotto().stream().map(LottoNumber::getLottoNumber).collect(Collectors.toList());
        matchingLottos.add(bonusBallNumber.getLottoNumber());
        if (matchingLottos.size() != matchingLottos.stream().distinct().count()) {
            throw new RankingValueException(ExceptionCommand.LOTTO_DUPLICATION_EXCEPTION_MESSAGE);
        }

        for (Lotto purchaseLotto : purchaseLottos.getLottos()) {
            int matchLotto = MatchWinningNumber(matchingLottos, purchaseLotto);
            matchedLottoCnt.set(matchLotto, matchedLottoCnt.get(matchLotto) + 1);
        }
        return matchedLottoCnt;
    }

    private static int MatchWinningNumber(List<Integer> matchingLottos, Lotto purchaseLotto) {
        List<Integer> matchingLotto = new ArrayList<>(matchingLottos.subList(0, 6));
        int matchingNumber = 0;
        boolean bonusBallMatch = false;
        for (LottoNumber purchaseNumber : purchaseLotto.getLotto()) {
            matchingNumber = (matchingLotto.contains(purchaseNumber.getLottoNumber())) ? matchingNumber + 1 : matchingNumber;
            bonusBallMatch = matchingLottos.get(6).equals(purchaseNumber.getLottoNumber());
        }
        if (matchingNumber == 5) {
            matchingNumber = bonusBallMatch ? 7 : matchingNumber;
        }
        return matchingNumber;
    }
}
