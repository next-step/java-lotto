package step2step3.io;

import step2step3.lotto.lottoTicket.OutputDevice;

import java.util.Collection;

public class ConsoleOutputDevice implements OutputDevice {
    @Override
    public <E> void printNumbers(Collection<E> collection) {
        System.out.println(collection);
    }

}
