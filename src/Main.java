import java.util.Scanner;

public class Main {
    static Task[] tasks = new Task[10];
    static {
        Task task = new Task();
        task.id = 1;
        task.title = "zalga borish";
        task.description = "Soat 14 00 da Wellness Gym ga borish";
        task.status = "NOT_ACTIVE";
        tasks[0] = task;

        Task task2 = new Task();
        task2.id = 2;
        task2.title = "kursga borish";
        task2.description = "Soat 14 00 da brainga kursga borish";
        task2.status = "NOT_ACTIVE";
        tasks[1] = task2;
    }
    static Scanner scannerNum = new Scanner(System.in);
    static Scanner scannerStr = new Scanner(System.in);
    static int generalId = 3;
    static int index = 2;
    public static void main(String[] args) {
        while (true) {
            menu();
            int n = getAction();
            switch (n){
                case 1-> tasks[index++] = addTask();
                case 2-> showTasks();
                case 3-> editTask();
                case 4-> changeById();
                case 5-> searchTask();
                case 6-> deleteTask();
                case 7-> activeTask();
                case 8-> notActiveTask();
                case 0-> {
                    return;
                }
            }
        }
    }
    public static void showTasks() {
        for (Task task : tasks){
            if (task != null){
                System.out.println(task);
            }
        }
    }

    private static void menu() {
        String menu = """
                😊😊😊TASK😊😊😊
                1.Add Task
                2.Show Task
                3.Edit Task
                4.Change status by id
                5.Search
                6.Delete
                7.Active tasks
                8.Not Active tasks
                0.Log out
                """;
        System.out.println(menu);
    }

    public static int getAction(){
        System.out.print("Enter option : ");
        return scannerNum.nextInt();
    }


    public static Task addTask(){
        System.out.print("Enter title : ");
        String title = scannerStr.nextLine();

        System.out.print("Enter description : ");
        String description = scannerStr.nextLine();

        return new Task(generalId++,title,description);
    }
    public static void editTask(){
        showTasks();
        System.out.print("Choose task to edit : ");
        int id = scannerNum.nextInt();
        System.out.print("Enter title : ");
        tasks[id-1].title = scannerStr.nextLine();
        System.out.print("Enter description : ");
        tasks[id-1].description = scannerStr.nextLine();
        System.out.println("Task edited successfully : ");
    }
    public static void changeById(){
        showTasks();
        System.out.print("Choose id : ");
        int id = scannerNum.nextInt();
        if (tasks[id-1] != null){
            if (tasks[id-1].status.equals("NOT_ACTIVE")) {
                tasks[id - 1].status = "ACTIVE";
            }else {
                tasks[id - 1].status = "NOT_ACTIVE";
            }
            System.out.println("Task status changed successfully : ");
            showTasks();
        }else {
            System.out.println("No task found");
        }
    }
    public static void searchTask(){
        System.out.print("Enter query : ");
        String query = scannerStr.nextLine();
        boolean found = false;
        for (Task task : tasks){
            if (task != null){
            if (task.title.contains(query) || task.description.contains(query)) {
                System.out.println(task);
                found = true;
            }
            }
        }if (!found) System.out.println("No task found");
    }
    public static void deleteTask(){
        showTasks();
        System.out.print("Choose task id to delete : ");
        int id = scannerNum.nextInt();
        if (id>0 && tasks[id-1] != null && id< tasks.length){
            tasks[tasks.length-1] = null;
            System.out.println("Task deleted successfully : ");
        }else{
            System.out.println("No task found");
        }
    }
    public static void activeTask(){
        boolean found = false;
        for(Task task : tasks){
            if (task != null && task.status.equals("ACTIVE")){
                System.out.println(task);
                found = true;
            }if (!found) System.out.println("No active tasks");
        }
    }
    public static void notActiveTask(){
        boolean found = false;
        for(Task task : tasks){
            if (task != null && task.status.equals("NOT_ACTIVE")){
                System.out.println(task);
                found = true;
            }if (!found) System.out.println("No not active tasks");
        }
    }
}