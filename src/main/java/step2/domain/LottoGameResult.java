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

        this.earningRate = getEarningRate();
        countPrize();

        return new LottoGameResultDto(
            earningRate,
            firstPrizeCount,
            secondPrizeCount,
            thirdPrizeCount,
            forthPrizeCount);
    }

    private void countPrize() {
        this.firstPrizeCount = (int) this.lottos.stream()
            .filter(lotto -> lotto.getPrize() == Prize.FIRST.getGrade())
            .count();
        this.secondPrizeCount = (int) this.lottos.stream()
            .filter(lotto -> lotto.getPrize() == Prize.SECOND.getGrade())
            .count();
        this.thirdPrizeCount = (int) this.lottos.stream()
            .filter(lotto -> lotto.getPrize() == Prize.THIRD.getGrade())
            .count();
        this.forthPrizeCount = (int) this.lottos.stream()
            .filter(lotto -> lotto.getPrize() == Prize.FORTH.getGrade())
            .count();
    }

    private void setCashPrize() {
        this.lottos.stream().forEach(lotto -> this.cashPrize += lotto.getCashPrice());
    }

    private double getEarningRate() {
        setCashPrize();
        return (double) this.cashPrize / this.userPrice.getPrice();
    }

    private void drawLottos(List<Integer> winningNumbers) {
        lottos.stream().forEach(lotto -> lotto.setPrize(winningNumbers));
        //for logging
        //lottos.stream().forEach(lotto -> System.out.println(lotto));
    }
}
