public class Snake extends Reptile implements TouchSense{
    private String species;

    public Snake(String name, int age) {
        super(name, age);
        this.species = "뱀";
        setFavoriteFood(Food.NUTS);
    }

    @Override
    public void play(ZooKeeper zooKeeper) {
        System.out.println(zooKeeper.getSpecialize() + " 전문 사육사가 " + getName() + "과 놀아줍니다.");

        if (zooKeeper.getSpecialize().equals("Reptile")) {
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
        if (zooKeeper.getSpecialize().equals("Reptile")) {
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
    public String specialAbilityName() {
        return "촉각";
    }

    @Override
    public void senseByTouch() {
        System.out.println(getName() + "가 촉각으로 감지합니다! 행복도가 크게 증가했습니다.");
        int newHappinessStat = Math.min(100, getHappinessStat() + 10);
        setHappinessStat(newHappinessStat);
    }

    @Override
    public void performSpecialAbility() {
        senseByTouch();
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
    public void sound() {
        System.out.println(getName() + "가 스으하고 소리를 냅니다.");
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
