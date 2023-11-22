package lotto.domain;

import static lotto.domain.PurchaseAmount.createPurchaseAmountOfAutoOnly;
import static lotto.domain.PurchaseAmount.extractAutoAmountFromTotal;
import static lotto.domain.PurchaseAmount.extractManualAmountFromTotal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoMachine {

        public Tickets buyOnlyAutoTickets(PurchaseAmount totalPurchaseAmount) {
                return new Tickets(generateAutoTickets(createPurchaseAmountOfAutoOnly(totalPurchaseAmount)));
        }

        public Tickets buyAutoAndManualTickets(PurchaseAmount totalPurchaseAmount,
            List<LottoNumbers> manualLottoNumbers) {
                PurchaseAmount purchaseAmountOfManualTickets = extractManualAmountFromTotal(totalPurchaseAmount,
                    manualLottoNumbers.size());
                PurchaseAmount purchaseAmountOfAutoTickets = extractAutoAmountFromTotal(totalPurchaseAmount,
                    purchaseAmountOfManualTickets);
                List<Ticket> autoTickets = generateAutoTickets(purchaseAmountOfAutoTickets);
                List<Ticket> manualAndAutoTickets = generateManualTickets(manualLottoNumbers);
                manualAndAutoTickets.addAll(autoTickets);
                return new Tickets(manualAndAutoTickets);
        }

        private List<Ticket> generateAutoTickets(PurchaseAmount purchaseAmount) {
                List<Ticket> generatedTicket = new ArrayList<>();
                long purchaseQuantity = purchaseAmount.calculatePurchaseQuantity();
                for (int i = 0; i < purchaseQuantity; i++) {
                        generatedTicket.add(new Ticket(new LottoNumbers(Set.copyOf(generateAutoLottoNumbers()))));
                }
                return generatedTicket;
        }

        private List<LottoNumber> generateAutoLottoNumbers() {
                List<LottoNumber> lottoNumbers = LottoNumberCandidatesFactory.getInstance();
                Collections.shuffle(lottoNumbers);
                lottoNumbers = lottoNumbers.subList(0, 6);
                return new ArrayList<>(lottoNumbers);
        }

        private List<Ticket> generateManualTickets(List<LottoNumbers> manualLottoNumbers) {
                return manualLottoNumbers.stream().map(Ticket::new).collect(Collectors.toList());
        }
}
