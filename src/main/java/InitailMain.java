import java.util.ArrayList;
import java.util.List;

public class InitailMain implements Runnable{

    public static void main(String[] args) {
        System.out.println("I am back");
        List<String> arr = new ArrayList<>();
        arr.add("Hai");
        arr.forEach((str)->{
            System.out.println(str);
        });
    }

    @Override
    public void run() {

    }
}
