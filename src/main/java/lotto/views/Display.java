package lotto.views;

import lotto.Ticket;
import lotto.enums.Message;

public final class Display {

    public static void show(Message message) {
        System.out.println(message.toString());
    }

    public static void show(Message message, Number number) {
        System.out.println(String.format(message.toString(), number));
    }

    public static void show(Ticket ticket) {
        System.out.println(ticket);
    }

    public static void error(String message) {
        System.out.println(message);
    }
}
