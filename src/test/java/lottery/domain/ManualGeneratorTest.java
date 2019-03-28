package lottery.domain;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ManualGeneratorTest {

    private LotteryMachine lotteryMachine = new LotteryMachine();

    @Test
    public void 수동_생성_테스트() {
        ManualGenerator manualGenerator = new ManualGenerator(Fixture.manualNumbers, new Money(2000,1));
        System.out.println(manualGenerator.generate().toString());
    }

}