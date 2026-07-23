public class ClassC {
    private boolean active;

    public ClassC(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public void toggleStatus() {
        active = !active;
        System.out.println("Status changed to: " + active);
    }
}