package lotto.domain.strategy;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManualCreationStrategy extends LottoCreationStrategy {

    private final int price;

    public ManualCreationStrategy(int price) {
        this.price = price;
    }

    @Override
    public LottoTickets createLottoTickets() {
        int numberOfTicket = calculateLottoTicketCount(price);

        Scanner sc = new Scanner(System.in);
        System.out.println("수동으로 구매할 로또 수를 입력해주세요.");
        int manualLottoNumber = sc.nextInt();

        checkManualLottoNumber(numberOfTicket, manualLottoNumber);

        List<LottoTicket> manualLottoTickets = createManualLottoTickets(manualLottoNumber);
        LottoTickets lottoTickets  = LottoTickets.of(manualLottoTickets);
        createAutoLottoTickets(numberOfTicket, lottoTickets);

        return lottoTickets;
    }

    private void createAutoLottoTickets(final int numberOfTicket, final LottoTickets lottoTickets) {
        int autoLottoNumber = numberOfTicket - lottoTickets.size();

        if (autoLottoNumber > 0) {
            LottoTickets autoLottoTickets = LottoTickets.of(autoLottoNumber);
            lottoTickets.addLottoTickets(autoLottoTickets);
        }
    }

    protected List<LottoTicket> createManualLottoTickets(final int manualNumber) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> numbers = new ArrayList<List<Integer>>();

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        for (int i = 0; i < manualNumber; i++) {
            String input = sc.nextLine();
            numbers.add(toIntegerList(input));
        }

        return createManualLottoTickets(numbers);
    }

    private List<LottoTicket> createManualLottoTickets(final List<List<Integer>> numbers) {
        List<LottoTicket> manualLottoTickets = new ArrayList<LottoTicket>();

        for (List<Integer> number : numbers) {
            LottoTicket manualLottoTicket = LottoTicket.of(number);
            manualLottoTickets.add(manualLottoTicket);
        }
        return manualLottoTickets;
    }

    private void checkManualLottoNumber(final int numberOfTicket, final int manualLottoNumber) {
        if (manualLottoNumber > numberOfTicket) {
            throw new IllegalArgumentException("구매할 로또 개수가 보유한 금액보다 많습니다. manualNumber: " + manualLottoNumber);
        }
    }
}
