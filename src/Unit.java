import java.security.SecureRandom;

public class Unit {
    protected String name;
    protected double health;
    protected double damage;
    protected double armor;

    SecureRandom rand = new SecureRandom();

    Unit (float health, float damage, float armor) {
        this.armor = armor;
        this.damage = damage;
        this.health = health;
    }

    protected double GetDamagePoint () {
        return damage;
    }

    public void Attack (Unit unit) {
        System.out.print(name + " =Attack=> " + unit.name + " ");
        unit.GetDamage(unit.GetDamagePoint());
    }

    protected void GetDamage (double damage) {
        int t = rand.nextInt(10);
        if (t == 0) {
            System.out.print("(Crit) ");
            damage *= 1.5;
        }

        health = health * (1 + (0.02 * armor)) - damage;
        if (health > 100) health = 100;
        if (health < 0) health = 0;
        System.out.println(">> " + health);
    }
}
