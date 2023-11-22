package lotto.domain;

public class PurchaseAmount implements Comparable<PurchaseAmount> {

        private static final int LOTTO_TICKET_PRICE = 1_000;

        private final long value;

        private PurchaseAmount(long value) {
                this.value = value;
        }

        public long value() {
                return value;
        }

        public static PurchaseAmount createPurchaseAmountOfScanned(long totalAmount) {
                validatePurchaseAmount(totalAmount);
                return new PurchaseAmount(totalAmount);
        }

        public static PurchaseAmount createPurchaseAmountOfAutoOnly(PurchaseAmount totalAmount) {
                return totalAmount;
        }

        public static PurchaseAmount extractManualAmountFromTotal(PurchaseAmount totalAmount, int countOfManualTicket) {
                long purchaseAmountOfManual = (long) countOfManualTicket * LOTTO_TICKET_PRICE;
                validateAmountOfManualTicket(totalAmount, purchaseAmountOfManual);
                return new PurchaseAmount(purchaseAmountOfManual);
        }

        public static PurchaseAmount extractAutoAmountFromTotal(PurchaseAmount totalAmount,
            PurchaseAmount amountOfManualTickets) {
                long purchaseAmountOfAuto = totalAmount.subtract(amountOfManualTickets);
                if (isNotAvailableToBuyAuto(purchaseAmountOfAuto)) {
                        return new PurchaseAmount(0);
                }
                return new PurchaseAmount(purchaseAmountOfAuto);
        }

        public long calculateNetPurchaseAmount(Tickets tickets) {
                return (long) tickets.getCountOfTickets() * LOTTO_TICKET_PRICE;
        }

        public long calculatePurchaseQuantity() {
                return value / LOTTO_TICKET_PRICE;
        }

        @Override
        public int compareTo(PurchaseAmount o) {
                return (int) (this.value - o.value);
        }

        private long subtract(PurchaseAmount o) {
                return this.value - o.value;
        }

        private static void validatePurchaseAmount(long purchaseAmount) {
                if (purchaseAmount < LOTTO_TICKET_PRICE) {
                        throw new IllegalArgumentException("1000원 이상 입력하셔야합니다. (로또 장당 1000원)");
                }
        }

        private static void validateAmountOfManualTicket(PurchaseAmount totalAmount, long purchaseAmountOfManual) {
                if (totalAmount.value < purchaseAmountOfManual) {
                        throw new IllegalArgumentException("구매 가능한 수동 로또 갯수를 초과하였습니다. (로또 장당 1000원)");
                }
        }

        private static boolean isNotAvailableToBuyAuto(long purchaseAmountOfAuto) {
                return purchaseAmountOfAuto < 1000;
        }
}
