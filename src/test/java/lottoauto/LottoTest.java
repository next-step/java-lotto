package lottoauto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    @Test
    void Lotto_자동생성_1개() {
        Lotto auto = Lotto.createAuto();
        System.out.println(auto);
        assertThat(auto).isNotNull();
    }

    @Test
    void Lotto_생성_1개() {
        String[] numbers = new String[]{"1", "2", "3", "4", "5", "6"};
        Lotto lotto = Lotto.from(numbers);
        assertThat(lotto).isNotNull();
    }

    @Test
    void Lotto_생성_1개_사이즈_에러() {
        String[] numbers = new String[]{"1", "2", "3", "4", "5"};
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Lotto.from(numbers);
        }).withMessageContaining("로또 번호를 입력해야 합니다.");
    }

    @Test
    void Lotto_생성_1개_중복포함_에러() {
        String[] numbers = new String[]{"1", "2", "3", "5", "5", "5"};
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Lotto.from(numbers);
        }).withMessageContaining("중복된 번호가 존재합니다.");
    }
}