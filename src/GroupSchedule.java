import java.util.Random;

class GroupSchedule implements Runnable {
    private final String groupName;
    private final String[] disciplines;
    private final Random random;

    public GroupSchedule(String groupName, String[] disciplines) {
        this.groupName = groupName;
        this.disciplines = disciplines;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (int lesson = 1; lesson <= 5; lesson++) {
            String discipline = disciplines[random.nextInt(disciplines.length)];
            System.out.println(groupName + ": Пара " + lesson + " началась, дисциплина: " + discipline);
            try {
                Thread.sleep(5000); // Пара длится 5000 мс
            } catch (InterruptedException e) {
                System.out.println(groupName + ": Пара прервана");
                return;
            }
            System.out.println(groupName + ": Пара " + lesson + " закончилась");
            if (lesson < 5) {
                System.out.println(groupName + ": Перемена началась");
                try {
                    Thread.sleep(1500); // Перемена длится 1500 мс
                } catch (InterruptedException e) {
                    System.out.println(groupName + ": Перемена прервана");
                    return;
                }
                System.out.println(groupName + ": Перемена закончилась");
            }
        }
        System.out.println(groupName + ": Учебный день завершен");
    }
}