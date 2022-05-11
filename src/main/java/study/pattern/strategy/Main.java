package study.pattern.strategy;

// https://catsbi.oopy.io/344dbe7b-9774-48fc-9c95-b554e9c1c4bc
public class Main {
    public static void main(String[] args) {
        GameCharacter character = new GameCharacter();
        character.attack();

        character.setWeapon(new Knife());
        character.attack();

        character.setWeapon(new Sword());
        character.attack();
    }
}
