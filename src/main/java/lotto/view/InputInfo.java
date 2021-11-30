package lotto.view;

public class InputInfo {

    private static final String ERR_MESSAGE_NUMBER_FORMAT = "숫자형식 입력값이 아닙니다.";
    private static final String MESSAGE_TICKET_COUNT = "%d개를 구입하였습니다.";
    private static final int TICKET_PRICE = 1000;

    private final int ticketCount;

    public InputInfo(String price) {

        try {
            int ticketPrice = Integer.parseInt(price);
            this.ticketCount = ticketPrice / TICKET_PRICE;
            System.out.println(String.format(MESSAGE_TICKET_COUNT, this.ticketCount));
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERR_MESSAGE_NUMBER_FORMAT);
        }
    }

    public int getTicketCount() {
        return ticketCount;
    }
}
