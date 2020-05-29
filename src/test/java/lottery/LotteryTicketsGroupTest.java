package lottery;

public class LotteryTicketsGroupTest {
/*
    private List<LotteryTicket> lotteryTicketList;

    @BeforeEach
    public void setupLotteryTicket() {
        List<LotteryNumber> lotteryNumberList = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            lotteryNumberList.add(new LotteryNumber(i));
        }
        LotteryTicket lotteryTicket = new LotteryTicket(lotteryNumberList);
        lotteryTicketList = Arrays.asList(lotteryTicket, lotteryTicket);
    }

    @DisplayName("LotteryTicketsGroup 정상 생성 테스트")
    @Test
    public void makeLotteryTicketsGroupObject() {
        assertThatCode(() -> {
            LotteryTicketsGroup lotteryTicketsGroup = new LotteryTicketsGroup(lotteryTicketList);
        }).doesNotThrowAnyException();

        LotteryTicketsGroup lotteryTicketsGroup = new LotteryTicketsGroup(lotteryTicketList);
        assertThat(lotteryTicketsGroup.getClass())
                .isEqualTo(LotteryTicketsGroup.class);
    }

    @DisplayName("LotteryTicket 들의 번호 리스트를 추출해오는 테스트")
    @Test
    public void getLotteryTicketsNumbers() {
        LotteryTicketsGroup lotteryTicketsGroup = new LotteryTicketsGroup(lotteryTicketList);

        List<List<Integer>> lotteryTicketsNumbers = lotteryTicketsGroup.getLotteryTicketsNumbers();
        List<Integer> oneToSixList = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<List<Integer>> targetList = Arrays.asList(oneToSixList, oneToSixList);

        assertThat(lotteryTicketsNumbers).isEqualTo(targetList);
    }*/
}
