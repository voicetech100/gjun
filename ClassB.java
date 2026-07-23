public class ClassB {
    private String category;

    public ClassB(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void process() {
        System.out.println("Processing category: " + category);
    }
}