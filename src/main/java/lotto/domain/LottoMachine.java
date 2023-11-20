package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoMachine {

        private static final int LOTTO_TICKET_PRICE = 1_000;

        public List<Ticket> buy(long purchaseAmount) {
                validatePurchaseAmount(purchaseAmount);
                return generateTickets(purchaseAmount);
        }

        public long getPurchaseAmount(Tickets tickets) {
                return (long) tickets.getCountOfTickets() * LOTTO_TICKET_PRICE;
        }

        private List<Ticket> generateTickets(long purchaseAmount) {
                List<Ticket> generatedTicket = new ArrayList<>();
                long purchaseQuantity = calculatePurchaseQuantity(purchaseAmount);
                for (int i = 0; i < purchaseQuantity; i++) {
                        generatedTicket.add(new Ticket(new LottoNumbers(generateLottoNumbers())));
                }
                return generatedTicket;
        }

        private Set<LottoNumber> generateLottoNumbers() {
                List<LottoNumber> lottoNumbers = LottoNumberCandidatesFactory.getInstance();
                Collections.shuffle(lottoNumbers);
                lottoNumbers = lottoNumbers.subList(0, 6);
                return new HashSet<>(lottoNumbers);
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
