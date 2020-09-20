package Lesson1;

public class Wall implements Barrier {


    private String name;
    private int hight;

    @Override
    public int getLenght() {
        return hight;
    }
    @Override
    public String getName() {
        return name;
    }

    public Wall(int hight, String name) {
        this.hight = hight;
        this.name = name;
    }


    @Override
    public boolean gerBarrier(Athletic athletic) {
        boolean result;
        if (athletic.getMaxJump() <hight) {
            System.out.println(athletic.getName() + " пытается преодолеть препытствие "+ name + " и не может так высоко прыгнуть. Соревнование для него окончено.");
            result = true;
        } else {
            athletic.jump(this);
            result = false;
        }
        return result;
    }

    @Override
    public void info() {
        System.out.println("Создана стена " + name + " длиной " + hight + " метров.");
    }
}
