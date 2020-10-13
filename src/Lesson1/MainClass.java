package Lesson1;

/*
1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять соответствующие действия (бежать или прыгать),
результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
4*. У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.
Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.
*/

import java.util.Random;

public class MainClass {
    static Random random = new Random();

    public static void main(String[] args) {
        Athletic[] athletics = new Athletic[random.nextInt(5) + 10];

        System.out.println("Всего создано " + athletics.length + " спортсменов:");
        for (int i = 0, c = 1, h = 1, r = 1; i < athletics.length; i++) {
            if (i < athletics.length / 3) {
                athletics[i] = new Cat("Кошка " + c++, random.nextInt(1000) + 300, random.nextInt(5) + 2);
            } else if (i < (athletics.length / 3 * 2)) {
                athletics[i] = new Robot("Робот " + r++, random.nextInt(3000) + 600, random.nextInt(10) + 6);
            } else {
                athletics[i] = new Human("Человек " + h++, random.nextInt(2000) + 450, random.nextInt(3) + 1);
            }
        }
        for (Athletic atlet : athletics) {
            atlet.info();
        }
        Barrier[] barriers = new Barrier[random.nextInt(5) + 5];
         System.out.println();
        System.out.println("Всего создано " + barriers.length + " барьеров:");
        for (int i = 0, w = 1, r = 1; i < barriers.length; i++) {
            if (i < barriers.length / 2) {
                barriers[i] = new Wall(random.nextInt(2) + 2, "Стена " + w++);
            } else {
                barriers[i] = new RunRoad(random.nextInt(1000) + 100, "Беговая дорожка " + r++);
            }
        }

        for (Barrier barrier : barriers) {
            barrier.info();
        }
         System.out.println();
         System.out.println("Начинаются соревнования:");
        for (int i = 0; i < athletics.length; i++) {
            for (int j = 0; j < barriers.length; j++) {
                    if (barriers[j].gerBarrier(athletics[i])) {
                        break;
                    }
            }
            System.out.println();
        }
    }
}



