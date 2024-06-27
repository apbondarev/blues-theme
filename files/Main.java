import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        list.forEach(Main::doPrint);
        String str = "abcdef";
        System.out.println(str);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < list.size(); i++) {
                    doPrint(list.get(i));
                }
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(runnable).get(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
    }

    private static void doPrint(Integer number) {
        System.out.println(number);
    }
}