package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

class PapersTest {
    private Papers papers;

    @BeforeEach
    void PapersCreate() {
        papers = new Papers(3);
    }

    @Test
    void getPapersTest() {
        Assertions.assertThat(papers.getPapers().size()).isEqualTo(3);
    }

    @Test
    void test() {
        List<Integer> winningNumber = Arrays.asList(1,5,10,15,20,25,30,35,40,45);


        for (int i=0; i< papers.getPapers().size(); i++) {
            int result =0;
            for (int j=0; j<winningNumber.size(); j++) {
                result = papers.getPapers().get(i).isContains(winningNumber.get(j)) == true ? result + 1 : result;
            }
//            papers.getPapers().get(i).getNums().stream().filter(integer -> integer ==1).reduce(Integer::sum);
            System.out.println(result);
        }
        papers.getPapers().stream().forEach(paper ->
                System.out.println(paper.getNums())
        );
    }
}