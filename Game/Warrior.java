package Game;

public class Warrior extends BaseHero{

    Warrior(String name){
        super(name, 150, 30, 0.3, 5, 10);
    }

    Warrior(){
        this("Warrior");
    }

    public void doubleStrike(BaseHero target) {
        if (this.cast(this.dmg)) {
            this.toAttack(target);
            this.toAttack(target);
        }
    }

    public void toGiveHp(BaseHero[] targets) {
        for (BaseHero target : targets) {
            target.healing(this.mp);
        }
        this.damage(mp);
        this.cast(mp);
    }

    @Override
    public void fight(BaseHero[] enemies, BaseHero[] friends) {
        if (this.mp <= this.dmg && this.mp != 0 && this.hp >= this.maxHp / 2){
            this.toGiveHp(friends);
            System.out.println(this.toString() + " giveHP");
        }else if (this.mp >= 2 * this.dmg){
            this.doubleStrike(enemies[getMinHpIndex(enemies)]);
            System.out.println(this.toString() + " doubleStrike " + enemies[getMinHpIndex(enemies)].name);
        }else{
            this.toAttack(enemies[getMinHpIndex(enemies)]);
            System.out.println(this.toString() + " attack " + enemies[getMinHpIndex(enemies)].name);
        }
    }
}
