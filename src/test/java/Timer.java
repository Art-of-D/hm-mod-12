
class TimerTest {
    public static void main(String[] args) {
        while (Timer.getTimer() < 30) {
            try {
                Thread.sleep(100);
                Timer.setTimer();
                System.out.println("Минуло - " + Timer.getTimer());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Thread thread = new Thread(() -> {
                if (Timer.getTimer() % 5 == 0){
                    try {
                        System.out.println("Минуло 5 секунд");
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            thread.start();
        }
    }
}

class Timer {
    static long timer = 0l;
    public static long getTimer() {
        return timer;
    }
    public static void setTimer() {
        timer++;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}