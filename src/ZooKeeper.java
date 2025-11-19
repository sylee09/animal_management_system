public class ZooKeeper {
    String specialize;

    public ZooKeeper(String specialize) {
        this.specialize = specialize;
    }

    public String getSpecialize() {
        return specialize;
    }

    public void setSpecialize(String specialize) {
        this.specialize = specialize;
    }

    @Override
    public String toString() {
        return "ZooKeeper{" +
                "specialize='" + specialize + '\'' +
                '}';
    }
}
