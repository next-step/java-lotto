import controller.LottoController;
import view.Renderer;

public class Application {
    public static void main(String[] args) {
        LottoController game = new LottoController();
        try {
            game.play();
        }
        catch (Exception e) {
            Renderer.simplePrint("게임을 진행하던 중 다음의 에러가 발생했습니다:");
            Renderer.simplePrint(e.getMessage());
            Renderer.simplePrint("게임을 종료합니다.");
        }
    }
}
