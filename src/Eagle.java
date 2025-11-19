public class Eagle extends Bird implements Flyable {
    private String species;

    public Eagle(String name, int age) {
        super(name, age);
        this.species = "독수리";
    }

    @Override
    public String getSpecies() {
        return species;
    }

    @Override
    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public void fly() {
        System.out.println(getName() + "가 하늘 높이 날아올랐습니다! 행복도가 크게 증가했습니다.");
        setHappinessStat(getHappinessStat() + 10);
    }

    @Override
    public void sound() {
        System.out.println(getName() + "가 끼륵하고 소리를 냅니다.");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("name = " + getName() + " ");
        sb.append("age = " + getAge() + " ");
        sb.append("hungryStat = " + getHungryStat() + " ");
        sb.append("happinessStat = " + getHappinessStat() + " ");
        sb.append("species = " + getSpecies() + "\n");
        return sb.toString();
    }
}
