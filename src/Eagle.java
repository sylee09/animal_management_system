public class Eagle extends Bird implements Flyable {
    private String species;

    public Eagle(String name, int age) {
        super(name, age);
        this.species = "독수리";
        setFavoriteFood(Food.MEAT);
    }

    @Override
    public void play(ZooKeeper zooKeeper) {
        if (zooKeeper.getSpecialize().equals("Bird")) {
            System.out.println("조류 전문 사육사가 " + getName() + "과 놀아줍니다.");
            int newHappinessStat = getHappinessStat() + 5;
            newHappinessStat = Math.min(100, newHappinessStat);
            setHappinessStat(newHappinessStat);
        } else {
            super.play(zooKeeper);
        }
    }

    @Override
    public void feed(ZooKeeper zooKeeper) {
        if (zooKeeper.getSpecialize().equals("Bird")) {
            System.out.println("조류 전문 사육사가 " + getName() + "에게 먹이를 줍니다.");
            int newHungryStat = getHungryStat() - 5;
            newHungryStat = Math.max(0, newHungryStat);
            setHungryStat(newHungryStat);
        } else {
            super.feed(zooKeeper);
        }
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
        int newHappinessStat = Math.min(100, getHappinessStat() + 10);
        setHappinessStat(newHappinessStat);
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
