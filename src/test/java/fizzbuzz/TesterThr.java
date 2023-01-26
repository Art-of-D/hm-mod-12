package fizzbuzz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TesterThr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Print a number!");
        int num = in.nextInt();

        ProcessThread aThread = new ProcessThread(i -> ProcessThread.fizz(i));
        ProcessThread bThread = new ProcessThread(i -> ProcessThread.buzz(i));
        ProcessThread cThread = new ProcessThread(i -> ProcessThread.fizzbuzz(i));
        ProcessThread dThread = new ProcessThread(i -> ProcessThread.number(i));

        List<ProcessThread> thrds = new ArrayList<>();
        thrds.add(aThread);
        thrds.add(bThread);
        thrds.add(cThread);
        thrds.add(dThread);

        for (ProcessThread thread : thrds) {
            thread.start();
        }

        for(int i = 1; i <= num; i++){

            for (ProcessThread thread : thrds) {
                thread.process(i);
            }

            while (true) {
                int processedCount = 0;
                for (ProcessThread thread : thrds) {
                    if (thread.isProcessed()) {
                        processedCount++;
                    }
                }
                if (processedCount == thrds.size()) {
                    break;
                }
            }
        }
    }
}
