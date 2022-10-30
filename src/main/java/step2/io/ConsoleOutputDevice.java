package step2.io;

import step2.lotto.OutputDevice;

import java.util.Collection;
import java.util.List;

public class ConsoleOutputDevice implements OutputDevice {
    @Override
    public void printNumbers(Collection collection) {
        System.out.println(collection);
    }

}
