 package study.lotto.step2.presentation;

import study.lotto.step2.domain.Lottos;

public class LottosInformation {
    private final Lottos lottos;

    public LottosInformation(Lottos lottos) {
        this.lottos = lottos;
    }

    public void printInformation() {
        printNumberOfPurchase();
        printSelectedNumbersOf();
        consoleLineBreak();
    }

    private void printNumberOfPurchase() {
        System.out.println(lottos.numberOfPurchase() + "개를 구매했습니다.");
    }

    private void printSelectedNumbersOf() {
        lottos.selectedNumbers().forEach(System.out::println);
    }

    private void consoleLineBreak() {
        System.out.println();
    }
}
