public class Main {
    public static void main(String[] args) {
        String[] disciplines = {
                "Математика", "Физика", "Программирование", "История", "Литература",
                "Химия", "Биология", "География", "Английский", "Физкультура"
        };

        Thread group1 = new Thread(new GroupSchedule("Группа 1", disciplines), "Group1-Thread");
        Thread group2 = new Thread(new GroupSchedule("Группа 2", disciplines), "Group2-Thread");

        group1.start();
        group2.start();

        try {
            group1.join();
            group2.join();
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
        }

        System.out.println("Симуляция учебного дня завершена");
    }
}