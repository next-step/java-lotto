package lotto.model;

public class LottoStore {

    private Order order;
    private Lottos lottos;

    public LottoStore(Order order, Lottos handPickLottos) {
        this.order = order;
        this.lottos = handPickLottos;
        verifyHanPickCountLimit();
    }

    public Lottos buyAutoPick() {
        for (int i = 0; i < order.getAutoPickCount(); i++) {
            lottos.add(new PickNumbers(NumbersGenerator.autoGenerate()));
        }
        return this.lottos;
    }
    private void verifyHanPickCountLimit() {
        if(this.order.getHandPickCount() < this.lottos.getPickNumbers().size()) {
            throw new IllegalArgumentException("주문 보다 더 많은 숫자를 입력할 수 없습니다.");
        }
    }
}
