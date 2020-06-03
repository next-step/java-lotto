package step2.domain;

import java.util.List;

public class LottoGameResult {

    private List<Lotto> lottos;
    private WinningLotto winningLotto;
    private int cashPrize;
    private UserPrice userPrice;
    private double earningRate;
    private int firstPrizeCount;
    private int secondPrizeCount;
    private int thirdPrizeCount;
    private int forthPrizeCount;

    public LottoGameResult(List<Lotto> lottos, WinningLotto winningLotto, UserPrice userPrice) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
        this.cashPrize = 0;
        this.userPrice = userPrice;
    }

    public LottoGameResultDto getResult() {
        drawLottos(winningLotto.getLottoNumbers());

        earningRate = getEarningRate();
        countPrize();

        return new LottoGameResultDto(
            earningRate,
            firstPrizeCount,
            secondPrizeCount,
            thirdPrizeCount,
            forthPrizeCount);
    }

    private void countPrize() {
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

    private void setCashPrize() {
        lottos.stream().forEach(lotto -> cashPrize += lotto.getCashPrice());
    }

    private double getEarningRate() {
        setCashPrize();
        return (double) cashPrize / userPrice.getPrice();
    }

    private void drawLottos(List<Integer> winningNumbers) {
        lottos.stream().forEach(lotto -> lotto.setPrize(winningNumbers));
        //for logging
        //lottos.stream().forEach(lotto -> System.out.println(lotto));
    }
}
