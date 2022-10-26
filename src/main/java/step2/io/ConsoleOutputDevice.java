package step2.io;

import step2.lotto.OutputDevice;

import java.util.Set;

public class ConsoleOutputDevice implements OutputDevice {
    @Override
    public void printNumbers(Set set) {
        System.out.println(set);
    }

}
