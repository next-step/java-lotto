package step2.lotto;

import java.util.Collection;

public interface OutputDevice {

    void printNumbers(Collection collection);

    class Fake implements OutputDevice {

        @Override
        public void printNumbers(Collection collection) {
            System.out.println("출력기 API 호출 성공");
        }

    }

}
