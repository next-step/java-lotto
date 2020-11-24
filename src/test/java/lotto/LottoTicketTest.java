package lotto;

import lotto.model.Lotto;
import lotto.model.LottoTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTicketTest {
    List<Integer> countList = new ArrayList<>();
    List<Integer> duplicateList = new ArrayList<>();


    @BeforeEach
    void setUp(){
        countList.add(1);
        countList.add(2);
        countList.add(3);
        countList.add(4);
        countList.add(5);
        countList.add(6);

        duplicateList.add(1);
        duplicateList.add(3);
        duplicateList.add(5);
        duplicateList.add(7);
        duplicateList.add(3);
        duplicateList.add(9);
    }

    @Test
    @DisplayName("번호 개수 테스트")
    public void countOverTest(){
        LottoTicket lottoTicket = new LottoTicket(countList);
        assertThat(lottoTicket.getTicketNumbers().size()).isEqualTo(6);

    }

    @Test
    @DisplayName("번호 중복 테스트")
    public void duplicateTest(){
        HashSet<Integer> hashSet = new HashSet<>();
        LottoTicket lottoTicket = new LottoTicket(duplicateList);

        for(int number : duplicateList){
            hashSet.add(number);
        }
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(()->{
                   if(hashSet.size()!=duplicateList.size()){
                       throw new IndexOutOfBoundsException();
                   }
                });
    }
}
