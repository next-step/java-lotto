package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoMachine {

        public List<Ticket> buy(PurchaseAmount purchaseAmount) {
                return generateTickets(purchaseAmount);
        }

        private List<Ticket> generateTickets(PurchaseAmount purchaseAmount) {
                List<Ticket> generatedTicket = new ArrayList<>();
                long purchaseQuantity = purchaseAmount.calculatePurchaseQuantity();
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
}
