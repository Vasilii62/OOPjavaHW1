package Game;

public class Rogue extends BaseHero{

    Rogue(String name){
        super(name, 100, 20, 0.1, 15, 20);
    }

    Rogue(){
        this("Rogue");
    }

    public void exactStrike(BaseHero target) {
        if (this.cast(this.dmg / 4)) {
            if (this.getId() != target.getId() && target.isAlive()){
                target.damage(this.dmg);
            }
        }
    }

    public void sneakyStrike(BaseHero target) {
        if (this.cast(this.dmg)) {
            if (this.getId() != target.getId() && target.isAlive()) {
                target.damage(rand.nextInt((int)this.dmg * 2 - 3, (int)this.dmg * 2 + 4) * (1 - target.def));
            }
        }
    }

    @Override
    public void fight(BaseHero[] enemies, BaseHero[] friends) {
        if (this.mp >= this.dmg && enemies[getMinHpIndex(enemies)].hp <= this.dmg){
            this.sneakyStrike(enemies[getMinHpIndex(enemies)]);
            System.out.println(this.toString() + " sneakyStrike " + enemies[getMinHpIndex(enemies)].name);
        }else if (this.mp >= this.dmg / 4){
            this.exactStrike(enemies[getMinHpIndex(enemies)]);
            System.out.println(this.toString() + " exactStrike " + enemies[getMinHpIndex(enemies)].name);
        }else{
            this.toAttack(enemies[getMinHpIndex(enemies)]);
            System.out.println(this.toString() + " attack " + enemies[getMinHpIndex(enemies)].name);
        }
    }
}
