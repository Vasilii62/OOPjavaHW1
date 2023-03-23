package Game;

/**
 * Создать класс Player с полями id (long), name (String), damage (double) healthPoint (hp) (double)
 *  У класса должен быть конструктор, который принимает только name. Идентификатор присваивается автоматически
 *  из последовательности (1, 2, ...) Каждый класс должен уметь "бить" другого
 *  Player'а void attack(Player player) -> player1.attack(player2)
 * Внутри метода игрок, на котором вызван метод уменьшает здоровье игрока, который передан в метод
 * Придумать несколько классов с разными параметрами жизней и атаки по-умолчанию
 * Player player = new Tank("name");
 * Придумать, все, что захочется и обогатить проект Понасоздавать объектов и стравить их друг с другом
 */
public class Program {
    public static void main(String[] args) throws InterruptedException {
        BaseHero[] party1 = {new Warrior(), new Magician(), new Priest(), new Rogue()};
        BaseHero[] party2 = {new Warrior(), new Magician(), new Priest(), new Rogue()};

        while (BaseHero.isPartyAlive(party1) && BaseHero.isPartyAlive(party2)){
            for (int i = 0; i < party2.length; i++) {
                if (party1[i].isAlive()) party1[i].fight(party2, party1);
                if (party2[i].isAlive()) party2[i].fight(party1, party2);
                // Thread.sleep(1000);
            }
        }
        if (BaseHero.isPartyAlive(party1)) System.out.println("party1 win");
        else System.out.println("party2 win");
    }
}