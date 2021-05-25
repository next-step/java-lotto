package lotto.views;

import lotto.domains.Tickets;
import lotto.enums.Message;
import lotto.domains.EarningRate;

public final class Display {

    public static void show(Message message) {
        System.out.println(message.toString());
    }

    public static void show(Message message, Number number) {
        System.out.println(String.format(message.toString(), number));
    }

    public static void show(Message message, EarningRate earningRate) {
        System.out.println(String.format(message.toString(), earningRate));
    }

    public static void show(Tickets tickets) {
        System.out.println(tickets.print());
    }

    public static void error(String message) {
        System.out.println(message);
    }
}
