package step2.domain;

import java.util.List;

public class LottoGameResult {

    private int firstPrizeCount;
    private int secondPrizeCount;
    private int thirdPrizeCount;
    private int forthPrizeCount;

    public LottoGameResult() {
        firstPrizeCount = 0;
        secondPrizeCount = 0;
        thirdPrizeCount = 0;
        forthPrizeCount = 0;
    }

    public LottoGameResultDto getResult(List<UserLotto> lottos, Lotto winningLotto,
        UserPrice userPrice, int bonusNumber) {
        drawLottos(lottos, winningLotto.getLottoNumbers(), bonusNumber);

        countPrize(lottos);

        return new LottoGameResultDto(
            userPrice.getEarningRate(lottos),
            firstPrizeCount,
            secondPrizeCount,
            thirdPrizeCount,
            forthPrizeCount);
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
    }

    private void drawLottos(List<UserLotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        lottos.stream().forEach(lotto -> lotto.setPrize(winningNumbers, bonusNumber));
        //for logging
        lottos.stream().forEach(lotto -> System.out.println(lotto));
    }
}
