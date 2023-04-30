 package study.lotto.step2.presentation;

import study.lotto.step2.domain.SoldLottos;

public class SoldLottosInformation {
    private final SoldLottos soldLottos;

    public SoldLottosInformation(SoldLottos soldLottos) {
        this.soldLottos = soldLottos;
    }

    public void printInformation() {
        printNumberOfPurchase();
        printSelectedNumbersOf();
        consoleLineBreak();
    }

    private void printNumberOfPurchase() {
        System.out.println(soldLottos.numberOfPurchase() + "개를 구매했습니다.");
    }

    private void printSelectedNumbersOf() {
        soldLottos.selectedNumbers().forEach(System.out::println);
    }

    private void consoleLineBreak() {
        System.out.println();
    }
}
