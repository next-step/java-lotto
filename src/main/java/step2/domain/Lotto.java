package step2.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int MAX_SIZE = 6;
    private static final int RANDOM_NUMBER_ORIGIN = 1;
    private static final int RANDOM_NUMBER_BOUND = 46;

    private static List<Integer> lotteryInfo;

    private Lotto(List<Integer> lotteryInfo) {
        this.lotteryInfo = lotteryInfo;
    }

    public static Lotto ofLotto() {
        List<Integer> lottoNumbers = getRandomNos();
        return new Lotto(lottoNumbers);
    }

    public static Lotto ofLottoByDesignatedRange(int start, int end) {
        List<Integer> lottoNumbers = getLottoNos(start, end);
        return new Lotto(lottoNumbers);
    }

    static List<Integer> getLottoNos(int start, int end) {
        IntStream intStream = new Random().ints(start, end);
        return intStream.distinct()
                .limit(MAX_SIZE)
                .sorted()
                .boxed()
                .collect(Collectors.toList());
    }

    static List<Integer> getRandomNos() {
        return getLottoNos(RANDOM_NUMBER_ORIGIN, RANDOM_NUMBER_BOUND);
    }

    public List<Integer> getLotteryInfo() {
        return lotteryInfo;
    }

    @Override
    public String toString() {
        return this.lotteryInfo.stream().map(String::valueOf)
                               .collect(Collectors.joining(","));
    }

    public static Scores addWinningInfos(WinnersNo winnersNo) {
        int hitNumber = hasNumber(winnersNo);
        boolean hasBonusNumber = hasBonusNumber(hitNumber, winnersNo.getBonusNumber());
        return hitNumber > 2 ? new Scores(hitNumber, hasBonusNumber) : null;
    }

    private static int hasNumber(WinnersNo winnersNo) {
        int hitNumbers = 0;
        for (int number : winnersNo.getWinnersResultNos()) {
            hitNumbers = lotteryInfo.contains(number) ? ++hitNumbers : hitNumbers;
        }
        return hitNumbers;
    }

    private static boolean hasBonusNumber(int hitNumbers, int BonusNumber) {
        return hitNumbers == 5 && lotteryInfo.contains(BonusNumber);
    }
}
