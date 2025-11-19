public class Elephant extends Mammal implements Sprayable {
    private String species;

    public Elephant(String name, int age) {
        super(name, age);
        this.species = "코끼리";
        setFavoriteFood(Food.VEGETABLE);
    }

    @Override
    public void play(ZooKeeper zooKeeper) {
        System.out.println(zooKeeper.getSpecialize() + " 전문 사육사가 " + getName() + "과 놀아줍니다.");

        if (zooKeeper.getSpecialize().equals("Mammal")) {
            int newHappinessStat = getHappinessStat() + 5;
            newHappinessStat = Math.min(100, newHappinessStat);
            setHappinessStat(newHappinessStat);
        } else {
            int newHappinessStat = getHappinessStat() + 1;
            newHappinessStat = Math.min(100, newHappinessStat);
            setHappinessStat(newHappinessStat);
        }
    }

    @Override
    public void feed(ZooKeeper zooKeeper, Food food) {
        if (this.getFavoriteFood() != food) {
            throw new RuntimeException();
        }
        System.out.println(zooKeeper.getSpecialize() + " 전문 사육사가 " + getName() + "에게 " + food.name() + "를 줍니다.");
        if (zooKeeper.getSpecialize().equals("Mammal")) {
            int newHungryStat = getHungryStat() - 5;
            newHungryStat = Math.max(0, newHungryStat);
            setHungryStat(newHungryStat);
        } else {
            int newHungryStat = getHungryStat() - 1;
            newHungryStat = Math.max(0, newHungryStat);
            setHungryStat(newHungryStat);
        }
    }

    @Override
    public void performSpecialAbility() {
        sprayWater();
    }

    @Override
    public void sound() {
        System.out.println(getName() + "가 뿌우하고 소리를 냅니다.");
    }

    @Override
    public String specialAbilityName() {
        return "물뿌리기";
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
    public void sprayWater() {
        System.out.println(getName() + "가 물을 뿌립니다! 행복도가 크게 증가했습니다.");
        int newHappinessStat = Math.min(100, getHappinessStat() + 10);
        setHappinessStat(newHappinessStat);
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
