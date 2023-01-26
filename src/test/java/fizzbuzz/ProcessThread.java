package fizzbuzz;

import java.util.concurrent.atomic.AtomicBoolean;

public class ProcessThread extends Thread {
    private int number;
    private AtomicBoolean processed = new AtomicBoolean(true);
    private static String string = "";
    private Processor processor;

    public ProcessThread(Processor processor){
        this.processor = processor;
    }

    public boolean isProcessed() {
        return processed.get();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (processed.get()) {
                continue;
            }
            processor.process(number);

            processed.set(true);
        }
    }

    public void process(int number){
        this.number = number;
        processed.set(false);
    }

    public static void fizz(int number){
        if (number % 3 == 0) {
              string = "fizz";
        }
    }

    public static void buzz(int number){
        if (number % 5 == 0) {
           string = "buzz";
        }
    }

    public static void fizzbuzz(int number){
        if (number % 3 == 0 && number % 5 == 0) {
            string ="fizzbuzz";
        }
    }

    public static void number(int number){
        if (!string.isEmpty()){
            System.out.println(string);
            string = "";
        } else {
            System.out.println(number);
        }
    }
}
