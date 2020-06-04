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
        UserPrice userPrice) {
        drawLottos(lottos, winningLotto.getLottoNumbers());

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

    private void drawLottos(List<UserLotto> lottos, List<Integer> winningNumbers) {
        lottos.stream().forEach(lotto -> lotto.setPrize(winningNumbers));
        //for logging
        //lottos.stream().forEach(lotto -> System.out.println(lotto));
    }
}
