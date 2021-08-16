package edu.nextstep.lottoauto.manager;

import edu.nextstep.lottoauto.domain.Ticket;
import edu.nextstep.lottoauto.exception.NumbersIllegalArgumentException;
import edu.nextstep.lottoauto.exception.PaymentIllegalArgumentException;
import edu.nextstep.lottoauto.form.WinningResultForm;
import edu.nextstep.lottoauto.machine.TicketMachine;
import edu.nextstep.lottoauto.ticketmaker.TicketMaker;

import java.util.ArrayList;
import java.util.List;

public class TicketManager {

    private static final int A_UNIT_PRICE = 1_000;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBER_OF_NUMBERS = 6;

    private final TicketMachine ticketMachine = new TicketMachine();

    public void createAndSaveTickets(int payment, TicketMaker ticketMaker) {
        validateUnderAUnitPrice(payment);
        validateDivideUnitPrice(payment);

        int numberOfTickets = calculateNumberOfTicketsFrom(payment);
        ticketMachine.createAndSaveTickets(numberOfTickets, ticketMaker);
    }

    public List<Ticket> findTickets() {
        return ticketMachine.findTickets();
    }

    public WinningResultForm confirmWinningResult(String winningNumbersString) {
        List<Integer> winningNumbers = createNumbersFromString(winningNumbersString);

        validateNumberOfNumbers(winningNumbers);
        validateOutOfRange(winningNumbers);

        return ticketMachine.confirmWinningResult(winningNumbers);
    }

    public int calculateNumberOfTicketsFrom(int payment) {
        return payment / A_UNIT_PRICE;
    }

    private List<Integer> createNumbersFromString(String numbersString) {
        List<Integer> numbers = new ArrayList<>();

        String[] numbersStringArr = numbersString.split(",");

        for(String numberString : numbersStringArr) {
            numbers.add(Integer.parseInt(numberString.trim()));
        }

        return numbers;
    }

    private void validateUnderAUnitPrice(int payment) {
        if (payment < A_UNIT_PRICE) {
            throw new PaymentIllegalArgumentException("최소 입력 가능 금액 미달. 최소 입력 금액 : " + A_UNIT_PRICE + " 원");
        }
    }

    private void validateDivideUnitPrice(int payment) {
        if ((payment % A_UNIT_PRICE) != 0) {
            throw new PaymentIllegalArgumentException("개 당 금액 " + A_UNIT_PRICE + " 원으로 해당 단위로 입력 필요.");
        }
    }

    public void validateNumberOfNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != NUMBER_OF_NUMBERS) {
            throw new NumbersIllegalArgumentException("입력 숫자 개수 미달 or 초과. 지정 개수 : " + NUMBER_OF_NUMBERS);
        }
    }

    private void validateOutOfRange(List<Integer> winningNumbers) {
        if (winningNumbers.get(0) < MIN_NUMBER || winningNumbers.get(winningNumbers.size() - 1) > MAX_NUMBER) {
            throw new NumbersIllegalArgumentException("지정 가능 숫자 범위 초과. 범위 : " + MIN_NUMBER + " ~ " + MAX_NUMBER);        }
    }
}
