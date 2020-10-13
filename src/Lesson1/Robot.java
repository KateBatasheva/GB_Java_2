package Lesson1;

public class Robot implements Athletic{
    private String name;
    private int maxRun;
    private int maxJump;

    public Robot(String name, int maxRun, int maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    @Override
    public void run(Barrier barrier) {
        System.out.println(name + " преодолел препятствие "+ barrier.getName() + " и пробежал " + barrier.getLenght() + " метров. Следует далее.");
    }

    @Override
    public void jump(Barrier barrier) {
        System.out.println(name + " преодолел препятствие "+ barrier.getName() + " и прыгнул на " + barrier.getLenght()  + " метров.");
    }

    @Override
    public void info() {
        System.out.println(name + " может бегать на "+ maxRun + " метров и прыгать на "+ maxJump+ " метров.");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getMaxRun() {
        return maxRun;
    }

    @Override
    public int getMaxJump() {
        return maxJump;
    }
}
