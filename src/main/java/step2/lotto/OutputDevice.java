package step2.lotto;

import java.util.Collection;

public interface OutputDevice {

    <E> void printNumbers(Collection<E> collection);

    class Fake implements OutputDevice {

        @Override
        public <E> void printNumbers(Collection<E> collection) {
            System.out.println("출력기 API 호출 성공");
        }

    }

}
