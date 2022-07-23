import controller.ClanController;

public class Main {
    public static void main(String[] args) {

        ClanController controller = new ClanController();
        controller.incGold(1, 2124, 234);
        controller.incGold(2, 3256, -340);
        controller.incGold(3, 6704, 4);
        controller.incGold(3, 6704, 1000);
        controller.incGold(3, 6704, -100);

    }
}
