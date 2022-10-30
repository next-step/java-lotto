package step2.io;

import step2.lotto.OutputDevice;

import java.util.Collection;

public class ConsoleOutputDevice implements OutputDevice {
    @Override
    public <E> void printNumbers(Collection<E> collection) {
        System.out.println(collection);
    }

}
