package lotto.model;

public class LottoStore {

    private Order order;
    private Lottos lottos;

    public LottoStore(Order order, Lottos handPickLottos) {
        verifyHanPickCountLimit(order, handPickLottos);
        this.order = order;
        this.lottos = handPickLottos;
    }

    public Lottos buyAutoPick() {
        NumbersGenerator numbersGenerator = new NumbersGenerator();
        for (int i = 0; i < order.autoPickCount(); i++) {
            lottos.add(new PickNumbers(numbersGenerator.autoGenerate()));
        }
        return this.lottos;
    }

    private void verifyHanPickCountLimit(Order order, Lottos handPickLottos) {
        if (order.isAvailable(handPickLottos)) {
            throw new IllegalArgumentException("주문 보다 더 많은 숫자를 입력할 수 없습니다.");
        }
    }
}
