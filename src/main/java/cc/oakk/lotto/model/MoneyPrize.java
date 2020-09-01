package cc.oakk.lotto.model;

import cc.oakk.lotto.view.printer.Printer;

public class MoneyPrize extends LottoPrize<Long> {
    public MoneyPrize(Long prize) {
        super(prize, prize);
    }

    @Override
    public void print(Printer<LottoPrize<Long>> printer) {
        printer.print(this);
    }

    @Override
    public String toString() {
        return prize + "원";
    }
}
