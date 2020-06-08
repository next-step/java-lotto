package step2.domain;

import java.util.List;

public class LottoGameResult {

    private int firstPrizeCount;
    private int secondPrizeCount;
    private int thirdPrizeCount;
    private int forthPrizeCount;
    private int fifthPrizeCount;

    public LottoGameResult() {
        firstPrizeCount = 0;
        secondPrizeCount = 0;
        thirdPrizeCount = 0;
        forthPrizeCount = 0;
        fifthPrizeCount = 0;
    }

    public LottoGameResultDto getResult(List<UserLotto> lottos, WinningLotto winningLotto,
        UserPrice userPrice) {

        drawLottos(lottos, winningLotto);

        countPrize(lottos);

        return new LottoGameResultDto(
            userPrice.getEarningRate(lottos),
            firstPrizeCount,
            secondPrizeCount,
            thirdPrizeCount,
            forthPrizeCount,
            fifthPrizeCount);
    }

    private void countPrize(List<UserLotto> lottos) {
        firstPrizeCount = (int) lottos.stream()
            .filter(lotto -> lotto.getPrize() == Prize.FIRST.getGrade())
            .count();
        secondPrizeCount = (int) lottos.stream()
            .filter(lotto -> lotto.getPrize() == Prize.SECOND.getGrade())
            .count();
        thirdPrizeCount = (int) lottos.stream()
            .filter(lotto -> lotto.getPrize() == Prize.THIRD.getGrade())
            .count();
        forthPrizeCount = (int) lottos.stream()
            .filter(lotto -> lotto.getPrize() == Prize.FORTH.getGrade())
            .count();
        fifthPrizeCount = (int) lottos.stream()
            .filter(lotto -> lotto.getPrize() == Prize.FIFTH.getGrade())
            .count();
    }

    private void drawLottos(List<UserLotto> lottos, WinningLotto winningLotto) {
        lottos.stream().forEach(lotto -> lotto.setPrize(winningLotto));
        //for logging
        //lottos.stream().forEach(lotto -> System.out.println(lotto));
    }
}
