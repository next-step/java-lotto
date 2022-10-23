package step2.lotto;

import java.util.Set;

public interface OutputView<E> {

    void print(Set<E> set);

    class Fake<E> implements OutputView<E> {
        @Override
        public void print(Set<E> set) {
            System.out.println("출력기 API 호출 성공");
        }
    }

}
