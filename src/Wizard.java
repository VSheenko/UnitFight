import javax.naming.Name;

public class Wizard extends Unit {
    float mana;

    Wizard () {
        super(100, 12, 1);
        name = "Wz";
        mana = 100;
    }

    @Override
    public String toString() {
        return "Wizard{" +
                "name=" + name +
                ", health='" + health + '\'' +
                ", mana=" + mana +
                '}';
    }
}
