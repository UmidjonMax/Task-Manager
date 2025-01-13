public class Task {
    int id;
    String title;
    String description;
    String status;

    public Task(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = "NOT_ACTIVE";
    }
    public Task(){}

    public String toString() {
        return "id: " + this.id + "\n" +
                "title: " + this.title + "\n" +
                "description: " + this.description + "\n" +
                "status: " + this.status + "\n";
    }
}
