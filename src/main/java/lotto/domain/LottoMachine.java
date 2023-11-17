package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoMachine {

        private static final int LOTTO_TICKET_PRICE = 1_000;
        private static final Random random = new Random();

        public List<Ticket> buy(long purchaseAmount) {
                validatePurchaseAmount(purchaseAmount);
                return generateTickets(purchaseAmount);
        }

        private List<Ticket> generateTickets(long purchaseAmount) {
                List<Ticket> generatedTicket = new ArrayList<>();
                long purchaseQuantity = calculatePurchaseQuantity(purchaseAmount);
                for (int i = 0; i < purchaseQuantity; i++) {
                        generatedTicket.add(new Ticket(new LottoNumbers(generateLottoNumbers())));
                }
                return generatedTicket;
        }

        private Set<Integer> generateLottoNumbers() {
                Set<Integer> lottoNumbers = new HashSet<>();
                while (lottoNumbers.size() != 6) {
                        lottoNumbers.add(random.nextInt(45) + 1);
                }
                return lottoNumbers.stream().collect(Collectors.toSet());
        }

        private long calculatePurchaseQuantity(long purchaseAmount) {
                return purchaseAmount / LOTTO_TICKET_PRICE;
        }

        private void validatePurchaseAmount(long purchaseAmount) {
                if (purchaseAmount < LOTTO_TICKET_PRICE) {
                        throw new IllegalArgumentException("1000원 이상 입력하셔야합니다. (로또 장당 1000원)");
                }
        }
}
