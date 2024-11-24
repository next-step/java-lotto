import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CandidatesRanksTest {
    @Test
    void get_rank_count() {
        Lotto winning = new Lotto("1,2,3,4,5,6");

        Lotto candidate_1 = new Lotto("1,2,3,4,5,6");
        Lotto candidate_2 = new Lotto("1,2,3,4,5,6");
        Lotto candidate_3 = new Lotto("1,2,3,4,5,16");
        Lotto candidate_4 = new Lotto("1,2,3,4,15,16");

        CandidateRanks ranks = new CandidateRanks();
        ranks.add(new CandidateRank(winning, candidate_1));
        ranks.add(new CandidateRank(winning, candidate_2));
        ranks.add(new CandidateRank(winning, candidate_3));
        ranks.add(new CandidateRank(winning, candidate_4));

        assertThat(ranks.countFirst()).isEqualTo(2);
        assertThat(ranks.countThird()).isEqualTo(1);
        assertThat(ranks.countFourth()).isEqualTo(1);
        assertThat(ranks.countFifth()).isEqualTo(0);
    }

    @Test
    void calculate_benefit_percent(){
        CandidateRanks ranks = new CandidateRanks();

        ranks.add(new MatchCount(4));
        ranks.add(new MatchCount(0));
        ranks.add(new MatchCount(1));

        double benefitPercent = ranks.calcBenefitPercent();

        assertThat(benefitPercent).isEqualTo(16.67);
    }
}
