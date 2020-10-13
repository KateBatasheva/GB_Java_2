package Lesson1;

public class RunRoad implements Barrier {
    public RunRoad(int length, String name) {
        this.length = length;
        this.name = name;
    }

    private int length;
    private String name;


    @Override
    public boolean gerBarrier(Athletic athletic) {
        boolean result;
    if (athletic.getMaxRun() <length) {
         System.out.println(athletic.getName() + " пытается преодолеть препытствие "+ name + " и не может столько пробежать. Соревнование для него окончено.");
        result = true;
    } else {
        athletic.run(this);
        result = false;
    }
    return result;
    }

    @Override
    public void info() {
     System.out.println("Создана беговая дорожка " + name + " длиной " + length + " метров.");
    }

    @Override
    public int getLenght() {
        return length;
    }

    @Override
    public String getName() {
        return name;
    }
}
