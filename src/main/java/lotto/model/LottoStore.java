package lotto.model;

public class LottoStore {

    private Order order;

    public LottoStore(Order order) {
        this.order = order;
    }

    public LottoResultMatcher buyAutoPick(Order order) {
//
//        List<PickNumbers> buyPickNumbers = new ArrayList<>();
//        for (int i = 0; i < order.getAvailableNumberToBuy(); i++) {
//            buyPickNumbers.add(new PickNumbers(NumbersGenerator.autoGenerate()));
//        }
//        return new LottoResultMatcher(buyPickNumbers);
        return null;
    }
}
