public class ClassA {
    private String name;
    private int version;

    public ClassA(String name, int version) {
        this.name = name;
        this.version = version;
    }

    public String getInfo() {
        return name + " - v" + version;
    }
}