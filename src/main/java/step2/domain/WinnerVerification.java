package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class WinnerVerification {
    public static List<WinningInformation> getWinnerVerified(WinnersNo winnersNo, List<Lotto> lotto) {
        List<WinningInformation> winningInformation = new ArrayList<>();
        int round = 1;
        for (Lotto l : lotto) {
            int hitNumber = hasNumber(winnersNo, l.getLotteryInfo());
            addWinningInfos(winningInformation, round, hitNumber);
            round++;
        }
        return winningInformation;
    }

    private static void addWinningInfos(List<WinningInformation> winningInformation, int round, int hitNumber) {
        if (hitNumber > 2) {
            winningInformation.add(new WinningInformation(round, hitNumber));
        }
    }

    public static int hasNumber(WinnersNo winnersNo, List<Integer> lotteryInfo) {
        int hitNumbers = 0;
        for (int number : winnersNo.getWinnersResultNos()) {
            hitNumbers = lotteryInfo.contains(number) ? ++hitNumbers : hitNumbers;
        }
        return hitNumbers;
    }
}


