package lotto.domain;

public class PurchaseAmount {

        private static final int LOTTO_TICKET_PRICE = 1_000;

        private final long value;

        public PurchaseAmount(long value) {
                validatePurchaseAmount(value);
                this.value = value;
        }

        public long getNetPurchaseAmount(Tickets tickets) {
                return (long) tickets.getCountOfTickets() * LOTTO_TICKET_PRICE;
        }

        public long calculatePurchaseQuantity() {
                return value / LOTTO_TICKET_PRICE;
        }

        private void validatePurchaseAmount(long purchaseAmount) {
                if (purchaseAmount < LOTTO_TICKET_PRICE) {
                        throw new IllegalArgumentException("1000원 이상 입력하셔야합니다. (로또 장당 1000원)");
                }
        }
}
