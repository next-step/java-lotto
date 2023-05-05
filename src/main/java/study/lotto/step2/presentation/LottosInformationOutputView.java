 package study.lotto.step2.presentation;

import study.lotto.step2.domain.Lottos;

public class LottosInformationOutputView {
    private final Lottos lottos;

    public LottosInformationOutputView(Lottos lottos) {
        this.lottos = lottos;
    }

    public void printInformation() {
        printNumberOfPurchase();
        printSelectedNumbersOf();
        consoleLineBreak();
    }

    private void printNumberOfPurchase() {
        System.out.println(lottos.size() + "개를 구매했습니다.");
    }

    private void printSelectedNumbersOf() {
        lottos.getLottos().forEach(System.out::println);
    }

    private void consoleLineBreak() {
        System.out.println();
    }
}
