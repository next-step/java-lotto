package step2.lotto;

import java.util.Set;

public interface OutputDevice {

    void printNumbers(Set set);

    class Fake implements OutputDevice {

        @Override
        public void printNumbers(Set set) {
            System.out.println("출력기 API 호출 성공");
        }

    }

}
